package evaluation.vectorAddition

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Vector, Expr, Param}

object ExprVectorAddition extends App {

//  ARRAY LENGTH 8*******************************************
//  Eval:0.605345ms
//    ***********************************************
//  AD time:1.218548ms
//    ***********************************************
//  AD eval time:0.183281ms
//    ***********************************************
//  ***********************************************
//  SD time:0.2535385ms
//    ***********************************************
//  SD eval time:0.225381ms
//
//    ARRAY LENGTH 32*******************************************
//    Eval:0.160989ms
//    ***********************************************
//  AD time:4.0107515ms
//    ***********************************************
//  AD eval time:0.661868ms
//    ***********************************************
//  ***********************************************
//  SD time:2.9087665ms
//    ***********************************************
//  SD eval time:0.588515ms
//
//    ARRAY LENGTH 32*******************************************
//    Eval:0.1200465ms
//    ***********************************************
//  AD time:3.028281ms
//    ***********************************************
//  AD eval time:0.3267075ms
//    ***********************************************
//  ***********************************************
//  SD time:0.8887335ms
//    ***********************************************
//  SD eval time:0.3602205ms
//
//    ARRAY LENGTH 72*******************************************
//    Eval:0.17431549999999998ms
//    ***********************************************
//  AD time:11.2896185ms
//    ***********************************************
//  AD eval time:6.8099915ms
//    ***********************************************
//  ***********************************************
//  SD time:8.4703695ms
//    ***********************************************
//  SD eval time:2.55253ms
//
//    ARRAY LENGTH 128*******************************************
//    Eval:0.40285299999999996ms
//    ***********************************************
//  AD time:53.020312499999996ms
//    ***********************************************
//  AD eval time:8.677412ms
//    ***********************************************
//  ***********************************************
//  SD time:17.7974685ms
//    ***********************************************
//  SD eval time:9.6787475ms
//
//    ARRAY LENGTH 170*******************************************
//    Eval:0.303844ms
//    ***********************************************
//  AD time:61.0601345ms
//    ***********************************************
//  AD eval time:21.517269499999998ms
//    ***********************************************
//  ***********************************************
//  SD time:47.827132ms
//    ***********************************************
//  SD eval time:58.2684375ms
//
//    ARRAY LENGTH 212*******************************************
//    Eval:0.631724ms
//    ***********************************************
//  AD time:249.01454299999997ms
//    ***********************************************
//  AD eval time:70.7033175ms
//    ***********************************************
//  ***********************************************
//  SD time:93.885669ms
//    ***********************************************
//  SD eval time:60.442570499999995ms
//
//    ARRAY LENGTH 256*******************************************
//    Eval:0.6126125ms
//    ***********************************************
//  AD time:239.20075ms
//    ***********************************************
//  AD eval time:72.1791665ms
//    ***********************************************
//  ***********************************************
//  SD time:155.134569ms
//    ***********************************************
//  SD eval time:67.746935ms
//
//    ARRAY LENGTH 318*******************************************
//    Eval:0.75446ms
//    ***********************************************
//  AD time:465.113068ms
//    ***********************************************
//  AD eval time:120.064071ms
//    ***********************************************
//  ***********************************************
//  SD time:234.32188ms
//    ***********************************************
//  SD eval time:133.64288399999998ms
//
//    ARRAY LENGTH 418*******************************************
//    Eval:1.275306ms
//    ***********************************************
//  AD time:918.8442285ms
//    ***********************************************
//  AD eval time:247.178308ms
//    ***********************************************
//  ***********************************************
//  SD time:626.989232ms
//    ***********************************************
//  SD eval time:257.8536755ms
//
//    ARRAY LENGTH 452*******************************************
//    Eval:1.539177ms
//    ***********************************************
//  AD time:1130.9514729999999ms
//    ***********************************************
//  AD eval time:320.1175915ms
//    ***********************************************
//  ***********************************************
//  SD time:751.5799955ms
//    ***********************************************
//  SD eval time:313.456281ms
//
//    ARRAY LENGTH 518*******************************************
//    Eval:1.9371235ms
//    ***********************************************
//  AD time:1696.1755695ms
//    ***********************************************
//  AD eval time:480.5763765ms
//    ***********************************************
//  ***********************************************
//  SD time:1045.8112879999999ms
//    ***********************************************
//  SD eval time:466.5268855ms
//
//    ARRAY LENGTH 636*******************************************
//    Eval:2.7406845ms
//    ***********************************************
//  AD time:3111.911478ms
//    ***********************************************
//  AD eval time:885.298007ms
//    ***********************************************
//  ***********************************************
//  SD time:1839.18596ms
//    ***********************************************
//  SD eval time:845.4823974999999ms
//
//    ARRAY LENGTH 1272*******************************************
//    Eval:10.331147ms
//    ***********************************************
//  AD time:23860.0715065ms
//    ***********************************************
//  AD eval time:7182.6613325ms
//    ***********************************************
//  ***********************************************
//  SD time:14983.205847ms
//    ***********************************************
//  SD eval time:6882.961499499999ms
//
//    len List(8, 32, 32, 72, 128, 170, 212, 256, 318, 418, 452, 518, 636, 1272)


  def eval(exp: List[Expr], ad : Boolean = false, sd: Boolean = false) {

    var x = Param("x")

    var orignalVector = Vector(exp, x.t)

    var eval: List[Long] = List()

    for (a <- 0 to 19) {
      val t0 = System.nanoTime()
      DoubleEvaluator.eval(Vector(exp, x.t) + Vector(exp, x.t))
      val t1 = System.nanoTime()
      eval = eval :+ (t1 - t0)
    }
    var vector = DoubleEvaluator.eval(orignalVector + orignalVector)
    eval = eval.sorted

    var resEval = ((eval(9)+eval(10))*0.000001)/2
    //  evalAll.addOne(resEval)
    println( "Eval:" + resEval + "ms")

    if (ad == true) {
      var arrAD: List[Long] = List()
      for (a <- 0 to 19) {
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
      for (a <- 0 to 19) {
        val t0 = System.nanoTime()
         Evaluator.printString(ADeval)
//        DoubleEvaluator.eval(AD)
        val t1 = System.nanoTime()
//        println(a + "AD eval time:" + (t1 - t0)+ "ns")
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
        DifferentiateExpr.differentiate(vector, orignalVector)
        val t1 = System.nanoTime()
       // println(a + "SD time:" + (t1 - t0)+ "ns")
        arrSD = arrSD:+(t1-t0)
      }

      var SD = DifferentiateExpr.differentiate(vector, orignalVector)
      var SDeval = DoubleEvaluator.eval(SD)
      var arrSDEval: List[Long] = List()
      for (a <- 0 to 19) {
        val t0 = System.nanoTime()
        Evaluator.printString(SDeval)
//       DoubleEvaluator.eval(SD)
        val t1 = System.nanoTime()
        arrSDEval = arrSDEval:+(t1-t0)
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
