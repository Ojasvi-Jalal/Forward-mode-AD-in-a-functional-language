package evaluation.maxVector

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Vector, Fold, GreaterThan, Param}


object MaxVector04 extends App{
  //calls ExprMaxVector
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
