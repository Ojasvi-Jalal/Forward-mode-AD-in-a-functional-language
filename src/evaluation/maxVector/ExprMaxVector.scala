package evaluation.maxVector

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._

object ExprMaxVector extends App {

  def eval(exp: List[Expr], ad : Boolean = false, sd: Boolean = false) {

    var x = Param("x")
    var y = Param("y")

    var vector = Array(exp, x.t)
    var maxVector = (DoubleEvaluator.eval(Fold(GreaterThan(x,y), vector.list.head, vector )))

    var eval: List[Long] = List()

    for (a <- 0 to 9) {
      val t0 = System.nanoTime()
      (DoubleEvaluator.eval(Fold(GreaterThan(x,y), vector.list.head, vector )))
      val t1 = System.nanoTime()
      eval = eval :+ (t1 - t0)
    }

    eval = eval.sorted

    println( "Eval:" + (eval(4)+eval(5))/2+ "ns")

    if (ad == true) {
      var arrAD: List[Long] = List()
      for (a <- 0 to 9) {
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
      for (a <- 0 to 9) {
        val t0 = System.nanoTime()
        Evaluator.printString(ADeval)
        val t1 = System.nanoTime()
        arrADEval = arrADEval :+ (t1 - t0)
      }

     var sortedADEval = arrADEval.sorted
      var sortedAD = arrAD.sorted


      println( "AD time:" + (sortedAD (4)+sortedAD (5))/2 + "ns")

      println("***********************************************")

      //      for(x<- sortedADEval){
      println( "AD eval time:" + (sortedADEval(4)+sortedADEval(5))/2+ "ns")
    }


    println("***********************************************")
    println("***********************************************")

    if (sd == true) {
      var arrSD: List[Long] = List()
      for (a <- 0 to 9) {
        val t0 = System.nanoTime()
        DifferentiateExpr.differentiate(maxVector, vector)
        val t1 = System.nanoTime()
        arrSD = arrSD:+(t1-t0)
      }

      var SD = DifferentiateExpr.differentiate(maxVector, vector)
      var SDeval = DoubleEvaluator.eval(SD)
      var arrSDEval: List[Long] = List()
      for (a <- 0 to 9) {
        val t0 = System.nanoTime()
        Evaluator.printString(SDeval)
        val t1 = System.nanoTime()
        arrSDEval = arrSDEval:+(t1-t0)
//        println(a + "SD eval time:" + (t1 - t0)+ "ns")
      }

      var sortedSDEval = arrSDEval.sorted
      var sortedSD = arrSD.sorted

      //      for(x<- sortedSD){
      println( "SD time:" + (sortedSD(4)+sortedSD(5))/2+ "ns")
      //      }

      println("***********************************************")

      //      for(x<- sortedSDEval){
      println( "SD eval time:" + (sortedSDEval(4)+sortedSDEval(5))/2+ "ns")
      //      }
    }
  }
}
