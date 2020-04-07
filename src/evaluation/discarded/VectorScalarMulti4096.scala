package evaluation.discarded

import eval.DoubleEvaluator
import evaluation.ExprVectorScalar
import intermediateRep.{Array, Param}

object VectorScalarMulti4096 extends App {


  //  ARRAY LENGTH 4096*******************************************
  //    Eval:178747464ns
  //    Eval:254213318ns
  //    Eval:270762485ns
  //    Eval:293823892ns
  //    Eval:323447903ns
  //    Eval:327617098ns
  //    Eval:376490586ns
  //    Eval:378819358ns
  //    Eval:438964062ns
  //    Eval:644369985ns
  //    ***********************************************
  //  AD time:125538547ns
  //    AD time:128212560ns
  //    AD time:141456898ns
  //    AD time:146478478ns
  //    AD time:149752429ns
  //    AD time:160386705ns
  //    AD time:165587450ns
  //    AD time:208998634ns
  //    AD time:279104582ns
  //    AD time:521191588ns
  //    ***********************************************
  //  AD eval time:60145488ns
  //    AD eval time:61183020ns
  //    AD eval time:63027388ns
  //    AD eval time:68630042ns
  //    AD eval time:70338008ns
  //    AD eval time:87596518ns
  //    AD eval time:106177509ns
  //    AD eval time:113429966ns
  //    AD eval time:117685020ns
  //    AD eval time:144212779ns
  //    ***********************************************
  //  ***********************************************
  //  SD time:62782453ns
  //    SD time:63394977ns
  //    SD time:63607588ns
  //    SD time:63955110ns
  //    SD time:69224688ns
  //    SD time:82360487ns
  //    SD time:93959600ns
  //    SD time:105447630ns
  //    SD time:158504890ns
  //    SD time:196068078ns
  //    ***********************************************
  //  SD eval time:57821244ns
  //    SD eval time:58951397ns
  //    SD eval time:59514619ns
  //    SD eval time:60936734ns
  //    SD eval time:61298320ns
  //    SD eval time:69680947ns
  //    SD eval time:70404170ns
  //    SD eval time:75489672ns
  //    SD eval time:80076388ns
  //    SD eval time:80289013ns


  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = DoubleEvaluator.eval((x_1 * x_2))

  var elemtype2 = DoubleEvaluator.eval(x_0 + (x_1 + x_2))
  var elemtype3 = DoubleEvaluator.eval(x_0 * (x_1 / x_2))

  var exp = List(elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3
  )

  println("ARRAY LENGTH "+ exp.length + "*******************************************")
  var vector = DoubleEvaluator.eval(x * Array(exp, x.t))
  ExprVectorScalar.eval(exp, true, true)



}
