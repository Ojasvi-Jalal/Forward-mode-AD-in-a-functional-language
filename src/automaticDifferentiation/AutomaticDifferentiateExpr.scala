package automaticDifferentiation

import intermediateRep._

import scala.collection.mutable
import scala.collection.mutable.Queue
import scala.language.implicitConversions

object AutomaticDifferentiateExpr {

  val paramToArg = mutable.HashMap[String, String]()
  var counter = 0
 // var s = util.Stack[(Expr,Expr)]()
  val x = Queue[(Expr, Expr)]()

  def autoDifferentiate(e: Expr, withRespectTo: Param, hm: mutable.HashMap[String, String] = mutable.HashMap[String, String]()): Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    forwardPrimalTrace(e)

    var reverseQueue = x.reverse
    var z = e
    reverseQueue.foreach(x => z = Let(x._1, x._2, z))
    z
    DerivativeTrace.derivativeTrace(z,withRespectTo,x.reverse)
  }

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

  def forwardPrimalTrace(e: Expr): Unit = {
    e match {
      //      case DoubleLiteral(d) => DoubleLiteral(0)
      //      case p: Param => if (Var(p) === Var(withRespectTo))
      //        DoubleLiteral(1)
      //      else
      //        DoubleLiteral(0)
      case FunctionCall(FunctionCall(_: AddDouble, arg1), arg2) => {
        (arg1, arg2) match {

          case (_: Param, _: Param) =>
            //z = Let(Param("v_".concat((counter++).toString)), arg1, z)
            //hm.put(arg1.toString, Param("v_".concat(counter.toString)).toString())
            x.addOne((Param("v_".concat(counter.toString)), arg1))
            counter = counter + 1
            x.addOne((Param("v_".concat(counter.toString)), arg2))
            //hm.put(arg2.toString, Param("v_".concat(counter.toString)).toString())
            counter = counter + 1
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(x.knownSize-1)._1) + (( x.apply(x.knownSize-2)._1))))
            //hm.put(hm(arg1.toString).concat(" + ").concat(hm(arg2.toString)), "v_".concat(counter.toString))
            counter = counter + 1

          case (_: Param, _) =>
            x.addOne((Param("v_".concat(counter.toString)), arg1))
            counter = counter + 1
            forwardPrimalTrace(arg2)

          case (_, _: Param) =>
            forwardPrimalTrace(arg1)
            x.addOne((Param("v_".concat(counter.toString)), arg2))
            counter = counter + 1
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(x.knownSize-1)._1) + (( x.apply(x.knownSize-2)._1))))
            counter = counter + 1

          case (_, _) =>
            forwardPrimalTrace(arg1)
            forwardPrimalTrace(arg2)
        }
      }
    }



  }
}

