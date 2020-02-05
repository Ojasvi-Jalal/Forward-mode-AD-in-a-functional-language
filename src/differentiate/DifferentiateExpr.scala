package differentiate

import eval.Evaluator
import eval.DoubleEvaluator
import intermediateRep._

import scala.collection.mutable
import scala.language.implicitConversions

object DifferentiateExpr {
  val paramToArg = mutable.HashMap[Expr, Expr]()

  def differentiate(e : Expr, withRespectTo : Param, hm : mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()) : Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case DoubleLiteral(d) => DoubleLiteral(0)

      case p:Param =>
        if(!hm.isEmpty) {
          var newP = if (hm.contains(p)) Param(hm(p)+"") else p
          val newWithRespectTo = if (hm.contains(withRespectTo))  Param(hm(withRespectTo)+"") else withRespectTo

          if(Var(newP) === Var(newWithRespectTo)) {
            DoubleLiteral(1)}
          else{DoubleLiteral(0)}
        }

        else{
          if (Var(p)=== Var(withRespectTo)) {
            DoubleLiteral(1)}
                      else{DoubleLiteral(0)}}

      case FunctionCall(FunctionCall(_:PowerDouble, arg1),arg2) =>
        if(!hm.isEmpty) {
          val newarg1 = if (hm.contains(arg1)) hm(arg1) else arg1
          val newarg2 = if (hm.contains(arg2)) hm(arg2) else arg2
          val newWithRespectTo = if (hm.contains(withRespectTo))  hm(withRespectTo).asInstanceOf[Param] else withRespectTo
          differentiatePower(newarg1, newarg2, newWithRespectTo, hm)
        }

        else
          differentiatePower(arg1, arg2, withRespectTo)

      case FunctionCall(FunctionCall(_:AddDouble, arg2),arg1) =>
        if(!hm.isEmpty) {
          val newarg1 = if (hm.contains(arg1)) (hm(arg1)) else arg1
          val newarg2 = if (hm.contains(arg2)) (hm(arg2)) else arg2
          val newWithRespectTo = if (hm.contains(withRespectTo))  hm(withRespectTo).asInstanceOf[Param] else withRespectTo
          differentiate(newarg1, newWithRespectTo, hm) + differentiate(newarg2, newWithRespectTo, hm)
        }

        else {
          differentiate(arg1, withRespectTo) + differentiate(arg2, withRespectTo)
        }

      case FunctionCall(FunctionCall(_:MultiplyDouble, arg1),arg2) => {
        if(!hm.isEmpty) {
          val newarg1 = if (hm.contains(arg1)) hm(arg1) else arg1
          val newarg2 = if (hm.contains(arg2)) hm(arg2) else arg2
          val newWithRespectTo = if (hm.contains(withRespectTo))  hm(withRespectTo).asInstanceOf[Param] else withRespectTo
          differentiateProduct(newarg1, newarg2, newWithRespectTo, hm)
        }

        else
          differentiateProduct(arg1, arg2, withRespectTo, hm)
      }

      case FunctionCall(FunctionCall(_:DivideDouble, arg1),arg2) => differentiateDivision(arg1,arg2, withRespectTo)

      case (Lambda(param,body)) =>  Lambda(param, differentiate(body, withRespectTo))

      case Map(param, body, vector) => Map(param, differentiate(body, withRespectTo), vector)
    }
  }

  def differentiateProduct(lhs: Expr, rhs: Expr, param: Param, hm : mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()) : Expr = {
    (lhs, rhs) match {
      case (DoubleLiteral(d), exp) => Evaluator.eval(lhs * differentiate(exp, param, hm))

      case (exp, DoubleLiteral(d)) => Evaluator.eval(differentiate(lhs, param, hm) * rhs)

      case (e1, e2) => DoubleEvaluator.eval(((differentiate(e1, param, hm) * DoubleEvaluator.eval(e2, hm)) + (DoubleEvaluator.eval(differentiate(e2, param, hm)) * DoubleEvaluator.eval(e1, hm))))
    }
  }

  def differentiatePower(base: Expr, exponent: Expr, withRespectTo: Param, hm : mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()) : Expr = {
    (base, exponent) match {

      case (DoubleLiteral(base), DoubleLiteral(exponent)) => DoubleLiteral(0)

      case (e1, DoubleLiteral(0)) => DoubleLiteral(0)

      case (e1, DoubleLiteral(d)) => DoubleEvaluator.eval((DoubleLiteral(d) * DoubleEvaluator.eval(e1 ^ DoubleEvaluator.eval((DoubleLiteral(d) + DoubleLiteral(-1)), hm), hm)), hm)

      //case (e1, e2) => Evaluator.eval(e2 * Evaluator.eval(e1 ^ Evaluator.eval(e2 + DoubleLiteral(-1))))
    }
  }
  def differentiateDivision(numerator: Expr, denominator: Expr, param: Param): Expr = {
    (numerator, denominator) match {
      case (DoubleLiteral(d), exp) => var new_numerator = DoubleLiteral(-d) * differentiate(denominator, param)
        var new_denominator = denominator ^ DoubleLiteral(2)
        var result = new_numerator / new_denominator
        result

      case (exp, DoubleLiteral(d)) => {
        differentiateProduct(DoubleLiteral(1/d),exp,param)
      }

      case (e1, e2) => var new_numerator = ((differentiate(e1, param) * e2)) + (DoubleLiteral(-1)*differentiate(e2, param) * e1)
        var new_denominator = (e2 ^ DoubleLiteral(2))
        var result = new_numerator / new_denominator
        Evaluator.eval(result)
    }
  }
}