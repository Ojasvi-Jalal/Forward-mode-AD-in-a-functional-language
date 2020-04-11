package evaluation.discarded

import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Vector, DotProduct, Param}

object DotProduct25 extends App{


  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp1 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
  x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
  x_1, x_2, x_0, x_2, x_1,
    x_1, x_2)

  var vector = Vector(exp1, x.t)
  var dot = DoubleEvaluator.eval(DotProduct(vector, vector))
  val t0 = System.nanoTime()
  DifferentiateExpr.differentiate(dot, vector)
  //(AutomaticDifferentiate.autodifferentiate(dot, vector)) // call-by-name
  val t1 = System.nanoTime()

  println("Elapsed time: " + (t1 - t0)/(1e+9) + "s")

   println(exp1.length)
}