//        def autoDifferentiate(e: Expr, withRespectTo: Param, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
//    e match {
////      case DoubleLiteral(d) => DoubleLiteral(0)
////      case p: Param => if (Var(p) === Var(withRespectTo))
////        DoubleLiteral(1)
////      else
////        DoubleLiteral(0)
//
//      case FunctionCall(FunctionCall(_: AddDouble, arg1), arg2) =>
//        var z = forwardPrimalTraceAddition(e, arg1, arg2, withRespectTo)
//        DerivativeTrace.derivativeTrace(z,withRespectTo)
//        //autoDifferentiate(e, withRespectTo)
//
//      case FunctionCall(FunctionCall(_: MultiplyDouble, arg1), arg2) =>
//        var z = forwardPrimalTraceProduct(e, arg1, arg2, withRespectTo)
//        DerivativeTrace.derivativeTrace(z,withRespectTo)
//
//      case FunctionCall(FunctionCall(_: DivideDouble, arg1), arg2) =>
//        var z = forwardPrimalTraceDivision(e, arg1, arg2, withRespectTo)
//        DerivativeTrace.derivativeTrace(z,withRespectTo)
//
//      case FunctionCall(FunctionCall(_: PowerDouble, arg1), arg2) =>
//        var z = forwardPrimalTracePower(e, arg1, arg2, withRespectTo)
//        DerivativeTrace.derivativeTrace(z,withRespectTo)
//    }
//  }
//
//  //take y and write a pass that traverses it. This pass should
//  //produce a new program (again full of Let for the v_i' variables)
//  //which corresponds to the derivative for each variable.
//
//  //What you need to do should be pretty simple since conceptually all you want to do is create an SSA form where each expression is assigned to a single variable. So x^2 + y^2 should become something like (in this version I have "inlined" the power, but I can imagine that you could also leave it as it is and have slightly less statements):
//  //
//  //v0=x;
//  //v1=x;
//  //v2=v0*v1;
//  //v3=y;
//  //v4=y;
//  //v5=v3*v4;
//  //v6=v2+v5;
//  //
//  //which can be easily represented with a lot of nested Let.
//
//  def forwardPrimalTraceAddition(e: Expr, arg1: Expr, arg2: Expr, withRespectTo: Param, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr = {
//    (arg1, arg2) match {
//      case (_: Param, _: Param) =>
//        var v_0 = Param("v_0")
//        var v_1 = Param("v_1")
//        var v_2 = Param("v_2")
//        Let(arg1, v_0, Let(arg2, v_1, Let(v_1 + v_0, v_2, e)))
//
//      case (FunctionCall(FunctionCall(_:PowerDouble, base1),exp1), FunctionCall(FunctionCall(_:PowerDouble, base2),exp2)) =>
//        var v_0 = Param("v_0")
//        var v_1 = Param("v_1")
//        var v_2 = Param("v_2")
//        var v_3 = Param("v_3")
//        var v_4 = Param("v_4")
//        var v_5 = Param("v_5")
//        var v_6 = Param("v_6")
//        Let(base1, v_0, Let(base1, v_1, Let(v_0 * v_1, v_2, Let(base2, v_3, Let(base2, v_4, Let(v_3 * v_4, v_5, Let(v_2 + v_5, v_6, e)))))))
//    }
//  }
//
//  def forwardPrimalTraceProduct(e: Expr, arg1: Expr, arg2: Expr, withRespectTo: Param, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr = {
//    (arg1, arg2) match {
//      case (_: Param, _: Param) =>
//        var v_0 = Param("v_0")
//        var v_1 = Param("v_1")
//        var v_2 = Param("v_2")
//        //var y = Let(v_1 + v_0, v_2, (Let(arg2, v_1, Let(arg1, v_0, e))))
//        Let(arg1, v_0, Let(arg2, v_1, Let(v_1 * v_0, v_2, e)))
//
//      //case (_,_) => e
//
//    }
//  }
//
//  def forwardPrimalTraceDivision(e: Expr, arg1: Expr, arg2: Expr, withRespectTo: Param, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr = {
//    (arg1, arg2) match {
//      case (_: Param, _: Param) =>
//        var v_0 = Param("v_0")
//        var v_1 = Param("v_1")
//        var v_2 = Param("v_2")
//        var y = Let(v_1 + v_0, v_2, (Let(arg2, v_1, Let(arg1, v_0, e))))
//        Let(arg1, v_0, Let(arg2, v_1, Let(v_1 / v_0, v_2, e)))
//    }
//  }
//
//  def forwardPrimalTracePower(e: Expr, arg1: Expr, arg2: Expr, withRespectTo: Param, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr = {
//    (arg1) match {
//      case (_: Param) =>
//        var v_0 = Param("v_0")
//        var v_1 = Param("v_1")
//        var v_2 = Param("v_2")
//        var y = Let(v_1 + v_0, v_2, (Let(arg2, v_1, Let(arg1, v_0, e))))
//        Let(arg1, v_0, Let(arg2, v_1, Let(v_0 ^ v_1, v_2, e)))
//    }
//  }
//}


