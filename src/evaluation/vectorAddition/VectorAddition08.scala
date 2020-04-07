package evaluation.vectorAddition

import intermediateRep.{Array, Param}

object VectorAddition08 extends App{
//
//  ARRAY LENGTH 8*******************************************
//    Eval:900592ns - 0.000900592 /0.000795655
//    ***********************************************
//  AD time:3033068ns - 0.003033068
//    ***********************************************
//  AD eval time:292770ns - 0.00029277
//    ***********************************************
//  ***********************************************
//  SD time:1193199ns - 0.001193199
//    ***********************************************
//  SD eval time:467226ns - 0.000467226

//  ARRAY LENGTH 8*******************************************
//    Eval:647460ns
//    Eval:702648ns
//    Eval:727949ns
//    Eval:728146ns
//    Eval:754965ns
//    Eval:901840ns
//    Eval:914501ns
//    Eval:1038123ns
//    Eval:1545571ns
//    Eval:1936044ns
//    ***********************************************
//  AD time:1522543ns
//    AD time:2240212ns
//    AD time:2563569ns
//    AD time:4478579ns
//    AD time:4572501ns
//    AD time:5705317ns
//    AD time:6236545ns
//    AD time:8063297ns
//    AD time:8064647ns
//    AD time:64467922ns
//    ***********************************************
//  AD eval time:383005ns
//    AD eval time:410645ns
//    AD eval time:430480ns
//    AD eval time:441061ns
//    AD eval time:496173ns
//    AD eval time:499555ns
//    AD eval time:944804ns
//    AD eval time:1318449ns
//    AD eval time:2497243ns
//    AD eval time:17517512ns
//    ***********************************************
//  ***********************************************
//  SD time:397993ns
//    SD time:1042878ns
//    SD time:1069307ns
//    SD time:1109665ns
//    SD time:1119789ns
//    SD time:1551705ns
//    SD time:3313203ns
//    SD time:10440684ns
//    SD time:32607984ns
//    SD time:42326075ns
//    ***********************************************
//  SD eval time:181578ns
//    SD eval time:187923ns
//    SD eval time:196034ns
//    SD eval time:198608ns
//    SD eval time:224739ns
//    SD eval time:890436ns
//    SD eval time:2315689ns
//    SD eval time:2621922ns
//    SD eval time:3490701ns
//    SD eval time:7959306ns



  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp1 = List(
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3)
  //println(exp.length)
  println("ARRAY LENGTH "+ exp1.length + "*******************************************")
  ExprVectorAddition.eval(exp1, true, true)

}
