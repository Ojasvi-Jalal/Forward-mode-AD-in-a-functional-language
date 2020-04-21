package evaluation.dotProduct

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._

object ExprDotProdVector extends App {
  //called by DotProduct16
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
