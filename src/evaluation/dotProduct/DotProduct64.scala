package evaluation.dotProduct

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Vector, DotProduct, Param}

object DotProduct64 extends App{

//  ARRAY LENGTH 64*******************************************
  //   9211275ns - 0.009211275s - 5222650 - 0.00522265
//    Eval:2233316ns
//    Eval:6401474ns
//    Eval:6908284ns
//    Eval:7558672ns
//    Eval:7655163ns
//    Eval:10767387ns
//    Eval:13035924ns
//    Eval:13922229ns
//    Eval:14631124ns
//    Eval:28913868ns
//    ***********************************************
  //  257329268ns - 0.257329268s
//    AD time:91282370ns
//    AD time:145226457ns
//    AD time:196911868ns
//    AD time:203582805ns
//    AD time:215011798ns
//    AD time:299646738ns
//    AD time:393990457ns
//    AD time:782193158ns
//    AD time:2241012446ns
//    AD time:2490904940ns
//    ***********************************************
  //  11898603 : 0.011898603
//    AD eval time:6121687ns
//    AD eval time:8209078ns
//    AD eval time:9591608ns
//    AD eval time:10414235ns
//    AD eval time:11435695ns
//    AD eval time:12361511ns
//    AD eval time:13516422ns
//    AD eval time:26906461ns
//    AD eval time:86385219ns
//    AD eval time:218612705ns
//    ***********************************************
//  ***********************************************

  //  2557990ns : 0.00255799s
//    SD time:1831618ns
//    SD time:2370869ns
//    SD time:2445534ns
//    SD time:2474269ns
//    SD time:2486338ns
//    SD time:2629642ns
//    SD time:2698071ns
//    SD time:3098283ns
//    SD time:6070503ns
//    SD time:20882418ns
//    ***********************************************

  //  7355395.5 ns - 0.0073553955s
//    SD eval time:5822727ns
//    SD eval time:6593548ns
//    SD eval time:7085830ns
//    SD eval time:7127323ns
//    SD eval time:7132750ns
//    SD eval time:7578041ns
//    SD eval time:7591923ns
//    SD eval time:7773266ns
//    SD eval time:16396838ns
//    SD eval time:17510896ns



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
