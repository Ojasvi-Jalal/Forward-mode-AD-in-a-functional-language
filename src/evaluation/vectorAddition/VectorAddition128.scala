package evaluation.vectorAddition

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Vector, Param}

object VectorAddition128 extends App{

//  ARRAY LENGTH 128*******************************************
//    Eval:7019784ns - 0.007019784 / 0.009129581
//    ***********************************************
//  AD time:89900630ns - 0.08990063
//    ***********************************************
//  AD eval time:22568257ns - 0.022568257
//    ***********************************************
//  ***********************************************
//  SD time:37493618ns - 0.037493618
//    ***********************************************
//  SD eval time:11589405ns - 0.011589405

  //  ARRAY LENGTH 128*******************************************
//    Eval:1003070ns
//    Eval:1191824ns
//    Eval:1740310ns
//    Eval:2086424ns
//    Eval:2297458ns
//    Eval:2927224ns
//    Eval:7616597ns
//    Eval:12014363ns
//    Eval:20240048ns
//    Eval:21074114ns
//    ***********************************************
//  AD time:39032044ns
//    AD time:47789225ns
//    AD time:49949695ns
//    AD time:77004004ns
//    AD time:87944419ns
//    AD time:89672536ns
//    AD time:136688769ns
//    AD time:172565306ns
//    AD time:193025471ns
//    AD time:267237518ns
//    ***********************************************
//  AD eval time:13486867ns
//    AD eval time:21192916ns
//    AD eval time:23423639ns
//    AD eval time:23571992ns
//    AD eval time:23596380ns
//    AD eval time:27345359ns
//    AD eval time:27416043ns
//    AD eval time:37592963ns
//    AD eval time:97875227ns
//    AD eval time:278072969ns
//    ***********************************************
//  ***********************************************
//  SD time:23300882ns
//    SD time:27526642ns
//    SD time:29009751ns
//    SD time:29203567ns
//    SD time:29975140ns
//    SD time:32204559ns
//    SD time:72166892ns
//    SD time:86954548ns
//    SD time:146300062ns
//    SD time:184650070ns
//    ***********************************************
//  SD eval time:10187216ns
//    SD eval time:10197101ns
//    SD eval time:10240343ns
//    SD eval time:10297934ns
//    SD eval time:10712295ns
//    SD eval time:10828428ns
//    SD eval time:11692127ns
//    SD eval time:11859933ns
//    SD eval time:15774277ns
//    SD eval time:16538489ns

  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp1 = List( x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,x_1, x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
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
