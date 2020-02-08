package automaticDifferentiation

import intermediateRep._

import scala.collection.mutable
import scala.collection.mutable.Queue
import scala.language.implicitConversions

object AutomaticDifferentiateExpr {

  val paramToArg = mutable.HashMap[String, String]()
  var counter = 0
  var arrayCounter = 0
  val x = Queue[(Expr, Expr)]()

  def autoDifferentiate(e: Expr, withRespectTo: Param): Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case Map(param: Expr, body: Expr, vector: Array) =>
        val vectorQueue = Queue[(Expr, Expr)]()
        for(x <- vector.a) {
          vectorQueue.addOne((Param("a_".concat(counter.toString)), x))
          arrayCounter = arrayCounter + 1
        }
        val transformedSeq = Seq()
        vectorQueue.foreach(x => transformedSeq:+x._1)
        val array = Array(transformedSeq, vector.t)
        vectorQueue.addOne((Param("a_".concat(arrayCounter.toString)), array))
        arrayCounter = arrayCounter + 1
        var letMapBody  = forwardPrimalTrace(body)
        var z = body
        var reverseQueue = x.reverse
        reverseQueue.foreach (x => z = Let (x._1, x._2, z) )
        var d = Map(param, z, array)

        vectorQueue.reverse.foreach (x => z = Let (x._1, x._2, d) )
        z = DerivativeTrace.derivativeTrace (z, withRespectTo, x.reverse)
        e

      case _ =>

      forwardPrimalTrace (e)
      var reverseQueue = x.reverse
      var z = e
      reverseQueue.foreach (x => z = Let (x._1, x._2, z) )
      z = DerivativeTrace.derivativeTrace (z, withRespectTo, x.reverse)
      x.removeAll ()
      counter = 0
      z
    }
  }
//
//  def autoDifferentiateVector(e: Seq[Expr], withRespectTo: Expr): Seq[Expr] = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
////    forwardPrimalTrace(e)
////
////    var reverseQueue = x.reverse
////    var z = e
////    reverseQueue.foreach(x => z = Let(x._1, x._2, z))
////    z = DerivativeTrace.derivativeTrace(z,withRespectTo,x.reverse)
////    x.removeAll()
////    counter = 0
////    z
//
//    e match {
//
//      case Map(param, body, vector) => {
//        forwardPrimalTrace(body)
//
//        var reverseQueue = x.reverse
//        var z = e
//        reverseQueue.foreach(x => z = Let(x._1, x._2, z))
//        x.removeAll()
//        //z = map(param, forwardPrimalTrace(body), vector)
//        counter = vector.a.length - 1
//        while(counter < 0) {
//          x.addOne((Param("v_".concat(counter.toString)), ArrayAccess(vector, counter)))
//          counter = counter - 1
//        }
//        //var z = e
//        //x.foreach(x => z = Let(x._1, x._2, z))
//        vector.a
//      }
//    }
//
//  }
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
      case DoubleLiteral(d) => x.addOne((Param("v_".concat(counter.toString)), e))
                                counter = counter + 1

      case p: Param =>
        x.addOne((Param("v_".concat(counter.toString)), p))
        counter = counter + 1
        x.addOne((Param("v_".concat(counter.toString)), ( x.apply(x.knownSize-1)._1)))
        counter = counter + 1

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

      case FunctionCall(FunctionCall(_: MultiplyDouble, arg1), arg2) => {
        (arg1, arg2) match {

          case (_: Param, _: Param) =>
            //z = Let(Param("v_".concat((counter++).toString)), arg1, z)
            //hm.put(arg1.toString, Param("v_".concat(counter.toString)).toString())
            x.addOne((Param("v_".concat(counter.toString)), arg1))
            counter = counter + 1
            x.addOne((Param("v_".concat(counter.toString)), arg2))
            //hm.put(arg2.toString, Param("v_".concat(counter.toString)).toString())
            counter = counter + 1
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(x.knownSize-1)._1) * (( x.apply(x.knownSize-2)._1))))
            //hm.put(hm(arg1.toString).concat(" + ").concat(hm(arg2.toString)), "v_".concat(counter.toString))
            counter = counter + 1

          case (_: Param, _) =>
            x.addOne((Param("v_".concat(counter.toString)), arg1))
            var position = counter
            counter = counter + 1
            forwardPrimalTrace(arg2)
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(position)._1) * (( x.apply(x.knownSize-1)._1))))
            counter = counter + 1

          case (_, _: Param) =>
            forwardPrimalTrace(arg1)
            x.addOne((Param("v_".concat(counter.toString)), arg2))
            counter = counter + 1
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(x.knownSize-1)._1) * (( x.apply(x.knownSize-2)._1))))
            counter = counter + 1

          case (_, _) =>
            forwardPrimalTrace(arg1)
            forwardPrimalTrace(arg2)
        }
      }

      case FunctionCall(FunctionCall(_: PowerDouble, arg1), arg2) => {
        (arg1, arg2) match {

          case (_: Param, _: Param) =>
            //z = Let(Param("v_".concat((counter++).toString)), arg1, z)
            //hm.put(arg1.toString, Param("v_".concat(counter.toString)).toString())
            x.addOne((Param("v_".concat(counter.toString)), arg1))
            counter = counter + 1
            x.addOne((Param("v_".concat(counter.toString)), arg2))
            //hm.put(arg2.toString, Param("v_".concat(counter.toString)).toString())
            counter = counter + 1
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(x.knownSize-1)._1) ^ (( x.apply(x.knownSize-2)._1))))
            //hm.put(hm(arg1.toString).concat(" + ").concat(hm(arg2.toString)), "v_".concat(counter.toString))
            counter = counter + 1

          case (_: Param, _) =>
            x.addOne((Param("v_".concat(counter.toString)), arg1))
            var position = counter
            counter = counter + 1
            forwardPrimalTrace(arg2)
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(position)._1) ^ (( x.apply(x.knownSize-1)._1))))
            counter = counter + 1

          case (_, _: Param) =>
            forwardPrimalTrace(arg1)
            x.addOne((Param("v_".concat(counter.toString)), arg2))
            counter = counter + 1
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(x.knownSize-1)._1) ^ (( x.apply(x.knownSize-2)._1))))
            counter = counter + 1

          case (_, _) =>
            forwardPrimalTrace(arg1)
            forwardPrimalTrace(arg2)
        }

        }

    }
  }
}


