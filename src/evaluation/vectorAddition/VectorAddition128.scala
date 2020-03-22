package evaluation.vectorAddition

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Array, Param}

object VectorAddition100 extends App{


  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp1 = List( x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,x_1, x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
  x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
  x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
  x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
  x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1,
  x_2, x_1, x_2, x_2, x_2, x_0, x_1, x_0, x_1,
  x_0, x_2, x_2, x_2, x_1, x_1, x_1, x_0, x_2,
  x_2, x_2, x_2, x_1, x_1, x_1, x_2, x_1, x_0,
  x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
  x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_1, x_2,
  x_0, x_0, x_2, x_0, x_0, x_0, x_1, x_0, x_2, x_0)

  println("ARRAY LENGTH "+ exp1.length + "*******************************************")
  ExprVectorAddition.eval(exp1, true, true)
}
