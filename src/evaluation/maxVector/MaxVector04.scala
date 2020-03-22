package evaluation.maxVector

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Array, Fold, GreaterThan, Param}


object MaxVector05 extends App{

//  ARRAY LENGTH 5*******************************************
//    Eval:88318ns
//    Eval:90272ns
//    Eval:93787ns
//    Eval:94812ns
//    Eval:97151ns
//    Eval:100752ns
//    Eval:101159ns
//    Eval:110249ns
//    Eval:158994ns
//    Eval:165219ns
//    ***********************************************
//  AD time:1944632ns
//    AD time:1994242ns
//    AD time:2185179ns
//    AD time:2812002ns
//    AD time:4692355ns
//    AD time:4864066ns
//    AD time:5024913ns
//    AD time:5144119ns
//    AD time:5147776ns
//    AD time:42569301ns
//    ***********************************************
//  AD eval time:684748ns
//    AD eval time:689398ns
//    AD eval time:773542ns
//    AD eval time:890356ns
//    AD eval time:921944ns
//    AD eval time:940122ns
//    AD eval time:1247971ns
//    AD eval time:1541201ns
//    AD eval time:4264660ns
//    AD eval time:8271153ns
//    ***********************************************
//  ***********************************************
//  SD time:33178ns
//    SD time:33634ns
//    SD time:35365ns
//    SD time:36466ns
//    SD time:37260ns
//    SD time:38732ns
//    SD time:39127ns
//    SD time:39193ns
//    SD time:49058ns
//    SD time:791876ns
//    ***********************************************
//  SD eval time:702362ns
//    SD eval time:722394ns
//    SD eval time:724255ns
//    SD eval time:727337ns
//    SD eval time:742843ns
//    SD eval time:744155ns
//    SD eval time:745437ns
//    SD eval time:1092399ns
//    SD eval time:1108952ns
//    SD eval time:1177626ns



  var x = Param("x")
  var y = Param("y")

  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")

  var exp = List(x_0, x_2, x_2, x_1)


  println("ARRAY LENGTH "+ exp.length + "*******************************************")
  ExprMaxVector.eval(exp, true, true)
  //var maxVector = (DoubleEvaluator.eval(Fold(GreaterThan(x,y), vector.list.head, vector )))
}
