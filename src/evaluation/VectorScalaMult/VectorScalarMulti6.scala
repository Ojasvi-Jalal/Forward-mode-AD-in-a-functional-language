package evaluation.VectorScalaMult

import automaticDifferentiation.AutomaticDifferentiate
import eval.DoubleEvaluator
import intermediateRep.{Array, Param}

object VectorScalarMulti6 extends App{
  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = DoubleEvaluator.eval((x_1 * x_2))

  var elemtype2 = DoubleEvaluator.eval(x_0 + (x_1 + x_2))
  var elemtype3 = DoubleEvaluator.eval(x_0 * (x_1 / x_2))

  var exp = List(
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3,
  elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3)
   //println(exp.length)
  var vector = DoubleEvaluator.eval(x * Array(exp, x.t))
  val t0 = System.nanoTime()
  val result = AutomaticDifferentiate.autodifferentiate(vector, x) // call-by-name
  val t1 = System.nanoTime()

  println("Elapsed time: " + (t1 - t0)/(1e+9) + "s")

  // println(exp.length)
  //println(Evaluator.printString(DoubleEvaluator.eval(x * Array(exp, x.t))))
 // println(Evaluator.printString(result))
//  //println(result.t)
//  var check =  List(((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))))
//  println(check.length)
//  println(exp.length)
  // var check = List(DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0))
 // println(check.length)
}
