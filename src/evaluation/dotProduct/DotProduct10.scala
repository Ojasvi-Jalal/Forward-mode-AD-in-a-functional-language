package evaluation.dotProduct

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Array, DotProduct, Param}

object DotProduct10 extends App{
  //10

  //auto differentiate:   0.086756829
  //0.111483978
  //0.107197037s
  //0.099340438
  //0.089179151
  //0.087159732
  //0.086353926
  //0.083768417
  //0.080715074
  //0.080343171
  //0.080136649

  //diff: 0.1235814015
  //0.134596224
  //0.133192006
  //0.130774262
  //0.128152499
  //0.125846537
  //0.121316266
  //0.120096506
  //0.119921095
  //0.113259802
  //0.10301378



  //evaluate: 0.0656077145

  //0.17671654
  //0.091994626
  //0.081242195
  //0.082847549
  //0.075312866
  //0.055902563
  //0.048626712
  //0.045378215
  //0.03431729
  //0.031739643



  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = DoubleEvaluator.eval((x_1 * x_2))

  var elemtype2 = DoubleEvaluator.eval(x_0 + (x_1 + x_2))
  var elemtype3 = DoubleEvaluator.eval(x_0 * (x_1 / x_2))
//
//  var exp2 = Array(List(
//    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3), x_0.t)

 // var exp2 = Array(List( x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0), x_0.t)

  var exp1 = Array(List(x_1, x_1, x_2, x_1, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2, x_1, x_1, x_2, x_1, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0), x_0.t)
 // println(exp1.a.length)
  //var dot = DoubleEvaluator.eval(DotProduct(exp1, exp1 ))
  //println(Evaluator.printString(dot))
  //var vector = DoubleEvaluator.eval(x * Array(exp2, x.t))
  val t0 = System.nanoTime()
  DoubleEvaluator.eval(DotProduct(exp1, exp1 ))
  //val result = AutomaticDifferentiate.autodifferentiate(dot, exp1)
  //DifferentiateExpr.differentiate(dot, exp1)
  //val result = Evaluator.eval(AutomaticDifferentiate.autodifferentiate(vector, x)) // call-by-name
  val t1 = System.nanoTime()
  println("Elapsed time in seconds: " + (t1 - t0)/(1e+9))
}
