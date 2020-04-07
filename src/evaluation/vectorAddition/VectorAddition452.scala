package evaluation.vectorAddition

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Array, Param}

object VectorAddition452 extends App{

//  ARRAY LENGTH 452*******************************************
  ////    Eval:3163156ns - 0.003163156s / /0.012059915
  ////    ***********************************************
  ////  AD time:1347436431ns - 1.347436431s
  ////    ***********************************************
  ////  AD eval time:317098913ns - 0.317098913s
  ////    ***********************************************
  ////  ***********************************************
  ////  SD time:689439302ns - 0.689439302
  ////    ***********************************************
  ////  SD eval time:326065259ns - 0.326065259



//  ARRAY LENGTH 452*******************************************
//    Eval:3218360ns
//    Eval:4253927ns
//    Eval:6425585ns
//    Eval:6513335ns
//    Eval:7702236ns
//    Eval:16566322ns
//    Eval:20501783ns
//    Eval:24354517ns
//    Eval:32087192ns
//    Eval:35521700ns
//    ***********************************************
//  AD time:1307140386ns
//    AD time:1323100143ns
//    AD time:1340407957ns
//    AD time:1347325795ns
//    AD time:1352306748ns
//    AD time:1393964924ns
//    AD time:1590779226ns
//    AD time:1823346786ns
//    AD time:2041591573ns
//    AD time:3962005278ns
//    ***********************************************
//  AD eval time:352726070ns
//    AD eval time:354973548ns
//    AD eval time:360621347ns
//    AD eval time:372570479ns
//    AD eval time:404624632ns
//    AD eval time:412836651ns
//    AD eval time:426007482ns
//    AD eval time:445320308ns
//    AD eval time:491869644ns
//    AD eval time:643347550ns
//    ***********************************************
//  ***********************************************
//  SD time:675857663ns
//    SD time:676026881ns
//    SD time:683382647ns
//    SD time:731505920ns
//    SD time:753345952ns
//    SD time:756155049ns
//    SD time:801540613ns
//    SD time:853930737ns
//    SD time:893417365ns
//    SD time:978433025ns
//    ***********************************************
//  SD eval time:303530688ns
//    SD eval time:307617949ns
//    SD eval time:311297723ns
//    SD eval time:314726517ns
//    SD eval time:316176251ns
//    SD eval time:341513937ns
//    SD eval time:392282539ns
//    SD eval time:396441520ns
//    SD eval time:399888460ns
//    SD eval time:434092005ns


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp1 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1,
    x_2, x_1, x_2, x_2, x_2, x_0, x_1, x_0, x_1,
    x_0, x_2, x_2, x_2, x_1, x_1, x_1, x_0, x_2,
    x_2, x_2, x_2, x_1, x_1, x_1, x_2, x_1, x_0,
    x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
    x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_1, x_2,
    x_0, x_0, x_2, x_0, x_0, x_0, x_1, x_0, x_2, x_0,x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1,
    x_2, x_1, x_2, x_2, x_2, x_0, x_1, x_0, x_1,
    x_0, x_2, x_2, x_2, x_1, x_1, x_1, x_0, x_2,
    x_2, x_2, x_2, x_1, x_1, x_1, x_2, x_1, x_0,
    x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
    x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_1, x_2,
    x_0, x_0, x_2, x_0, x_0, x_0, x_1, x_0, x_2, x_0,x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1,
    x_2, x_1, x_2, x_2, x_2, x_0, x_1, x_0, x_1,
    x_0, x_2, x_2, x_2, x_1, x_1, x_1, x_0, x_2,
    x_2, x_2, x_2, x_1, x_1, x_1, x_2, x_1, x_0,
    x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
    x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_1, x_2,
    x_0, x_0, x_2, x_0, x_0, x_0, x_1, x_0, x_2, x_0,x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1, x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1,    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1, x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2)


  println("ARRAY LENGTH "+ exp1.length + "*******************************************")
  ExprVectorAddition.eval(exp1, true, true)
}
