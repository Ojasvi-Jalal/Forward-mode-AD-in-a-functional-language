package evaluation.maxVector

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Vector, Fold, GreaterThan, Param}


object MaxVector16 extends App{


//  ARRAY LENGTH 16*******************************************
//    382515.5ns - 0.0003825155s
//    Eval:216657ns
//    Eval:244273ns
//    Eval:296087ns
//    Eval:321383ns
//    Eval:355737ns
//    Eval:409294ns
//    Eval:446567ns
//    Eval:448846ns
//    Eval:540009ns
//    Eval:556964ns
//    ***********************************************

  //  62541786.5ns  - 0.0625417865s
//    AD time:27580329ns
//    AD time:51094597ns
//    AD time:51141390ns
//    AD time:52409469ns
//    AD time:62183572ns
//    AD time:62900001ns
//    AD time:67774671ns
//    AD time:68720119ns
//    AD time:69703453ns
//    AD time:350036689ns
//    ***********************************************
  //  455630542.5ns -  0.4556305425s
//    AD eval time:316971645ns
//    AD eval time:317148737ns
//    AD eval time:344352093ns
//    AD eval time:366404847ns
//    AD eval time:378573487ns
//    AD eval time:532687598ns
//    AD eval time:568311842ns
//    AD eval time:993695468ns
//    AD eval time:1425702415ns
//    AD eval time:1528733875ns
//    ***********************************************
//  ***********************************************
  //  224128ns - 0.000224128s
//    SD time:213480ns
//    SD time:222010ns
//    SD time:223563ns
//    SD time:223855ns
//    SD time:224042ns
//    SD time:224214ns
//    SD time:225580ns
//    SD time:229119ns
//    SD time:230236ns
//    SD time:1114598ns
//    ***********************************************
  //  403778395.5ns - 0.4037783955s
//    SD eval time:314812406ns
//    SD eval time:342546075ns
//    SD eval time:349683000ns
//    SD eval time:359955826ns
//    SD eval time:363220186ns
//    SD eval time:444336605ns
//    SD eval time:449322848ns
//    SD eval time:500408316ns
//    SD eval time:560663315ns
//    SD eval time:634963972ns



  var x = Param("x")
  var y = Param("y")

  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  //  var x_3 = Param("x_3")
  //  var x_vector = Array(List(x_1, x_2, x_3), x.t)

  var exp = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2, x_1, x_0,x_2, x_2, x_0, x_0, x_1, x_0)



  println("ARRAY LENGTH "+ exp.length + "*******************************************")
  ExprMaxVector.eval(exp, true, true)
}
