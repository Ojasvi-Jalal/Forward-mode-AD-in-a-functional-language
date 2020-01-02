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

//What you need to do should be pretty simple since conceptually all you want to do is create an SSA form where each expression is assigned to a single variable. So x^2 + y^2 should become something like (in this version I have "inlined" the power, but I can imagine that you could also leave it as it is and have slightly less statements):
//
//v0=x;
//v1=x;
//v2=v0*v1;
//v3=y;
//v4=y;
//v5=v3*v4;
//v6=v2+v5;
//
//which can be easily represented with a lot of nested Let.

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

        var z_prime = Let(v_0,DifferentiateExpr.differentiate(v_0, v_0, hm),
          Let(v_1,DifferentiateExpr.differentiate(v_1, v_0, hm),
            Let(v_2,DifferentiateExpr.differentiate(paramToArg(v_2), v_0, hm),v_2)))

        Evaluator.eval(z_prime)

      //case FunctionCall(FunctionCall(_: MultiplyDouble, arg1), arg2) =>
    }
  }
}

//differentiate_x = FunctionCall(Lambda(v_0,FunctionCall(Lambda(v_1,FunctionCall(Lambda(FunctionCall(FunctionCall(AddDouble(v_1),v_1),v_0),FunctionCall(FunctionCall(AddDouble(v_1),v_1),v_0)),FunctionCall(FunctionCall(AddDouble(1.0),1.0),0.0))),0.0)),1.0)
//differentiate_Product = FunctionCall(Lambda(v_0,FunctionCall(Lambda(v_1,FunctionCall(Lambda(FunctionCall(FunctionCall(MultiplyDouble(v_1),v_1),v_0),FunctionCall(FunctionCall(MultiplyDouble(v_1),v_1),v_0)),((v_0 * 0.0) + (v_1 * 1.0)))),0.0)),1.0)
