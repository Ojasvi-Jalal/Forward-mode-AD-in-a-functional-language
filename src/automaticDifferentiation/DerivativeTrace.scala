package automaticDifferentiation

import differentiate.{Differentiate, DifferentiateExpr}
import eval.DoubleEvaluator.{eval, paramToArg}
import _root_.eval.{DoubleEvaluator, Evaluator}
import intermediateRep._
import sun.util.resources.cldr.wae.LocaleNames_wae

import scala.collection.mutable
import scala.language.implicitConversions

//take y and write a pass that traverses it. This pass should
//produce a new program (again full of Let for the v_i' variables)
//which corresponds to the derivative for each variable.

object DerivativeTrace {
  val paramToArg = mutable.HashMap[Expr, Expr]()

  def derivativeTrace(e: Expr, withRespectTo: Param, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case FunctionCall(Lambda(param, body), arg) =>
        // store in a map   param -> arg and eval body
        paramToArg.put(arg.asInstanceOf[Expr], param)
        derivativeTrace(body, withRespectTo, paramToArg)
      case FunctionCall(FunctionCall(_, _), _) =>
        var v_0       = Param("v_0")
        var v_1       = Param("v_1")
        var v_2       = Param("v_2")
        var v_0_prime = Param("v_0_prime")
        var v_1_prime = Param("v_1_prime")
        var v_2_prime = Param("v_2_prime")

        var z_prime = Let(v_0,DifferentiateExpr.differentiate(paramToArg(v_0), paramToArg(v_0).asInstanceOf[Param]),
          Let(v_1,DifferentiateExpr.differentiate(paramToArg(v_1), paramToArg(v_0).asInstanceOf[Param]),
            Let(v_2,DifferentiateExpr.differentiate(paramToArg(v_2), paramToArg(v_0).asInstanceOf[Param]),paramToArg(v_2))))

        Evaluator.eval(z_prime)

      //case FunctionCall(FunctionCall(_: MultiplyDouble, arg1), arg2) =>
    }
  }
}