package evaluation.dotProduct

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Vector, DotProduct, Param}

object DotProduct32 extends App{

//  ARRAY LENGTH 32*******************************************
  //  2935370ns - 0.00293537s - 0.00328786 - 0.0226175
//    Eval:1890134ns
//    Eval:1926752ns
//    Eval:2226118ns
//    Eval:2502170ns
//    Eval:2906139ns
//    Eval:2964601ns
//    Eval:3020722ns
//    Eval:3594327ns
//    Eval:3927637ns
//    Eval:5297237ns
//    ***********************************************
  //  45913173.5ns :  0.0459131735s
//    AD time:22109436ns
//    AD time:22969066ns
//    AD time:26147082ns
//    AD time:34534374ns
//    AD time:38079074ns
//    AD time:53747273ns
//    AD time:72229529ns
//    AD time:77796804ns
//    AD time:110668201ns
//    AD time:202211201ns
//    ***********************************************
  //  13230928.5s : 0.0132309285
//    AD eval time:3019896ns
//    AD eval time:5653142ns
//    AD eval time:5897653ns
//    AD eval time:8792185ns
//    AD eval time:12971216ns
//    AD eval time:13490641ns
//    AD eval time:20760366ns
//    AD eval time:30605353ns
//    AD eval time:31108186ns
//    AD eval time:37168321ns
//    ***********************************************
//  ***********************************************
  //3729041.5ns - 0.0037290415
//    SD time:3038413ns
//    SD time:3148896ns
//    SD time:3212530ns
//    SD time:3464523ns
//    SD time:3492273ns
//    SD time:3965810ns
//    SD time:4530716ns
//    SD time:5824107ns
//    SD time:12387579ns
//    SD time:48806497ns
//    ***********************************************
  //  3962935.5 - 0.0039629355s
//    SD eval time:2594240ns
//    SD eval time:2693976ns
//    SD eval time:2711092ns
//    SD eval time:2837060ns
//    SD eval time:3559449ns
//    SD eval time:4366422ns
//    SD eval time:4883177ns
//    SD eval time:6562990ns
//    SD eval time:7504990ns
//    SD eval time:11869055ns

  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp1 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
  x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
  x_1, x_2, x_1, x_2)

  println("ARRAY LENGTH "+ exp1.length + "*******************************************")
  ExprDotProdVector.eval(exp1, true, true)


}
