package automaticDifferentiation

import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Expr, _}

import scala.collection.mutable
import scala.collection.mutable.Queue
import scala.language.implicitConversions

object AutomaticDifferentiateExpr {

  //val paramToArg = mutable.HashMap[String, String]()
  var counter = 0
  var arrayCounter = 0
  val x = Queue[(Expr, Expr)]()
  var hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()

  def autoDifferentiate(e: Expr, withRespectTo: Expr): Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case y_vector: Array =>
        //val y_vector = DoubleEvaluator.eval(Map(param, body, vector)).asInstanceOf[Array]

        val vectorQueue = Queue[(Expr, Expr)]()
        for(x <- y_vector.a) {
          vectorQueue.addOne((Param("a_".concat(arrayCounter.toString)), x))
          arrayCounter = arrayCounter + 1
        }
        var transformedSeq: Seq[Expr] = Seq()
        for(x <- vectorQueue){
          transformedSeq = transformedSeq:+x._1
        }
        val array = Array(transformedSeq, y_vector.t)
        vectorQueue.addOne((Param("a_".concat(arrayCounter.toString)), array))
        arrayCounter = arrayCounter + 1

//        var letMapBody  = forwardPrimalTrace(body)
//        var z = body
//        var reverseQueue = x.reverse
//        reverseQueue.foreach (x => z = Let (x._1, x._2, z) )
//        var d = Map(param, z, array)
        var size = vectorQueue.knownSize
        var z = vectorQueue.apply(size-1)._1
        vectorQueue.reverse.foreach (x => z = Let (x._1, x._2, z) )
        z = DerivativeTrace.derivativeTrace (z, withRespectTo, vectorQueue.reverse)
        arrayCounter = 0
        vectorQueue.removeAll()
        hm.clear()
        z

      case _ =>

      forwardPrimalTrace (e)
      var reverseQueue = x.reverse
      var z = e
      reverseQueue.foreach (x => z = (Let(x._1, x._2, z) ))
        //println("fPT:"+ z)
      z = DerivativeTrace.derivativeTrace (z, withRespectTo, x.reverse)
      x.removeAll ()
      hm.clear()
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
                                hm.put(e, Param("v_".concat(counter.toString)))
                                counter = counter + 1

      case p: Param =>
        x.addOne((Param("v_".concat(counter.toString)), p))
        hm.put(p, Param("v_".concat(counter.toString)))
        counter = counter + 1
        x.addOne((Param("v_".concat(counter.toString)), ( x.apply(x.knownSize-1)._1)))
        counter = counter + 1

