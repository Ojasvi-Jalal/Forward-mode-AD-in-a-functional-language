package evaluation.vectorAddition

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Array, Expr, Param}

object ExprVectorScalar extends App {

  def eval(exp: List[Expr], ad : Boolean = false, sd: Boolean = false) {

    var x = Param("x")

    var vector = DoubleEvaluator.eval(x * Array(exp, x.t))

    var eval: List[Long] = List()

    for (a <- 0 to 9) {
      val t0 = System.nanoTime()
      DoubleEvaluator.eval(x * Array(exp, x.t))
      val t1 = System.nanoTime()
      //        println(a + "AD time:" + (t1 - t0) + "ns")
      eval = eval :+ (t1 - t0)
    }

    eval = eval.sorted
    for(x<- eval){
      println( "Eval:" + x+ "ns")
    }

    if (ad == true) {
      var arrAD: List[Long] = List()
      for (a <- 0 to 9) {
        val t0 = System.nanoTime()
        (AutomaticDifferentiate.autodifferentiate(vector, x))
        val t1 = System.nanoTime()
//        println(a + "AD time:" + (t1 - t0) + "ns")
        arrAD = arrAD :+ (t1 - t0)
      }
      println("***********************************************")
      var AD = (AutomaticDifferentiate.autodifferentiate(vector, x))
      var arrADEval: List[Long] = List()
      for (a <- 0 to 9) {
        val t0 = System.nanoTime()
        Evaluator.printString(AD)
        val t1 = System.nanoTime()
//        println(a + "AD eval time:" + (t1 - t0)+ "ns")
        arrADEval = arrADEval :+ (t1 - t0)
      }

      var sortedADEval = arrADEval.sorted
      var sortedAD = arrAD.sorted

      for(x<- sortedAD){
        println( "AD time:" + x+ "ns")
      }

      println("***********************************************")

      for(x<- sortedADEval){
        println( "AD eval time:" + x+ "ns")
      }
    }


    println("***********************************************")
    println("***********************************************")

    if (sd == true) {
      var arrSD: List[Long] = List()
      for (a <- 0 to 9) {
        val t0 = System.nanoTime()
        DifferentiateExpr.differentiate(vector, x)
        val t1 = System.nanoTime()
       // println(a + "SD time:" + (t1 - t0)+ "ns")
        arrSD = arrSD:+(t1-t0)
      }

      var SD = DifferentiateExpr.differentiate(vector, x)
      var arrSDEval: List[Long] = List()
      for (a <- 0 to 9) {
        val t0 = System.nanoTime()
        Evaluator.printString(SD)
        val t1 = System.nanoTime()
        arrSDEval = arrSDEval:+(t1-t0)
//        println(a + "SD eval time:" + (t1 - t0)+ "ns")
      }

      var sortedSDEval = arrSDEval.sorted
      var sortedSD = arrSD.sorted

      for(x<- sortedSD){
        println( "SD time:" + x+ "ns")
      }

      println("***********************************************")

      for(x<- sortedSDEval){
        println( "SD eval time:" + x+ "ns")
      }
    }
  }
}
