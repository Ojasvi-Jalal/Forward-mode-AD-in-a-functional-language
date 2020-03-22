package evaluation.maxVector

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Array, Fold, GreaterThan, Param}


object MaxVector10 extends App{

//
//  ARRAY LENGTH 10*******************************************
//    Eval:129563ns
//    Eval:238230ns
//    Eval:252323ns
//    Eval:272085ns
//    Eval:279947ns
//    Eval:299283ns
//    Eval:384208ns
//    Eval:488221ns
//    Eval:544265ns
//    Eval:573079ns
//    ***********************************************
//  AD time:1911851ns
//    AD time:2180476ns
//    AD time:2601097ns
//    AD time:2723992ns
//    AD time:3096292ns
//    AD time:10464066ns
//    AD time:17249428ns
//    AD time:22904805ns
//    AD time:72170600ns
//    AD time:112046423ns
//    ***********************************************
//  AD eval time:2074011ns
//    AD eval time:2188813ns
//    AD eval time:2415611ns
//    AD eval time:6331661ns
//    AD eval time:7403403ns
//    AD eval time:7721881ns
//    AD eval time:8086109ns
//    AD eval time:8333622ns
//    AD eval time:56652105ns
//    AD eval time:174098738ns
//    ***********************************************
//  ***********************************************
//  SD time:86349ns
//    SD time:86548ns
//    SD time:87810ns
//    SD time:88262ns
//    SD time:88916ns
//    SD time:90697ns
//    SD time:93845ns
//    SD time:105460ns
//    SD time:106409ns
//    SD time:1022012ns
//    ***********************************************
//  SD eval time:1466876ns
//    SD eval time:1657333ns
//    SD eval time:2465077ns
//    SD eval time:2597521ns
//    SD eval time:4489402ns
//    SD eval time:7226464ns
//    SD eval time:8791644ns
//    SD eval time:10515657ns
//    SD eval time:14272471ns
//    SD eval time:15618604ns

  var x = Param("x")
  var y = Param("y")

  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  //  var x_3 = Param("x_3")
  //  var x_vector = Array(List(x_1, x_2, x_3), x.t)

  var exp = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2)


  println("ARRAY LENGTH "+ exp.length + "*******************************************")
  ExprMaxVector.eval(exp, true, true)
}
