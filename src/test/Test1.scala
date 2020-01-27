package test

import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._
import typeCheck.TypeChecker

object Test1 extends App{
    val var1 = DoubleLiteral(3)
    val var2 = DoubleLiteral(2)
    var x = Param("x")
    var y = Param("y")
    val division = x / x
    val product = x * y
    var body = x + var1
    val sum  =  var1 + var2
    val power = (x ^ var2) + (y ^ var2)
    var vector= Vector(List(var1, var2), var1.t)

    Let(x,body,y)

    println(Map(List(var1, var2)))
    println("var = "+Evaluator.eval(x))
    println("lambda = "+ DoubleEvaluator.eval(Let(x,body,y)))
    println("var1 = "+ Evaluator.eval(var1))
    println("var2 = "+ Evaluator.eval(var2))
    //println("sum = "+Evaluator.eval(var1 * (var1 + x)))
    println("product1 = "+Evaluator.eval(product))
    println("product2 = "+Evaluator.eval(var1 * var2))
    println("division = "+Evaluator.eval(division))
    println("power = "+Evaluator.eval(power))
//    println(TypeChecker.typeCheck(var1))
//    println(TypeChecker.typeCheck(var2))
//    println(TypeChecker.typeCheck(sum))
//    println(TypeChecker.typeCheck(product))
//    println(TypeChecker.typeCheck(division))
//    println(TypeChecker.typeCheck(power))


}
