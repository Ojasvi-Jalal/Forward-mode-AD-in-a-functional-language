package evaluation

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Array, Expr, Param}

object VectorScalarMulti10 extends App {
  //10

  //differentiate: 0.002931235s

  //2180664ns
  //2412407ns
  //2575101ns
  //2862151ns
  //2871662ns
  //2990808ns
  //3270491ns
  //4240548ns
  //4581166ns
  //5636753ns

  //differentiate-eval:  758967ns: 0.000758967
  //2930520ns
  //3731983ns
  //4272839ns
  //536545ns
  //749418ns
  //768516ns
  //808736ns
  //838526ns
  //839280ns
  //869837ns


  //automatic-diff: 35667525.5ns:  0.0356675255


  //31581973ns
  //31914150ns
  //32278292ns
  //32450484ns
  //33236232ns
  //38098819ns
  //38503962ns
  //39362038ns
  //44681961ns
  //128106073ns

  def eval(rawArray: List[Expr], ad : Boolean = false, sd: Boolean = false) {

    var x = Param("x")

    var vector = DoubleEvaluator.eval(x * Array(rawArray, x.t))

    var eval: List[Long] = List()

    for (a <- 0 to 9) {
      val t0 = System.nanoTime()
      DoubleEvaluator.eval(x * Array(rawArray, x.t))
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
        DoubleEvaluator.eval(AD)
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
        DoubleEvaluator.eval(SD)
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
