package evaluation.vectorAddition

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Array, Expr, Param}

object ExprVectorAddition extends App {


//  ARRAY LENGTH 8*******************************************
//    Eval:623351ns
//    Eval:704408ns
//    Eval:970078ns
//    Eval:1057525ns
//    Eval:1496495ns
//    Eval:1579997ns
//    Eval:1820520ns
//    Eval:1829980ns
//    Eval:2271398ns
//    Eval:3067472ns
//    ***********************************************
//  AD time:1810154ns
//    AD time:2574262ns
//    AD time:3070460ns
//    AD time:4633624ns
//    AD time:4635857ns
//    AD time:4872695ns
//    AD time:5266443ns
//    AD time:5787102ns
//    AD time:6246742ns
//    AD time:88018520ns
//    ***********************************************
//  AD eval time:31571ns
//    AD eval time:32084ns
//    AD eval time:32940ns
//    AD eval time:35748ns
//    AD eval time:37376ns
//    AD eval time:39667ns
//    AD eval time:40179ns
//    AD eval time:51122ns
//    AD eval time:54705ns
//    AD eval time:60824ns
//    ***********************************************
//  ***********************************************
//  SD time:1509573ns
//    SD time:1548091ns
//    SD time:2074604ns
//    SD time:2253667ns
//    SD time:2488750ns
//    SD time:2931756ns
//    SD time:3242540ns
//    SD time:3766568ns
//    SD time:4050439ns
//    SD time:5708238ns
//    ***********************************************
//  SD eval time:5969ns
//    SD eval time:5976ns
//    SD eval time:6227ns
//    SD eval time:6260ns
//    SD eval time:6314ns
//    SD eval time:6340ns
//    SD eval time:7218ns
//    SD eval time:7480ns
//    SD eval time:8554ns
//    SD eval time:17106ns


  def eval(exp: List[Expr], ad : Boolean = false, sd: Boolean = false) {

    var x = Param("x")

    var orignalVector = Array(exp, x.t)

    var eval: List[Long] = List()

    for (a <- 0 to 9) {
      val t0 = System.nanoTime()
      DoubleEvaluator.eval(Array(exp, x.t) + Array(exp, x.t))
      val t1 = System.nanoTime()
      eval = eval :+ (t1 - t0)
    }
    var vector = DoubleEvaluator.eval(orignalVector + orignalVector)
    eval = eval.sorted
//    for(x<- eval){
//      println( "Eval:" + x+ "ns")
//    }

    println( "Eval:" + (eval(4)+eval(5))/2+ "ns")

    if (ad == true) {
      var arrAD: List[Long] = List()
      for (a <- 0 to 9) {
        val t0 = System.nanoTime()
        (AutomaticDifferentiate.autodifferentiate(vector, orignalVector))
        val t1 = System.nanoTime()
//        println(a + "AD time:" + (t1 - t0) + "ns")
        arrAD = arrAD :+ (t1 - t0)
      }
      println("***********************************************")
      var AD = (AutomaticDifferentiate.autodifferentiate(vector, orignalVector))
      var ADeval = DoubleEvaluator.eval(AD)
      var arrADEval: List[Long] = List()
      for (a <- 0 to 9) {
        val t0 = System.nanoTime()
         Evaluator.printString(ADeval)
//        DoubleEvaluator.eval(AD)
        val t1 = System.nanoTime()
//        println(a + "AD eval time:" + (t1 - t0)+ "ns")
        arrADEval = arrADEval :+ (t1 - t0)
      }

      var sortedADEval = arrADEval.sorted
      var sortedAD = arrAD.sorted

      println( "AD time:" + (sortedAD (4)+sortedAD (5))/2 + "ns")

      println("***********************************************")

      //      for(x<- sortedADEval){
      println( "AD eval time:" + (sortedADEval(4)+sortedADEval(5))/2+ "ns")
      //      }
    }


    println("***********************************************")
    println("***********************************************")

    if (sd == true) {
      var arrSD: List[Long] = List()
      for (a <- 0 to 9) {
        val t0 = System.nanoTime()
        DifferentiateExpr.differentiate(vector, orignalVector)
        val t1 = System.nanoTime()
       // println(a + "SD time:" + (t1 - t0)+ "ns")
        arrSD = arrSD:+(t1-t0)
      }

      var SD = DifferentiateExpr.differentiate(vector, orignalVector)
      var SDeval = DoubleEvaluator.eval(SD)
      var arrSDEval: List[Long] = List()
      for (a <- 0 to 9) {
        val t0 = System.nanoTime()
        Evaluator.printString(SDeval)
//       DoubleEvaluator.eval(SD)
        val t1 = System.nanoTime()
        arrSDEval = arrSDEval:+(t1-t0)
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
