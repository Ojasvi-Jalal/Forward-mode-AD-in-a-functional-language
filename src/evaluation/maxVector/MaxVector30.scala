package evaluation.maxVector

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Vector, Fold, GreaterThan, Param}


object MaxVector30 extends App{

//  ARRAY LENGTH 30*******************************************
//    Eval:668743ns
//    Eval:681086ns
//    Eval:700620ns
//    Eval:721032ns
//    Eval:725107ns
//    Eval:753373ns
//    Eval:846171ns
//    Eval:899625ns
//    Eval:1223401ns
//    Eval:53498159ns


  var x = Param("x")
  var y = Param("y")

  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")

  var exp = List(x_2, x_2, x_0, x_0, x_1,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2, x_1, x_0,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2, x_1, x_0, x_2, x_2, x_0, x_0, x_1)

  println("ARRAY LENGTH "+ exp.length + "*******************************************")
  ExprMaxVector.eval(exp, true, true)
}
