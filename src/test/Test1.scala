package test

import automaticDifferentiation.AutomaticDifferentiate
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._

object Test1 extends App {
  var x = Param("x")
  var y = Param("y")
  val var1 = DoubleLiteral(3)
  val var2 = DoubleLiteral(2)
  val var3 = DoubleLiteral(5)
  var array = Sequence((0 to 3).toList)
//  var access = DoubleEvaluator.eval(VectorAccess(array,0))
 // println(access)
 // println(DoubleEvaluator.eval(VectorAccess(array,0)))
  var vectorVar = VectorVar(x,3)
  var ad = AutomaticDifferentiate.autodifferentiate(MaxVar(vectorVar),vectorVar)
  var eval = DoubleEvaluator.eval(Let(vectorVar,array,ad))
  println(eval)
  var newVector  = DoubleEvaluator.eval(Drop(vectorVar, IntLiteral(100)))
 //println(newVector.asInstanceOf[VectorVar].len)
 //println(Sequence((1 to 100).toList))
  var i = Param("i")

//
//    val division = x * x
//    DoubleEvaluator.eval((x+y)*var2)
//    println(DoubleEvaluator.eval(division))
//
//    val product = var1 * (var2 + var3)
//    var body = x + var1
//    val sum  = var1 + var2
//    val power = (x ^ var2) + (y ^ var2)
//    val nested = product + var2

//    Let(x,body,y)
//    var x_1 = Param("x_1")
//    var x_2 = Param("x_2")
//    var x_3 = Param("x_3")
//    var z = Param("z")
//    val product2 = x * y
//    var x_vector = Vector(List(x_1, x_2, x_3), x.t)
//    var dot = DoubleEvaluator.eval(DotProduct(x_vector, x_vector))
//    println(Evaluator.eval(Max(var1, var2)))
//    println(Evaluator.eval(Max(x, var2)))
//    println(DoubleEvaluator.eval(Fold(GreaterThan(x,y), x_vector.list.head, x_vector )))
    //println(DoubleEvaluator.eval(Fold(GreaterThan(x,y), array.list.head, array )))
//
//    println(Evaluator.printString(dot))
//    var additionOfTwoVectors =  DoubleEvaluator.eval(x_vector + x_vector)
//    var addVectorVar =  DoubleEvaluator.eval(x_vector + var2)
//    var addVarVector =  DoubleEvaluator.eval(var1 + x_vector)
//    println(Evaluator.printString(additionOfTwoVectors))
//    println(Evaluator.printString(addVectorVar))
//    println(Evaluator.printString(DoubleEvaluator.eval(x_vector * var2)))
//    println(DoubleEvaluator.eval(array * var2))
//    println(Evaluator.printString(addVarVector))
//    println(DoubleEvaluator.eval(Pair(var2, var1)))
//    println(DoubleEvaluator.eval(Zip(x_vector, x_1)))
//    println(DoubleEvaluator.eval(Zip(x_1, x_vector)))
//    println(DoubleEvaluator.eval(Zip(x_vector, x_vector)))
//    println(Evaluator.printString(DoubleEvaluator.eval(Fold(x*x, DoubleLiteral(1), array))))
//    //println(Reduce.timesTwo(array))
//    println("var = "+Evaluator.eval(Evaluator.printString(nested)))
//    println("lambda = "+ DoubleEvaluator.eval(Let(x,body,y)))
//    println("var1 = "+ Evaluator.eval(var1))
//    println("var2 = "+ Evaluator.eval(var2))
//    println("product1 = "+Evaluator.printString(product))
//    println("product2 = "+Evaluator.printString(Evaluator.eval(var1 * var2)))
//    println("division = "+Evaluator.printString(Evaluator.eval(division)))
//    println("power = "+Evaluator.printString(Evaluator.eval(power)))
}
