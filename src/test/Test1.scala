package test

import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._

object Test1 extends App {
    val var1 = DoubleLiteral(3)
    val var2 = DoubleLiteral(2)
    val var3 = DoubleLiteral(5)
    var x = Param("x")
    var y = Param("y")
    val division = x / x
    val product = x * y
    var body = x + var1
    val sum  = var1 + var2
    val power = (x ^ var2) + (y ^ var2)
    var array = Array(List(var1, var2, var3), var1.t)
    Let(x,body,y)
    println(Map(array))
    println("var = "+Evaluator.eval(x))
    println("lambda = "+ DoubleEvaluator.eval(Let(x,body,y)))
    println("var1 = "+ Evaluator.eval(var1))
    println("var2 = "+ Evaluator.eval(var2))
    println("product1 = "+Evaluator.eval(product))
    println("product2 = "+Evaluator.eval(var1 * var2))
    println("division = "+Evaluator.eval(division))
    println("power = "+Evaluator.eval(power))
}
