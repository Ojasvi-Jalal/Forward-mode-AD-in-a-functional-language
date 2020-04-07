package evaluation.dotProduct

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Array, DotProduct, Param}

object DotProduct100 extends App{
//  ARRAY LENGTH 100*******************************************
  //  7277879.5ns - 0.0072778795s
//    Eval:1254985ns
//    Eval:1258848ns
//    Eval:1569890ns
//    Eval:5169858ns
//    Eval:6309458ns
//    Eval:8246301ns
//    Eval:9124055ns
//    Eval:11365445ns
//    Eval:11845225ns
//    Eval:11942327ns
//    ***********************************************
  //  3155622737ns - 3.155622737s
//    AD time:701913290ns
//    AD time:838215658ns
//    AD time:1241399455ns
//    AD time:2042822151ns
//    AD time:3053803249ns
//    AD time:3257442225ns
//    AD time:3397274424ns
//    AD time:3716964886ns
//    AD time:3918997652ns
//    AD time:8024792038ns
//    ***********************************************

  //  40759487.5ns - 0.0407594875s
//    AD eval time:24462291ns
//    AD eval time:31084740ns
//    AD eval time:32320503ns
//    AD eval time:33924194ns
//    AD eval time:40080392ns
//    AD eval time:41438583ns
//    AD eval time:41638414ns
//    AD eval time:71950556ns
//    AD eval time:187964713ns
//    AD eval time:471452908ns
//    ***********************************************
//  ***********************************************

  //  4428019ns - 0.004428019s
//  SD time:4081659ns
//    SD time:4141457ns
//    SD time:4172831ns
//    SD time:4276420ns
//    SD time:4375776ns
//    SD time:4480262ns
//    SD time:4590941ns
//    SD time:4742871ns
//    SD time:8528135ns
//    SD time:14134235ns
//    ***********************************************

  //  31690537.5 - 0.0316905375s
//    SD eval time:18244750ns
//    SD eval time:18427771ns
//    SD eval time:20870634ns
//    SD eval time:27454623ns
//    SD eval time:31653526ns
//    SD eval time:31727549ns
//    SD eval time:31758355ns
//    SD eval time:34240539ns
//    SD eval time:39919709ns
//    SD eval time:40011171ns


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
    x_1, x_2,x_0, x_1, x_0, x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
  x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
  x_1, x_2, x_0, x_2, x_1,
    x_1, x_2,x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_2, x_1,
    x_1, x_2,x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_2, x_1,
    x_1, x_2,x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_2, x_1,
    x_1, x_2)


  println("ARRAY LENGTH "+ exp1.length + "*******************************************")
  ExprDotProdVector.eval(exp1, true, true)
}
