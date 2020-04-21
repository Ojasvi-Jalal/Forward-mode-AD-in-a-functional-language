package evaluation.vectorAddition

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Expr, Let, Param, Vector}

object ExprVectorAddition extends App {
  //called by VectorAddition08
  def eval(exp: List[Expr], ad : Boolean = false, sd: Boolean = false) {

    var x = Param("x")

    var orignalVector = Vector(exp, x.t)

    var eval: List[Long] = List()

//    for (a <- 0 to 19) {
//      val t0 = System.nanoTime()
//      DoubleEvaluator.eval(Vector(exp, x.t) + Vector(exp, x.t))
//      val t1 = System.nanoTime()
//      eval = eval :+ (t1 - t0)
//    }
   var vector = DoubleEvaluator.eval(orignalVector + orignalVector)
//    eval = eval.sorted
//
//    var resEval = ((eval(9)+eval(10))*0.000001)/2
//    //  evalAll.addOne(resEval)
//    println( "Eval:" + resEval + "ms")
//
//    if (ad == true) {
//      var arrAD: List[Long] = List()
//      for (a <- 0 to 19) {
//        val t0 = System.nanoTime()
//        (AutomaticDifferentiate.autodifferentiate(vector, orignalVector))
//        val t1 = System.nanoTime()
////        println(a + "AD time:" + (t1 - t0) + "ns")
//        arrAD = arrAD :+ (t1 - t0)
//      }
//      println("***********************************************")
//      var AD = (AutomaticDifferentiate.autodifferentiate(vector, orignalVector))
//      var ADeval = DoubleEvaluator.eval(AD)
//      var arrADEval: List[Long] = List()
//      for (a <- 0 to 19) {
//        val t0 = System.nanoTime()
//         Evaluator.printString(ADeval)
////        DoubleEvaluator.eval(AD)
//        val t1 = System.nanoTime()
////        println(a + "AD eval time:" + (t1 - t0)+ "ns")
//        arrADEval = arrADEval :+ (t1 - t0)
//      }
//
//      var sortedADEval = arrADEval.sorted
//      var sortedAD = arrAD.sorted
//      var resAD =   ((sortedAD(9)+sortedAD(10))*0.000001)/2
//
//      var resADEval =   ((sortedADEval(9)+sortedADEval(10))*0.000001)/2
//      println( "AD time:" + resAD + "ms")
//
//      println("***********************************************")
//      println( "AD eval time:" +  resADEval+ "ms")
//    }


    println("***********************************************")
    println("***********************************************")

    if (sd == true) {
      var arrSD: List[Long] = List()
//      for (a <- 0 to 19) {
//        val t0 = System.nanoTime()
//        DifferentiateExpr.differentiate(vector, orignalVector)
//        val t1 = System.nanoTime()
//       // println(a + "SD time:" + (t1 - t0)+ "ns")
//        arrSD = arrSD:+(t1-t0)
//      }

      var SD = DifferentiateExpr.differentiate(vector, orignalVector)
    //  var SDeval = DoubleEvaluator.eval(SD)
      var arrSDEval: List[Long] = List()
      for (a <- 0 to 19) {
        val t0 = System.nanoTime()
       // Evaluator.printString(SDeval)
      DoubleEvaluator.eval(Let(orignalVector,SD,orignalVector))
        val t1 = System.nanoTime()
        arrSDEval = arrSDEval:+(t1-t0)
      }

      var sortedSDEval = arrSDEval.sorted
//      var sortedSD = arrSD.sorted

//      var resSD =   ((sortedSD(9)+sortedSD(10))*0.000001)/2
      //  SDAll = SDAll :+resSD

      var resSDEval =   ((sortedSDEval(9)+sortedSDEval(10))*0.000001)/2
      // SDEvalAll = SDEvalAll  :+ resSDEval

      //      for(x<- sortedSD){
//      println( "SD time:" + resSD+ "ms")
      //      }

      println("***********************************************")

      //      for(x<- sortedSDEval){
      println( "SD eval time:" + resSDEval + "ms")
      println()
    }
  }
}
