package evaluation.dotProduct

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Array, DotProduct, Param}

object DotProduct10 extends App{
  //10

  //auto differentiate:   0.086756829

  //0.678491862
  //0.602844738
  //0.592945159
  //0.579378962
  //0.569467316
  //0.53360553
  //0.527529556
  //0.495937693
  //0.480661726
  //0.475724162


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

  var exp1 = List(x_1, x_1, x_2, x_1, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2, x_1, x_1, x_2, x_1, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0,x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1,x_2,x_0, x_1, x_2,x_0, x_0, x_1)
 // println(exp1.a.length)

  println("ARRAY LENGTH "+ exp1.length + "*******************************************")
  ExprDotProdVector.eval(exp1, true, true)
}
