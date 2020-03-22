package evaluation.vectorAddition

import intermediateRep.{Array, Param}

object VectorAddition08 extends App{

//  ARRAY LENGTH 8*******************************************
//    Eval:664359ns
//    Eval:672931ns
//    Eval:798386ns
//    Eval:832599ns
//    Eval:891206ns
//    Eval:1004540ns
//    Eval:1060223ns
//    Eval:1223235ns
//    Eval:2343513ns
//    Eval:3794284ns
//    ***********************************************
//  AD time:1059965ns
//    AD time:1397460ns
//    AD time:3755262ns
//    AD time:4823454ns
//    AD time:5111846ns
//    AD time:5779771ns
//    AD time:8740945ns
//    AD time:11005639ns
//    AD time:18095899ns
//    AD time:115262995ns
//    ***********************************************
//  AD eval time:270987ns
//    AD eval time:288366ns
//    AD eval time:289200ns
//    AD eval time:295800ns
//    AD eval time:372096ns
//    AD eval time:459220ns
//    AD eval time:509116ns
//    AD eval time:589769ns
//    AD eval time:2639315ns
//    AD eval time:11850776ns
//    ***********************************************
//  ***********************************************
//  SD time:425171ns
//    SD time:426707ns
//    SD time:430056ns
//    SD time:434457ns
//    SD time:443675ns
//    SD time:473614ns
//    SD time:491467ns
//    SD time:731988ns
//    SD time:1462456ns
//    SD time:2750726ns
//    ***********************************************
//  SD eval time:206914ns
//    SD eval time:228354ns
//    SD eval time:267793ns
//    SD eval time:333869ns
//    SD eval time:389327ns
//    SD eval time:515568ns
//    SD eval time:524939ns
//    SD eval time:588954ns
//    SD eval time:11238359ns
//    SD eval time:13127491ns


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
