package evaluation.dotProduct

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Array, DotProduct, Param}

object DotProduct16 extends App{
//
//  ARRAY LENGTH 16*******************************************
 // 6371728.5ns - 0.0063717285s - 0.002173361
//    Eval:1340443ns
//    Eval:1513846ns
//    Eval:1733803ns
//    Eval:3003796ns
//    Eval:5849134ns
//    Eval:6894323ns
//    Eval:10531419ns
//    Eval:10611221ns
//    Eval:25406501ns
//    Eval:32646993ns
//    ***********************************************
  // 28492218ns - 0.028492218s
//  AD time:16705309ns
//    AD time:19128164ns
//    AD time:21413154ns
//    AD time:23014090ns
//    AD time:24443529ns
//    AD time:32540907ns
//    AD time:50366215ns
//    AD time:51954829ns
//    AD time:83506936ns
//    AD time:320390720ns
//    ***********************************************
  // 5340152ns - 0.005340152
//    AD eval time:794471ns
//    AD eval time:2076258ns
//    AD eval time:3015075ns
//    AD eval time:3964610ns
//    AD eval time:4415110ns
//    AD eval time:6265194ns
//    AD eval time:6799261ns
//    AD eval time:6993587ns
//    AD eval time:18676581ns
//    AD eval time:25806801ns
//    ***********************************************
//  ***********************************************
  // 629048.5s - 0.0006290485
//    SD time:543703ns
//    SD time:568036ns
//    SD time:573474ns
//    SD time:580589ns
//    SD time:584251ns
//    SD time:673846ns
//    SD time:796522ns
//    SD time:1271709ns
//    SD time:1479937ns
//    SD time:1811440ns
//    ***********************************************
  //  719803 = 0.000719803s
//    SD eval time:557449ns
//    SD eval time:560884ns
//    SD eval time:645330ns
//    SD eval time:716529ns
//    SD eval time:718878ns
//    SD eval time:720728ns
//    SD eval time:725394ns
//    SD eval time:746600ns
//    SD eval time:759817ns
//    SD eval time:809541ns

  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp1 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
  x_1, x_1, x_2, x_2, x_0, x_1, x_0)


  println("ARRAY LENGTH "+ exp1.length + "*******************************************")
  ExprDotProdVector.eval(exp1, true, true)
}
