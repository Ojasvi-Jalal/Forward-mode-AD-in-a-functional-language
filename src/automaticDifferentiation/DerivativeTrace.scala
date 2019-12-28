package automaticDifferentiation

import differentiate.DifferentiateExpr

import eval.DoubleEvaluator.{eval, paramToArg}
import _root_.eval.{DoubleEvaluator, Evaluator}
import intermediateRep._

import scala.collection.mutable
import scala.language.implicitConversions

object DerivativeTrace {
  val paramToArg = mutable.HashMap[Expr, Expr]()

  def derivativeTrace(e: Expr, withRespectTo: Param, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case FunctionCall(Lambda(param, body), arg) =>
        // store in a map   param -> arg and eval body
        paramToArg.put(arg.asInstanceOf[Expr], param)
        derivativeTrace(body, withRespectTo, paramToArg)
      case FunctionCall(FunctionCall(_, arg1), arg2) => {
        var v_0_prime = Param("v_0_prime")
        var v_1_prime = Param("v_1_prime")
        var v_2_prime = Param("v_2_prime")
        var y_prime = Let(DifferentiateExpr.differentiate(arg1 , withRespectTo, hm),v_0_prime, Let(DifferentiateExpr.differentiate(arg2 ,withRespectTo, hm), v_1_prime, Let(DifferentiateExpr.differentiate(arg2 ,withRespectTo, hm), v_2_prime, e)))
        Evaluator.eval(y_prime)
      }
    }
  }
}