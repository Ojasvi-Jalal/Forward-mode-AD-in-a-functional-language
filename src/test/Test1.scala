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
    val product = x * x
    var body = x + var1
    val sum  = var1 + var2
    val power = (x ^ var2) + (y ^ var2)
    val nested = product + var2
    var array = Array(List(var1, var2, var3), var1.t)
    Let(x,body,y)
    var x_1 = Param("x_1")
    var x_2 = Param("x_2")
    var x_3 = Param("x_3")

    var z = Param("z")
    var x_vector = Array(List(x_1, x_2, x_3), x.t)

    println(DoubleEvaluator.eval(Map(x, product, array)))
    println(DoubleEvaluator.eval(Pair(var2, var1)))
    println(DoubleEvaluator.eval(Zip(x_vector, x_1)))
    println(DoubleEvaluator.eval(Zip(x_1, x_vector)))
    println(DoubleEvaluator.eval(Zip(x_vector, x_vector)))
    //println(DoubleEvaluator.eval(Fold.foldLeft(List(var1, var2, var3), var2)))
    //println(Reduce.timesTwo(array))
    println("var = "+Evaluator.eval(nested))
    println("lambda = "+ DoubleEvaluator.eval(Let(x,body,y)))
    println("var1 = "+ Evaluator.eval(var1))
    println("var2 = "+ Evaluator.eval(var2))
    println("product1 = "+Evaluator.eval(product))
    println("product2 = "+Evaluator.eval(var1 * var2))
    println("division = "+Evaluator.eval(division))
    println("power = "+Evaluator.eval(power))
}
