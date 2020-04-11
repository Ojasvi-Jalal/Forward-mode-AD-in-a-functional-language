package evaluation.maxVector

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Vector, Fold, GreaterThan, Param}


object MaxVector04 extends App{


//  ARRAY LENGTH 4*******************************************
  //  115927ns - 0.000115927 - 0.000125914
//    Eval:103359ns
//    Eval:107834ns
//    Eval:109810ns
//    Eval:111095ns
//    Eval:114492ns
//    Eval:117362ns
//    Eval:122016ns
//    Eval:128359ns
//    Eval:134066ns
//    Eval:225885ns
//    ***********************************************
  //  3398924.5ns - 0.0033989245
//    AD time:1500935ns
//    AD time:2628238ns
//    AD time:3010836ns
//    AD time:3027774ns
//    AD time:3357481ns
//    AD time:3440368ns
//    AD time:4966829ns
//    AD time:6717653ns
//    AD time:46410450ns
//    AD time:81513204ns
//    ***********************************************
  //  341589ns  - 0.000341589s
//    AD eval time:316741ns
//    AD eval time:323432ns
//    AD eval time:328209ns
//    AD eval time:333536ns
//    AD eval time:340086ns
//    AD eval time:343092ns
//    AD eval time:368480ns
//    AD eval time:377122ns
//    AD eval time:3308929ns
//    AD eval time:21188325ns
//    ***********************************************
//  ***********************************************
  //  27820.5ns -  2.78205e-5s
//    SD time:24042ns
//    SD time:24447ns
//    SD time:24458ns
//    SD time:24708ns
//    SD time:25550ns
//    SD time:30091ns
//    SD time:30389ns
//    SD time:40303ns
//    SD time:96454ns
//    SD time:732687ns
//    ***********************************************
  //  301136ns - 0.000301136s
//    SD eval time:286929ns
//    SD eval time:288328ns
//    SD eval time:294318ns
//    SD eval time:300085ns
//    SD eval time:300804ns
//    SD eval time:301468ns
//    SD eval time:305511ns
//    SD eval time:314963ns
//    SD eval time:334023ns
//    SD eval time:1621114ns




  var x = Param("x")
  var y = Param("y")

  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var exp2 = List(x_0, x_2)
  var exp6 = List(x_0, x_2, x_2, x_1,x_0, x_2)
  var exp10 = List(x_2, x_2, x_1,x_0, x_2,x_0, x_2, x_2, x_1,x_0)
  var exp12 = List(x_2,x_0, x_2, x_2, x_1,x_0, x_2,x_0, x_2, x_2, x_1,x_0)
  var exp14 = List(x_2,x_0, x_2,x_0, x_2, x_2, x_1,x_0, x_2,x_0, x_2, x_2, x_1,x_0)
  var exp18 = List(x_0, x_2,x_0, x_2,x_0,x_0, x_2,x_0, x_2,x_0, x_2, x_2, x_1,x_0, x_2,x_0, x_2, x_2)
  var exp20 = List( x_2, x_1,x_0, x_2,x_0, x_2,x_0,x_0, x_2,x_0, x_2,x_0, x_2, x_2, x_1,x_0, x_2,x_0,x_1,x_0)
  var exp22 = List(x_0, x_2, x_2, x_1,x_0, x_2,x_0, x_2,x_0,x_0, x_2,x_0, x_2,x_0, x_2, x_2, x_1,x_0, x_2,x_0, x_2, x_2)

  var exp4 = List(x_0, x_2, x_2, x_1)
  var exp8 = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2)
  var exp16 = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2)
  var exp24 = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2)
//  var exp32 = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2)
//  var exp40 = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2)
//  var exp48 = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2)
//  var exp56 = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2)
//  var exp64 = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2)
//  var exp72 = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2)
//  var exp100 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)

  var list_expr = List(exp2,exp4,exp6,exp8,exp10,exp12,exp14,exp16,exp18,exp20, exp22, exp24)
  var  lenList: List[Int] = List()
  for(a <- list_expr){
    lenList = lenList :+ a.length
    println("ARRAY LENGTH "+ a.length + "*******************************************")
    ExprMaxVector.eval(a, true, true)
  }
  println("len "+lenList)
}