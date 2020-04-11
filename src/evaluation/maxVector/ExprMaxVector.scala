package evaluation.maxVector

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._

object ExprMaxVector extends App {
//  ARRAY LENGTH 2*******************************************
//    Eval:0.07078949999999999ms
//    ***********************************************
//  AD time:1.23784ms
//    ***********************************************
//  AD eval time:0.10346649999999999ms
//    ***********************************************
//  ***********************************************
//  SD time:0.04092ms
//    ***********************************************
//  SD eval time:0.0714435ms
//
//    ARRAY LENGTH 4*******************************************
//    Eval:0.0238525ms
//    ***********************************************
//  AD time:2.8436315ms
//    ***********************************************
//  AD eval time:0.3280315ms
//    ***********************************************
//  ***********************************************
//  SD time:0.061073999999999996ms
//    ***********************************************
//  SD eval time:0.282896ms
//
//    ARRAY LENGTH 6*******************************************
//    Eval:0.0279615ms
//    ***********************************************
//  AD time:3.6851464999999997ms
//    ***********************************************
//  AD eval time:0.22052149999999998ms
//    ***********************************************
//  ***********************************************
//  SD time:0.011958499999999999ms
//    ***********************************************
//  SD eval time:0.0839965ms
//
//    ARRAY LENGTH 8*******************************************
//    Eval:0.0089445ms
//    ***********************************************
//  AD time:0.623992ms
//    ***********************************************
//  AD eval time:0.422103ms
//    ***********************************************
//  ***********************************************
//  SD time:0.016788ms
//    ***********************************************
//  SD eval time:0.405611ms
//
//    ARRAY LENGTH 10*******************************************
//    Eval:0.011469ms
//    ***********************************************
//  AD time:0.8679064999999999ms
//    ***********************************************
//  AD eval time:4.9942395ms
//    ***********************************************
//  ***********************************************
//  SD time:0.0128165ms
//    ***********************************************
//  SD eval time:2.117422ms
//
//    ARRAY LENGTH 12*******************************************
//    Eval:0.0079995ms
//    ***********************************************
//  AD time:2.4722915ms
//    ***********************************************
//  AD eval time:12.4898565ms
//    ***********************************************
//  ***********************************************
//  SD time:0.010487999999999999ms
//    ***********************************************
//  SD eval time:9.734451ms
//
//    ARRAY LENGTH 14*******************************************
//    Eval:0.0031975ms
//    ***********************************************
//  AD time:6.189137499999999ms
//    ***********************************************
//  AD eval time:53.38962ms
//    ***********************************************
//  ***********************************************
//  SD time:0.013516499999999999ms
//    ***********************************************
//  SD eval time:45.0732235ms
//
//    ARRAY LENGTH 16*******************************************
//    Eval:0.0019695ms
//    ***********************************************
//  AD time:12.3792005ms
//    ***********************************************
//  AD eval time:161.91311ms
//    ***********************************************
//  ***********************************************
//  SD time:0.0105255ms
//    ***********************************************
//  SD eval time:169.21072099999998ms
//
//    ARRAY LENGTH 18*******************************************
//    Eval:0.002196ms
//    ***********************************************
//  AD time:47.726535999999996ms
//    ***********************************************
//  AD eval time:1340.227016ms
//    ***********************************************
//  ***********************************************
//  SD time:0.0134755ms
//    ***********************************************
//  SD eval time:1517.8163395ms
//
//    ARRAY LENGTH 20*******************************************
//    Eval:0.0119875ms
//    ***********************************************
//  AD time:191.89077899999998ms
//    ***********************************************
//  AD eval time:5795.442661ms
//    ***********************************************
//  ***********************************************
//  SD time:0.0160935ms
//    ***********************************************
//  SD eval time:5656.0145465ms
  def eval(exp: List[Expr], ad : Boolean = false, sd: Boolean = false) {

    var x = Param("x")
    var y = Param("y")

    var vector = Vector(exp, x.t)
    var eval: List[Long] = List()

    for (a <- 0 to 19) {
      val t0 = System.nanoTime()
      (DoubleEvaluator.eval(Fold(GreaterThan(x,y), vector.list.head, vector )))
      val t1 = System.nanoTime()
      eval = eval :+ (t1 - t0)
    }
   var maxVector = (DoubleEvaluator.eval(Fold(GreaterThan(x,y), vector.list.head, vector )))


  eval = eval.sorted

    var resEval = ((eval(9)+eval(10))*0.000001)/2
    //  evalAll.addOne(resEval)
    println( "Eval:" + resEval + "ms")

    if (ad == true) {
      var arrAD: List[Long] = List()
      for (a <- 0 to 19) {
        val t0 = System.nanoTime()
        (AutomaticDifferentiate.autodifferentiate(maxVector, vector))
        val t1 = System.nanoTime()
//        println(a + "AD time:" + (t1 - t0) + "ns")
        arrAD = arrAD :+ (t1 - t0)
      }
      println("***********************************************")
      var AD =  (AutomaticDifferentiate.autodifferentiate(maxVector, vector))
      var ADeval = DoubleEvaluator.eval(AD)
      var arrADEval: List[Long] = List()
      for (a <- 0 to 19) {
        val t0 = System.nanoTime()
        Evaluator.printString(ADeval)
        val t1 = System.nanoTime()
        arrADEval = arrADEval :+ (t1 - t0)
      }

      var sortedADEval = arrADEval.sorted
      var sortedAD = arrAD.sorted
      var resAD =   ((sortedAD(9)+sortedAD(10))*0.000001)/2

      var resADEval =   ((sortedADEval(9)+sortedADEval(10))*0.000001)/2
      println( "AD time:" + resAD + "ms")

      println("***********************************************")
      println( "AD eval time:" +  resADEval+ "ms")
    }


    println("***********************************************")
    println("***********************************************")

    if (sd == true) {
      var arrSD: List[Long] = List()
      for (a <- 0 to 19) {
        val t0 = System.nanoTime()
        DifferentiateExpr.differentiate(maxVector, vector)
        val t1 = System.nanoTime()
        arrSD = arrSD:+(t1-t0)
      }

      var SD = DifferentiateExpr.differentiate(maxVector, vector)
      var SDeval = DoubleEvaluator.eval(SD)
      var arrSDEval: List[Long] = List()
      for (a <- 0 to 19) {
        val t0 = System.nanoTime()
        Evaluator.printString(SDeval)
        val t1 = System.nanoTime()
        arrSDEval = arrSDEval:+(t1-t0)
//        println(a + "SD eval time:" + (t1 - t0)+ "ns")
      }

      var sortedSDEval = arrSDEval.sorted
      var sortedSD = arrSD.sorted

      var resSD =   ((sortedSD(9)+sortedSD(10))*0.000001)/2
      //  SDAll = SDAll :+resSD

      var resSDEval =   ((sortedSDEval(9)+sortedSDEval(10))*0.000001)/2
      // SDEvalAll = SDEvalAll  :+ resSDEval

      //      for(x<- sortedSD){
      println( "SD time:" + resSD+ "ms")
      //      }

      println("***********************************************")

      //      for(x<- sortedSDEval){
      println( "SD eval time:" + resSDEval + "ms")
      println()
    }
  }
}
