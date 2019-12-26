package automaticDifferentiation

import eval.{Evaluator}
import intermediateRep._
import differentiate.Differentiate

import scala.collection.mutable
import scala.language.implicitConversions

object AutomaticDifferentiateExpr {
  val paramToArg = mutable.HashMap[Param,Expr]()

  def autoDifferentiate(e : Expr, withRespectTo : Param, hm : mutable.HashMap[Param, Double] = mutable.HashMap[Param, Double]()) : Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case DoubleLiteral(d) => DoubleLiteral(0)
      case p:Param => if(Var(p)=== Var(withRespectTo)) {
          DoubleLiteral(1)}
                      else{DoubleLiteral(0)}
      case FunctionCall(FunctionCall(_:PowerDouble, arg1),arg2) => {
        differentiatePower(arg1, arg2, withRespectTo)
      }
      case FunctionCall(FunctionCall(_:AddDouble, arg1),arg2) =>  {
        //Forward Primal Trace
        val v_0 = arg1
        val v_1 = arg2
        val v_2 = v_0 + v_1
        val y = v_2

        //Forward Tangent (Derivative Trace)
        val v_0_prime = Differentiate.differentiate(arg1, withRespectTo)
        val v_1_prime =  Differentiate.differentiate(arg2, withRespectTo)
        val v_2_prime = Evaluator.eval(v_0_prime + v_1_prime)
        val y_prime = v_2_prime

        return y_prime
      }
      case FunctionCall(FunctionCall(_:MultiplyDouble, arg1),arg2) => {
        differentiateProduct(arg1, arg2, withRespectTo)
      }
      case FunctionCall(FunctionCall(_:DivideDouble, arg1),arg2) => differentiateDivision(arg1,arg2, withRespectTo)
    }
  }

  def differentiateProduct(lhs: Expr, rhs: Expr, param: Param): Expr = {
    (lhs, rhs) match {
      case (DoubleLiteral(d), exp) => Evaluator.eval(lhs * autoDifferentiate(exp, param))
      case (exp, DoubleLiteral(d)) => Evaluator.eval(autoDifferentiate(lhs, param) * rhs)
      case (e1, e2) => Evaluator.eval((autoDifferentiate(e1, param) * e2) + (autoDifferentiate(e2, param) * e1))
    }
  }

  def differentiatePower(base: Expr, exponent: Expr, withRespectTo: Param): Expr = {
    (base, exponent) match {
      case (DoubleLiteral(base), DoubleLiteral(exponent)) => DoubleLiteral(0)

      case (e1, DoubleLiteral(0)) => DoubleLiteral(0)

      case (e1, DoubleLiteral(d)) => Evaluator.eval(DoubleLiteral(d) * Evaluator.eval(e1 ^ Evaluator.eval(DoubleLiteral(d) + DoubleLiteral(-1))))

      //case (e1, e2) => Evaluator.eval(e2 * Evaluator.eval(e1 ^ Evaluator.eval(e2 + DoubleLiteral(-1))))
    }
  }
  def differentiateDivision(numerator: Expr, denominator: Expr, param: Param): Expr = {
    (numerator, denominator) match {
      case (DoubleLiteral(d), exp) => var new_numerator = DoubleLiteral(-d) * autoDifferentiate(denominator, param)
        var new_denominator = denominator ^ DoubleLiteral(2)
        var result = new_numerator / new_denominator
        result

      case (exp, DoubleLiteral(d)) => {
        differentiateProduct(DoubleLiteral(1/d),exp,param)
      }

      case (e1, e2) => var new_numerator = ((autoDifferentiate(e1, param) * e2)) + (DoubleLiteral(-1)*autoDifferentiate(e2, param) * e1)
        var new_denominator = (e2 ^ DoubleLiteral(2))
        var result = new_numerator / new_denominator
        Evaluator.eval(result)
    }
  }
}