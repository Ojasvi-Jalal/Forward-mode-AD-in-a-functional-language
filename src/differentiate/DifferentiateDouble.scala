package differentiate

import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._

import scala.collection.mutable
import scala.language.implicitConversions

object DifferentiateDouble {
  val paramToArg = mutable.HashMap[Param,Expr]()

  def differentiate(e : Expr, withRespectTo : Param, hm : mutable.HashMap[Param, Double] = mutable.HashMap[Param, Double]()) : Double = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case DoubleLiteral(d) => java.lang.Double.valueOf(0)
      case p:Param => if(Var(p)=== Var(withRespectTo)) {
          return java.lang.Double.valueOf(1)}
                      else{java.lang.Double.valueOf(0)}
      case FunctionCall(FunctionCall(_:AddDouble, arg2),arg1) =>  differentiate(arg1, withRespectTo) + differentiate(arg2, withRespectTo)
      case FunctionCall(FunctionCall(_:MultiplyDouble, arg2),arg1) => {
        differentiateProduct(arg1, arg2, withRespectTo)
      }
      case FunctionCall(FunctionCall(_:DivideDouble, arg1),arg2) => differentiateDivision(arg1,arg2, withRespectTo)
//      case FunctionCall(FunctionCall(_:PowerDouble, arg2),arg1) => {
//        val exponent  = arg1//java.lang.Double.valueOf(eval(arg1))
//        val base      = arg2//java.lang.Double.valueOf(eval(arg2))
//        scala.math.pow(base,exponent)
//      }
//      case FunctionCall(Lambda(param,body),arg) =>
//        // store in a map   param -> arg and eval body
//        paramToArg.put(param, arg)
//        eval(body,hm)
//      case p:Param =>
//        // fish it up from the map and eval the expr
//        eval(paramToArg(p))
    }
  }

  def differentiateProduct(lhs: Expr, rhs: Expr, param: Param): Double = {
    (lhs, rhs) match {
      case (DoubleLiteral(d), exp) => DoubleEvaluator.eval(lhs) * differentiate(exp, param)
      case (exp, DoubleLiteral(d)) => differentiate(lhs, param) * DoubleEvaluator.eval(rhs)
      case (e1, e2) => (differentiate(e1, param) * DoubleEvaluator.eval(e2)) + (differentiate(e2, param) * DoubleEvaluator.eval(e1))
    }
  }

  def differentiateDivision(numerator: Expr, denominator: Expr, param: Param): Double = {
    (numerator, denominator) match {
      case (DoubleLiteral(d), exp) => var new_numerator = - DoubleEvaluator.eval(numerator) * differentiate(denominator, param)
        var new_denominator = denominator ^ DoubleLiteral(2)
        var result = new_numerator / DoubleEvaluator.eval(new_denominator)
        result
      case (exp, DoubleLiteral(d)) => var new_numerator = DoubleEvaluator.eval(denominator) * differentiate(numerator, param)
        var new_denominator = denominator ^ DoubleLiteral(2)
        var result  = new_numerator / DoubleEvaluator.eval(new_denominator)
        result
      case (e1, e2) => var new_numerator = ((differentiate(e1, param) * DoubleEvaluator.eval(e2)) - (differentiate(e2, param) * DoubleEvaluator.eval(e1)))
        var new_denominator = (e2 ^ DoubleLiteral(2))
        var result = new_numerator / DoubleEvaluator.eval(new_denominator)
        result
    }
  }
}