      case FunctionCall(FunctionCall(_: AddDouble, arg1), arg2) => {
        (arg1, arg2) match {

          case (_: Param, _: Param) =>
            //z = Let(Param("v_".concat((counter++).toString)), arg1, z)
            //hm.put(arg1.toString, Param("v_".concat(counter.toString)).toString())
            x.addOne((Param("v_".concat(counter.toString))), arg1)
            hm.put(arg1, Param("v_".concat(counter.toString)))
            counter = counter + 1
            x.addOne((Param("v_".concat(counter.toString))), arg2)
            hm.put(arg2, Param("v_".concat(counter.toString)))
            //hm.put(arg2.toString, Param("v_".concat(counter.toString)).toString())
            counter = counter + 1
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(x.knownSize-1)._1) + (( x.apply(x.knownSize-2)._1))))
            hm.put(((x.apply(x.knownSize-1)._2) + (( x.apply(x.knownSize-2)._2))), (Param("v_".concat(counter.toString))))
            counter = counter + 1

          case (_: Param, _) =>
            x.addOne((Param("v_".concat(counter.toString)), arg1))
            hm.put(arg1, Param("v_".concat(counter.toString)))
            counter = counter + 1
            forwardPrimalTrace(arg2)
            //x.addOne(Param("v_".concat(counter.toString)), hm(arg1) + hm(arg2))
            counter = counter + 1

          case (_, _: Param) =>
            forwardPrimalTrace(arg1)
            x.addOne((Param("v_".concat(counter.toString)), arg2))
            hm.put(arg2, Param("v_".concat(counter.toString)))
            counter = counter + 1
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(x.knownSize-1)._1) + (( x.apply(x.knownSize-2)._1))))
            hm.put(((x.apply(x.knownSize-1)._2) + (( x.apply(x.knownSize-2)._2))), (Param("v_".concat(counter.toString))))
            counter = counter + 1
            //x.addOne(Param("v_".concat(counter.toString)), hm(arg1) + hm(arg2))
            counter = counter + 1

          case (_, _) =>
            forwardPrimalTrace(arg1)
            forwardPrimalTrace(arg2)
            var add = hm(arg1) + hm(arg2)
            x.addOne(Param("v_".concat(counter.toString)), add)
            hm.put(arg1 + arg2, Param("v_".concat(counter.toString)))
            counter = counter + 1


        }
      }

      case FunctionCall(FunctionCall(_: MultiplyDouble, arg1), arg2) => {
        (arg1, arg2) match {

          case (_: Param, _: Param) =>
            x.addOne((Param("v_".concat(counter.toString))), arg1)
            hm.put(arg1, Param("v_".concat(counter.toString)))
            counter = counter + 1
            x.addOne((Param("v_".concat(counter.toString))), arg2)
            hm.put(arg2, Param("v_".concat(counter.toString)))
            counter = counter + 1
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(x.knownSize-1)._1) * (( x.apply(x.knownSize-2)._1))))
            hm.put(((x.apply(x.knownSize-3)._2) * (( x.apply(x.knownSize-2)._2))), (Param("v_".concat(counter.toString))))
            counter = counter + 1

          case (_: Param, _) =>
            x.addOne((Param("v_".concat(counter.toString)), arg1))
            hm.put(arg1, Param("v_".concat(counter.toString)))
            var position = counter
            counter = counter + 1
            forwardPrimalTrace(arg2)
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(position)._1) * (( x.apply(x.knownSize-1)._1))))
            hm.put(((x.apply(x.knownSize-3)._2) * (( x.apply(x.knownSize-2)._2))), (Param("v_".concat(counter.toString))))
            counter = counter + 1

          case (_, _: Param) =>
            forwardPrimalTrace(arg1)
            x.addOne((Param("v_".concat(counter.toString)), arg2))
            hm.put(arg2, Param("v_".concat(counter.toString)))
            counter = counter + 1
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(x.knownSize-1)._1) * (( x.apply(x.knownSize-2)._1))))
            hm.put(((x.apply(x.knownSize-3)._2) * (( x.apply(x.knownSize-2)._2))), (Param("v_".concat(counter.toString))))
            counter = counter + 1

          case (_, _) =>
            forwardPrimalTrace(arg1)
            forwardPrimalTrace(arg2)
            x.addOne(Param("v_".concat(counter.toString)), hm(arg1)*hm(arg2))

            hm.put(arg1 * arg2, Param("v_".concat(counter.toString)))
            counter = counter + 1
        }
      }

      case FunctionCall(FunctionCall(_: PowerDouble, arg1), arg2) => {
        (arg1, arg2) match {

          case (_: Param, _: Param) =>
            x.addOne((Param("v_".concat(counter.toString))), arg1)
            hm.put(arg1, Param("v_".concat(counter.toString)))
            counter = counter + 1
            x.addOne((Param("v_".concat(counter.toString))), arg2)
            hm.put(arg2, Param("v_".concat(counter.toString)))
            counter = counter + 1
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(x.knownSize-1)._1) ^ (( x.apply(x.knownSize-2)._1))))
            hm.put(((x.apply(x.knownSize-3)._2) ^ (( x.apply(x.knownSize-2)._2))), (Param("v_".concat(counter.toString))))
            counter = counter + 1

          case (_: Param, _) =>
            x.addOne((Param("v_".concat(counter.toString)), arg1))
            hm.put(arg1, Param("v_".concat(counter.toString)))
            var position = counter
            counter = counter + 1
            forwardPrimalTrace(arg2)
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(position)._1) ^ (( x.apply(x.knownSize-1)._1))))
            hm.put(((x.apply(x.knownSize-3)._2) ^ (( x.apply(x.knownSize-2)._2))), (Param("v_".concat(counter.toString))))
            counter = counter + 1

//            x.addOne((Param("v_".concat(counter.toString)), arg1))
//            var position = counter
//            counter = counter + 1
//            forwardPrimalTrace(arg2)
//            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(position)._1) ^ (( x.apply(x.knownSize-1)._1))))
//            counter = counter + 1

          case (_, _: Param) =>
            forwardPrimalTrace(arg1)
            x.addOne((Param("v_".concat(counter.toString)), arg2))
            hm.put(arg2, Param("v_".concat(counter.toString)))
            counter = counter + 1
            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(x.knownSize-1)._1) ^ (( x.apply(x.knownSize-2)._1))))
            hm.put(((x.apply(x.knownSize-3)._2) * (( x.apply(x.knownSize-2)._2))), (Param("v_".concat(counter.toString))))
            counter = counter + 1
//
//            forwardPrimalTrace(arg1)
//            x.addOne((Param("v_".concat(counter.toString)), arg2))
//            counter = counter + 1
//            x.addOne(Param("v_".concat(counter.toString)), ((x.apply(x.knownSize-1)._1) ^ (( x.apply(x.knownSize-2)._1))))
//            counter = counter + 1

          case (_, _) =>
            forwardPrimalTrace(arg1)
            forwardPrimalTrace(arg2)
            x.addOne(Param("v_".concat(counter.toString)), hm(arg1)^hm(arg2))
            hm.put(arg1 ^ arg2, Param("v_".concat(counter.toString)))
            counter = counter + 1
        }

        }

      case If_Else(cond, stmt1, stmt2) =>
        forwardPrimalTrace(stmt1)
        forwardPrimalTrace(stmt2)
        x.addOne(Param("v_".concat(counter.toString)), If_Else(cond, hm(stmt1), hm(stmt2)))
        hm.put(If_Else(cond, stmt1, stmt2), Param("v_".concat(counter.toString)))
        counter = counter + 1
    }
  }
}


