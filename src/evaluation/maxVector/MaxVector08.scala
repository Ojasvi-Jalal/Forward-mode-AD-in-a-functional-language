package evaluation.maxVector

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Array, Fold, GreaterThan, Param}


object MaxVector08 extends App{
//
//  ARRAY LENGTH 8*******************************************
  //  231905ns - 0.000231905s
//    Eval:147390ns
//    Eval:173583ns
//    Eval:196579ns
//    Eval:219832ns
//    Eval:223148ns
//    Eval:240662ns
//    Eval:241053ns
//    Eval:245958ns
//    Eval:268843ns
//    Eval:357036ns
//    ***********************************************
  //  4814467ns - 0.004814467s
//    AD time:2212348ns
//    AD time:2370426ns
//    AD time:2411874ns
//    AD time:2859276ns
//    AD time:3326382ns
//    AD time:6302552ns
//    AD time:6371372ns
//    AD time:37533341ns
//    AD time:79105179ns
//    AD time:147197197ns
//    ***********************************************
  //  15686530ns  - 0.01568653s
//    AD eval time:1834724ns
//    AD eval time:7862323ns
//    AD eval time:8126548ns
//    AD eval time:8272017ns
//    AD eval time:9315445ns
//    AD eval time:22057615ns
//    AD eval time:26571034ns
//    AD eval time:29449760ns
//    AD eval time:65543741ns
//    AD eval time:97298098ns
//    ***********************************************
//  ***********************************************
  //  37259.5ns - 3.72595e-5s
//    SD time:33075ns
//    SD time:33433ns
//    SD time:34045ns
//    SD time:34666ns
//    SD time:36549ns
//    SD time:37970ns
//    SD time:38947ns
//    SD time:39565ns
//    SD time:41217ns
//    SD time:945146ns
//    ***********************************************
//    1586234ns : 0.001586234s
//    SD eval time:1390638ns
//    SD eval time:1412129ns
//    SD eval time:1425464ns
//    SD eval time:1553577ns
//    SD eval time:1559911ns
//    SD eval time:1612557ns
//    SD eval time:1624310ns
//    SD eval time:1830988ns
//    SD eval time:2097809ns
//    SD eval time:6920678ns

  var x = Param("x")
  var y = Param("y")

  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")

  var exp = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2)

  println("ARRAY LENGTH "+ exp.length + "*******************************************")
  ExprMaxVector.eval(exp, true, true)
}
