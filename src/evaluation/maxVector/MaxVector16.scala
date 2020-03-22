package evaluation.maxVector

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Array, Fold, GreaterThan, Param}


object MaxVector20 extends App{






  var x = Param("x")
  var y = Param("y")

  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  //  var x_3 = Param("x_3")
  //  var x_vector = Array(List(x_1, x_2, x_3), x.t)

  var exp = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2, x_1, x_0,x_2, x_2, x_0, x_0, x_1, x_0)



  println("ARRAY LENGTH "+ exp.length + "*******************************************")
  ExprMaxVector.eval(exp, true, true)
}
