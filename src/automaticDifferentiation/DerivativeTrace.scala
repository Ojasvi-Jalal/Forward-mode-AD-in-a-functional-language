package automaticDifferentiation

import differentiate.{Differentiate, DifferentiateExpr}
import eval.DoubleEvaluator.{eval, paramToArg}
import _root_.eval.{DoubleEvaluator, Evaluator}
import intermediateRep._
import sun.util.resources.cldr.wae.LocaleNames_wae

import scala.collection.mutable
import scala.collection.mutable.Queue
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

  def derivativeTrace(e: Expr, withRespectTo: Expr, queue: Queue[(Expr, Expr)] = Queue[(Expr, Expr)]()): Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case FunctionCall(Lambda(param, body), arg) =>
        paramToArg.put(param, arg.asInstanceOf[Expr])
        derivativeTrace(body, withRespectTo, queue)

      case MaxVar(vectorVar: VectorVar) =>
        var i = Param("i")
        paramToArg.clear()
        Let(queue.apply(0)._1,  Map(i, If_Else(GreaterThan(VectorVarAccess(vectorVar,i),Drop(vectorVar,i)),IntLiteral(1) , IntLiteral(0)), Sequence((0 to vectorVar.len-1).toList)), e)

      case FunctionCall(FunctionCall(_: MultiplyDouble, arg1), arg2:VectorVar) =>
        var i = Param("i")
//        if(withRespectTo == arg1){
//          Let(queue.apply(0)._1,arg2,arg2)
//        }
        paramToArg.clear()
        Let(queue.apply(0)._1,  Map(i, arg2, Sequence((0 to arg2.len-1).toList)), arg2)
        //Let(queue.apply(0)._1,arg2,e)
       // Let(queue.apply(0)._1,VectorVar(IntLiteral(0), arg2.asInstanceOf[VectorVar].len),e)

      case FunctionCall(FunctionCall(_: AddDouble, arg1:VectorVar), arg2:VectorVar) =>
        var i = Param("i")
        var j = Param("j")
        paramToArg.clear()
        //Map(Lambda i, Map (j, differentiate(f(i) w.r.t j ), (0...N)) (0....N))
       // Let(queue.apply(0)._1,  Map(i, Map(j, DifferentiateExpr.differentiate(queue.apply(0)._2, VectorVarAccess(withRespectTo.asInstanceOf[VectorVar],j),paramToArg) , Sequence((0 to withRespectTo.asInstanceOf[VectorVar].len-1).toList)), Sequence((0 to withRespectTo.asInstanceOf[VectorVar].len-1).toList)),e)
       Let(queue.apply(0)._1,  Map(i, Map(j, If_Else( EqualTo(i,j), IntLiteral(1),IntLiteral(0)) , Sequence((0 to withRespectTo.asInstanceOf[VectorVar].len-1).toList)), Sequence((0 to withRespectTo.asInstanceOf[VectorVar].len-1).toList)),queue.apply(0)._1)


      case DotProduct(arg1:VectorVar, arg2:VectorVar) =>
       // if(arg1 === withRespectTo.asInstanceOf[VectorVar])
        var i = Param("i")
        paramToArg.clear()
       Let(queue.apply(0)._1,  Map(i, arg2, Sequence((0 to arg1.len-1).toList)), arg2)
       // Let(queue.apply(0)._1,arg2,e)
      case _ =>
        var z_prime: Expr = queue.apply(0)._1
        queue.foreach(x => z_prime = Let(x._1, DifferentiateExpr.differentiate(paramToArg(x._1), withRespectTo, paramToArg), z_prime))
        paramToArg.clear()
        (z_prime)
    }
  }
}

//differentiate_x = FunctionCall(Lambda(v_0,FunctionCall(Lambda(v_1,FunctionCall(Lambda(FunctionCall(FunctionCall(AddDouble(v_1),v_1),v_0),FunctionCall(FunctionCall(AddDouble(v_1),v_1),v_0)),FunctionCall(FunctionCall(AddDouble(1.0),1.0),0.0))),0.0)),1.0)
//differentiate_Product = FunctionCall(Lambda(v_0,FunctionCall(Lambda(v_1,FunctionCall(Lambda(FunctionCall(FunctionCall(MultiplyDouble(v_1),v_1),v_0),FunctionCall(FunctionCall(MultiplyDouble(v_1),v_1),v_0)),((v_0 * 0.0) + (v_1 * 1.0)))),0.0)),1.0)