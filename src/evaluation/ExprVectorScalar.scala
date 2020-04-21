package evaluation

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import scala.collection.mutable
import scala.collection.mutable.Queue
import intermediateRep.{Vector, Expr, Param}


object ExprVectorScalar extends App {
  //called by VectorScalarMult16
  var evalAll: List[Double] = Nil
  var ADAll= Queue[Double]()
  var ADEvalAll= Queue[Double]()
  var SDAll= Queue[Double]()
  var SDEvalAll= Queue[Double]()

  def eval(exp: Seq[Expr], ad : Boolean = false, sd: Boolean = false) {

    var x = Param("x")

    var eval: List[Double] = List()

    for (a <- 0 to 19) {
      val t0 = System.nanoTime()
      DoubleEvaluator.eval(x * Vector(exp, x.t))
      val t1 = System.nanoTime()
      eval = eval :+ ((t1 - t0))
    }

    eval = eval.sorted

    var vector = DoubleEvaluator.eval(x * Vector(exp, x.t))

      var resEval = ((eval(9)+eval(10))*0.000001)/2
      //evalAll =  (resEval) ::evalAll
      println( "Eval:" + resEval + "ms")

    if (ad == true) {
      var arrAD: List[Long] = List()
      for (a <- 0 to 19) {
        val t0 = System.nanoTime()
        (AutomaticDifferentiate.autodifferentiate(vector, x))
        val t1 = System.nanoTime()
//        println(a + "AD time:" + (t1 - t0) + "ns")
        arrAD = arrAD :+ (t1 - t0)
      }
      println("***********************************************")
      var AD = (AutomaticDifferentiate.autodifferentiate(vector, x))
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
      //ADAll = ADAll :+resAD

      var resADEval =   ((sortedADEval(9)+sortedADEval(10))*0.000001)/2
     // ADEvalAll = ADEvalAll  :+ resADEval
      println( "AD time:" + resAD + "ms")

      println("***********************************************")

//      for(x<- sortedADEval){
        println( "AD eval time:" +  resADEval+ "ms")
//      }
    }


    println("***********************************************")
    println("***********************************************")

    if (sd == true) {
      var arrSD: List[Long] = List()
      for (a <- 0 to 19) {
        val t0 = System.nanoTime()
        DifferentiateExpr.differentiate(vector, x)
        val t1 = System.nanoTime()
       // println(a + "SD time:" + (t1 - t0)+ "ns")
        arrSD = arrSD:+(t1-t0)
      }

      var SD = DifferentiateExpr.differentiate(vector, x)
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
//      }
    }
  }

  def print(): Unit ={
//    println("eval "+evalAll)
//    println("AD "+ADAll)
//    println("ADEval "+ADEvalAll)
//    println("SD "+SDAll)
//    println("SDEval "+SDEvalAll)
  }
}
