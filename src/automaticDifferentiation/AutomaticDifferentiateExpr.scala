package automaticDifferentiation

import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._
import differentiate.Differentiate

import scala.collection.mutable
import scala.language.implicitConversions

object AutomaticDifferentiateExpr {
  val paramToArg = mutable.HashMap[Expr, Expr]()

  def autoDifferentiate(e: Expr, withRespectTo: Param, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
//      case DoubleLiteral(d) => DoubleLiteral(0)
//      case p: Param => if (Var(p) === Var(withRespectTo))
//        DoubleLiteral(1)
//      else
//        DoubleLiteral(0)

      case FunctionCall(FunctionCall(_: AddDouble, arg1), arg2) =>
        var z = forwardPrimalTraceAddition(e, arg1, arg2, withRespectTo)
        DerivativeTrace.derivativeTrace(z,withRespectTo)
        //autoDifferentiate(e, withRespectTo)

      case FunctionCall(FunctionCall(_: MultiplyDouble, arg1), arg2) =>
        var z = forwardPrimalTraceProduct(e, arg1, arg2, withRespectTo)
        DerivativeTrace.derivativeTrace(z,withRespectTo)

      case FunctionCall(FunctionCall(_: DivideDouble, arg1), arg2) =>
        var z = forwardPrimalTraceDivision(e, arg1, arg2, withRespectTo)
        DerivativeTrace.derivativeTrace(z,withRespectTo)
    }
  }

  //take y and write a pass that traverses it. This pass should
  //produce a new program (again full of Let for the v_i' variables)
  //which corresponds to the derivative for each variable.

  def forwardPrimalTraceAddition(e: Expr, arg1: Expr, arg2: Expr, withRespectTo: Param, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr = {
    (arg1, arg2) match {
      case (_: Param, _: Param) =>
        var v_0 = Param("v_0")
        var v_1 = Param("v_1")
        var v_2 = Param("v_2")
        //var y = Let(v_1 + v_0, v_2, (Let(arg2, v_1, Let(arg1, v_0, e))))
        Let(arg1, v_0, Let(arg2, v_1, Let(v_1 + v_0, v_2, e)))

      //case (_,_) => e

    }
  }

  def forwardPrimalTraceProduct(e: Expr, arg1: Expr, arg2: Expr, withRespectTo: Param, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr = {
    (arg1, arg2) match {
      case (_: Param, _: Param) =>
        var v_0 = Param("v_0")
        var v_1 = Param("v_1")
        var v_2 = Param("v_2")
        //var y = Let(v_1 + v_0, v_2, (Let(arg2, v_1, Let(arg1, v_0, e))))
        Let(arg1, v_0, Let(arg2, v_1, Let(v_1 * v_0, v_2, e)))

      //case (_,_) => e

    }
  }

  def forwardPrimalTraceDivision(e: Expr, arg1: Expr, arg2: Expr, withRespectTo: Param, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr = {
    (arg1, arg2) match {
      case (_: Param, _: Param) =>
        var v_0 = Param("v_0")
        var v_1 = Param("v_1")
        var v_2 = Param("v_2")
        var y = Let(v_1 + v_0, v_2, (Let(arg2, v_1, Let(arg1, v_0, e))))
        Let(arg1, v_0, Let(arg2, v_1, Let(v_1 / v_0, v_2, e)))

      //case (_,_) => e

    }
  }
}