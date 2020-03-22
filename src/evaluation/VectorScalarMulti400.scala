package evaluation

import automaticDifferentiation.AutomaticDifferentiate
import intermediateRep.{Array, Param}
import eval.DoubleEvaluator


object VectorScalarMulti256 extends App{

//  ARRAY LENGTH 256*******************************************
//    Eval:1324093ns
//    Eval:1360889ns
//    Eval:2100735ns
//    Eval:2501081ns
//    Eval:3946715ns
//    Eval:4311475ns
//    Eval:6094865ns
//    Eval:6697907ns
//    Eval:8096617ns
//    Eval:16477856ns
//    ***********************************************
//  AD time:3499096ns
//    AD time:8020452ns
//    AD time:12810887ns
//    AD time:14856870ns
//    AD time:16601447ns
//    AD time:25296527ns
//    AD time:26599271ns
//    AD time:29680734ns
//    AD time:40557914ns
//    AD time:106924194ns
//    ***********************************************
//  AD eval time:3466526ns
//    AD eval time:3550195ns
//    AD eval time:3643255ns
//    AD eval time:3675001ns
//    AD eval time:4758215ns
//    AD eval time:5097706ns
//    AD eval time:6942689ns
//    AD eval time:8429993ns
//    AD eval time:14270745ns
//    AD eval time:27765407ns
//    ***********************************************
//  ***********************************************
//  SD time:1320284ns
//    SD time:1353165ns
//    SD time:1398307ns
//    SD time:1399741ns
//    SD time:1414661ns
//    SD time:1515541ns
//    SD time:1795284ns
//    SD time:2150455ns
//    SD time:3689441ns
//    SD time:9214605ns
//    ***********************************************
//  SD eval time:830155ns
//    SD eval time:831006ns
//    SD eval time:841415ns
//    SD eval time:841995ns
//    SD eval time:886747ns
//    SD eval time:899916ns
//    SD eval time:930164ns
//    SD eval time:992711ns
//    SD eval time:7230889ns
//    SD eval time:19599480ns



  var x = Param("x")
  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = DoubleEvaluator.eval((x_1 * x_2))
  var elemtype2 = DoubleEvaluator.eval(x_0 + (x_1 + x_2))
  var elemtype3 = DoubleEvaluator.eval(x_0 * (x_1 / x_2))

  var exp = List(elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3)

  println("ARRAY LENGTH "+ exp.length + "*******************************************")
  var vector = DoubleEvaluator.eval(x * Array(exp, x.t))
  ExprVectorScalar.eval(exp, true, true)
}
