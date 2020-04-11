package evaluation.dotProduct

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._

object ExprDotProdVector extends App {
//  ARRAY LENGTH 16*******************************************
//    Eval:1.3862189999999999ms
//    ***********************************************
//  AD time:13.7504025ms
//    ***********************************************
//  AD eval time:1.474268ms
//    ***********************************************
//  ***********************************************
//  SD time:0.82614ms
//    ***********************************************
//  SD eval time:0.5115275ms
//
//    ARRAY LENGTH 32*******************************************
//    Eval:0.3651915ms
//    ***********************************************
//  AD time:16.073643999999998ms
//    ***********************************************
//  AD eval time:6.986623499999999ms
//    ***********************************************
//  ***********************************************
//  SD time:0.723158ms
//    ***********************************************
//  SD eval time:2.392763ms
//
//    ARRAY LENGTH 48*******************************************
//    Eval:0.203426ms
//    ***********************************************
//  AD time:49.158677499999996ms
//    ***********************************************
//  AD eval time:2.971409ms
//    ***********************************************
//  ***********************************************
//  SD time:0.6913205ms
//    ***********************************************
//  SD eval time:4.0898785ms
//
//    ARRAY LENGTH 64*******************************************
//    Eval:0.24425799999999998ms
//    ***********************************************
//  AD time:67.447706ms
//    ***********************************************
//  AD eval time:5.7356495ms
//    ***********************************************
//  ***********************************************
//  SD time:1.008605ms
//    ***********************************************
//  SD eval time:5.6372805ms
//
//    ARRAY LENGTH 80*******************************************
//    Eval:0.1440425ms
//    ***********************************************
//  AD time:262.5893085ms
//    ***********************************************
//  AD eval time:10.527217ms
//    ***********************************************
//  ***********************************************
//  SD time:1.537444ms
//    ***********************************************
//  SD eval time:11.4948845ms
//
//    ARRAY LENGTH 96*******************************************
//    Eval:0.26097ms
//    ***********************************************
//  AD time:1192.7397355ms
//    ***********************************************
//  AD eval time:16.6254485ms
//    ***********************************************
//  ***********************************************
//  SD time:2.2319085ms
//    ***********************************************
//  SD eval time:17.9030505ms
//
//    ARRAY LENGTH 112*******************************************
//    Eval:0.25984ms
//    ***********************************************
//  AD time:2233.9904005ms
//    ***********************************************
//  AD eval time:25.4498215ms
//    ***********************************************
//  ***********************************************
//  SD time:3.018128ms
//    ***********************************************
//  SD eval time:32.483456ms
//
//    ARRAY LENGTH 114*******************************************
//    Eval:0.203959ms
//    ***********************************************
//  AD time:1630.1412785ms
//    ***********************************************
//  AD eval time:25.371252ms
//    ***********************************************
//  ***********************************************
//  SD time:3.092199ms
//    ***********************************************
//  SD eval time:33.757267ms
//
//    ARRAY LENGTH 128*******************************************
//    Eval:0.242809ms
//    ***********************************************
//  AD time:5282.258475ms
//    ***********************************************
//  AD eval time:35.8746775ms
//    ***********************************************
//  ***********************************************
//  SD time:3.8810914999999997ms
//    ***********************************************
//  SD eval time:44.194569ms
//
//    ARRAY LENGTH 142*******************************************
//    Eval:0.2841295ms
//    ***********************************************
//  AD time:3849.4559845ms
//    ***********************************************
//  AD eval time:48.0349825ms
//    ***********************************************
//  ***********************************************
//  SD time:4.835564499999999ms
//    ***********************************************
//  SD eval time:59.652562499999995ms
//
//    ARRAY LENGTH 156*******************************************
//    Eval:0.3281595ms
//    ***********************************************
//  AD time:16322.575229ms
//    ***********************************************
//  AD eval time:7809.048484999999ms
//    ***********************************************
//  ***********************************************
//  SD time:5.85739ms
//    ***********************************************
//  SD eval time:68.89065049999999ms

  def eval(exp: List[Expr], ad : Boolean = false, sd: Boolean = false) {

    var x = Param("x")
    var y = Param("y")

    var vector = Vector(exp, x.t)
    var dot = DoubleEvaluator.eval(DotProduct(vector, vector))

    var eval: List[Long] = List()

    for (a <- 0 to 19) {
      val t0 = System.nanoTime()
      DoubleEvaluator.eval(DotProduct(vector, vector))
      val t1 = System.nanoTime()
      eval = eval :+ (t1 - t0)
    }

    eval = eval.sorted

    var resEval = ((eval(9)+eval(10))*0.000001)/2
    println( "Eval:" + resEval + "ms")

    if (ad == true) {
      var arrAD: List[Long] = List()
      for (a <- 0 to 19) {
        val t0 = System.nanoTime()
        (AutomaticDifferentiate.autodifferentiate(dot, vector))
        val t1 = System.nanoTime()
        arrAD = arrAD :+ (t1 - t0)
      }
      println("***********************************************")
      var AD =  (AutomaticDifferentiate.autodifferentiate(dot, vector))
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
        DifferentiateExpr.differentiate(dot, vector)
        val t1 = System.nanoTime()
        arrSD = arrSD:+(t1-t0)
      }

      var SD = DifferentiateExpr.differentiate(dot, vector)
      var SDeval = DoubleEvaluator.eval(SD)
      var arrSDEval: List[Long] = List()
      for (a <- 0 to 19) {
        val t0 = System.nanoTime()
        Evaluator.printString(SDeval)
        val t1 = System.nanoTime()
        arrSDEval = arrSDEval:+(t1-t0)
      }

      var sortedSDEval = arrSDEval.sorted
      var sortedSD = arrSD.sorted

      var resSD =   ((sortedSD(9)+sortedSD(10))*0.000001)/2

      var resSDEval =   ((sortedSDEval(9)+sortedSDEval(10))*0.000001)/2

      println( "SD time:" + resSD+ "ms")
      println("***********************************************")

      println( "SD eval time:" + resSDEval + "ms")
      println()
    }
  }
}
