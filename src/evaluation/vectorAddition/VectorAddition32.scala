package evaluation.vectorAddition

import intermediateRep.Param

object VectorAddition32 extends App{

//  ARRAY LENGTH 32*******************************************
//    Eval:2299410ns - 0.00229941s / 0.002071602
//    ***********************************************
//  AD time:6041637ns - 0.006041637s
//    ***********************************************
//  AD eval time:1871878ns - 0.001871878s
//    ***********************************************
//  ***********************************************
//  SD time:1902682ns - 0.001902682s
//    ***********************************************
//  SD eval time:1701099ns - 0.001701099s

//  ARRAY LENGTH 32*******************************************
//    Eval:2096066ns
//    Eval:2112944ns
//    Eval:2159485ns
//    Eval:2191744ns
//    Eval:2214128ns
//    Eval:2279875ns
//    Eval:2498154ns
//    Eval:2653207ns
//    Eval:3338042ns
//    Eval:3441714ns
//    ***********************************************
//  AD time:2911216ns
//    AD time:3690155ns
//    AD time:3873911ns
//    AD time:4134040ns
//    AD time:5715528ns
//    AD time:9073862ns
//    AD time:10716286ns
//    AD time:15880847ns
//    AD time:21875827ns
//    AD time:98552316ns
//    ***********************************************
//  AD eval time:1681056ns
//    AD eval time:1691566ns
//    AD eval time:1694237ns
//    AD eval time:1698227ns
//    AD eval time:1737862ns
//    AD eval time:1772029ns
//    AD eval time:1980931ns
//    AD eval time:1996005ns
//    AD eval time:5994273ns
//    AD eval time:76322369ns
//    ***********************************************
//  ***********************************************
//  SD time:1704636ns
//    SD time:1803229ns
//    SD time:2053192ns
//    SD time:2141597ns
//    SD time:2199548ns
//    SD time:2218475ns
//    SD time:2838757ns
//    SD time:4775351ns
//    SD time:5708367ns
//    SD time:7050397ns
//    ***********************************************
//  SD eval time:745800ns
//    SD eval time:968686ns
//    SD eval time:1052776ns
//    SD eval time:1300445ns
//    SD eval time:1342439ns
//    SD eval time:1688014ns
//    SD eval time:1702237ns
//    SD eval time:1720166ns
//    SD eval time:1746582ns
//    SD eval time:5762210ns

  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp1 = List(
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3)

  println("ARRAY LENGTH "+ exp1.length + "*******************************************")
  ExprVectorAddition.eval(exp1, true, true)

}
