package evaluationVectorVar

import automaticDifferentiation.AutomaticDifferentiate
import eval.DoubleEvaluator
import intermediateRep._

object vectorAdditionVar extends App{
//
//
//  len: List(8, 128, 212, 318, 418, 518, 636, 736, 836, 936)
//  ADAll: List(0.256015, 0.23773049999999998, 0.24179099999999998, 0.16368149999999998, 0.19736499999999998, 0.217949, 0.2308245, 0.23703849999999999, 0.27137249999999996, 0.157438)
//  ADEvalAll: List(0.036622499999999995, 0.0346065, 0.017853, 0.028544, 0.029918, 0.029984, 0.027279499999999998, 0.0261925, 0.030186499999999998, 0.0281415)
  var ADAll: List[Double] = Nil
  var ADEvalAll: List[Double] = Nil
  var SDAll: List[Double] = Nil
  var SDEvalAll: List[Double] = Nil

  var x = Param("x")


  var x_0 = Param("x_0")
    //[8, 128, 212, 318,418,518,636,736,836,936]
  var vectorVar8 = VectorVar(x_0,8)
  var vectorVar128 = VectorVar(x_0,128)
  var vectorVar212 = VectorVar(x_0,212)
  var vectorVar318 = VectorVar(x_0,318)
  var vectorVar418 = VectorVar(x_0,418)
  var vectorVar518 = VectorVar(x_0,518)
  var vectorVar636 = VectorVar(x_0,636)
  var vectorVar736 = VectorVar(x_0,736)
  var vectorVar836 = VectorVar(x_0,836)
  var vectorVar936 = VectorVar(x_0,936)
var list_expr_var = List(vectorVar8,vectorVar128, vectorVar212, vectorVar318,vectorVar418,vectorVar518,vectorVar636,vectorVar736,vectorVar836,vectorVar936)//vectorVar304, vectorVar404, vectorVar504, vectorVar608,vectorVar708,vectorVar808)//,vectorVar908,vectorVar1008,vectorVar1108)//, vectorVar1216)


  var  lenList: List[Int] = List()

  for(exp <- list_expr_var){
    lenList = lenList :+ exp.len
    println("ARRAY LENGTH "+ exp.len + "*******************************************")
    var arrAD: List[Long] = List()
    for (a <- 0 to 19) {
      val t0 = System.nanoTime()
      AutomaticDifferentiate.autodifferentiate(exp+exp, exp)
      val t1 = System.nanoTime()
      arrAD = arrAD:+(t1-t0)
    }

    var AD = AutomaticDifferentiate.autodifferentiate(exp+exp, exp)
    //var ADeval = DoubleEvaluator.eval(AD)
    var arrADEval: List[Long] = List()
    for (a <- 0 to 19) {
      val t0 = System.nanoTime()
      DoubleEvaluator.eval(AD)
      val t1 = System.nanoTime()
      arrADEval = arrADEval:+(t1-t0)
    }

    var sortedADEval = arrADEval.sorted
    var sortedAD = arrAD.sorted

    var resAD =   ((sortedAD(9)+sortedAD(10))*0.000001)/2
    ADAll = ADAll :+resAD

    var resADEval =   ((sortedADEval(9)+sortedADEval(10))*0.000001)/2
    ADEvalAll = ADEvalAll  :+ resADEval

    //      for(x<- sortedSD){
    println( "AD time:" + resAD+ "ms")
    //      }

    println("***********************************************")

    //      for(x<- sortedSDEval){
   // println( "AD eval time:" + resADEval + "ms")
    println()
  }



  println("len: "+lenList)
  println("ADAll: "+ADAll)
  println("ADEvalAll: "+ADEvalAll)
//  println("SDAll: "+SDAll)
//  println("SDEvalAll: "+SDEvalAll)

}
