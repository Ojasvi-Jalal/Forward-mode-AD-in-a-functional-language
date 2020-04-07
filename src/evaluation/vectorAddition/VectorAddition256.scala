package evaluation.vectorAddition

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import evaluation.vectorAddition.VectorAddition452.exp1
import intermediateRep.{Array, Param}

object VectorAddition256 extends App{
//
//  ARRAY LENGTH 256*******************************************
//    Eval:3461816ns - 0.003461816 / 0.011585463
//    ***********************************************
//  AD time:456166252ns - 0.456166252
//    ***********************************************
//  AD eval time:78029000ns - 0.078029
//    ***********************************************
//  ***********************************************
//  SD time:125845467ns - 0.125845467
//    ***********************************************
//  SD eval time:61804803ns - 0.061804803

//  ARRAY LENGTH 256*******************************************
//    Eval:1589969ns
//    Eval:1691052ns
//    Eval:1704513ns
//    Eval:2960300ns
//    Eval:4502116ns
//    Eval:7725223ns
//    Eval:15101092ns
//    Eval:15426708ns
//    Eval:15501992ns
//    Eval:19052754ns
//    ***********************************************
//  AD time:194212349ns
//    AD time:203182914ns
//    AD time:239378751ns
//    AD time:255868828ns
//    AD time:294750819ns
//    AD time:423891707ns
//    AD time:582888925ns
//    AD time:602921958ns
//    AD time:784136008ns
//    AD time:1162593584ns
//    ***********************************************
//  AD eval time:60596359ns
//    AD eval time:61961781ns
//    AD eval time:65484499ns
//    AD eval time:66964245ns
//    AD eval time:68033555ns
//    AD eval time:78671153ns
//    AD eval time:79003343ns
//    AD eval time:82429231ns
//    AD eval time:189658291ns
//    AD eval time:315016354ns
//    ***********************************************
//  ***********************************************
//  SD time:126150188ns
//    SD time:128224338ns
//    SD time:128477420ns
//    SD time:135300289ns
//    SD time:137903339ns
//    SD time:139182014ns
//    SD time:143392972ns
//    SD time:166225182ns
//    SD time:190893840ns
//    SD time:203379453ns
//    ***********************************************
//  SD eval time:61312645ns
//    SD eval time:61530445ns
//    SD eval time:61556959ns
//    SD eval time:65424801ns
//    SD eval time:65937932ns
//    SD eval time:66450301ns
//    SD eval time:67821157ns
//    SD eval time:75442716ns
//    SD eval time:79900712ns
//    SD eval time:85749993ns

  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp1 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_2, x_1, x_1, x_1, x_2, x_1, x_0,
    x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
    x_2, x_1, x_0,
    x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
    x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_1, x_2,
    x_0, x_0, x_2, x_0, x_0, x_0, x_1, x_0, x_2, x_0,
    x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1,
    x_2, x_1, x_2, x_2, x_2, x_0, x_1, x_0, x_1,
    x_0, x_2, x_2, x_2, x_1, x_1, x_1, x_0, x_2,
    x_2, x_2, x_2, x_1, x_1, x_1, x_2, x_1, x_0,
    x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
    x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_1, x_2,
    x_0, x_0, x_2, x_0, x_0, x_0, x_1, x_0, x_2, x_0,
    x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
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
