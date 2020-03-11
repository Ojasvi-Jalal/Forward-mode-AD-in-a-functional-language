package test

import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._

object Test1 extends App {
    val var1 = DoubleLiteral(3)
    val var2 = DoubleLiteral(2)
    val var3 = DoubleLiteral(5)
    var x = Param("x")
    var y = Param("y")
    val division = x * x
    println(DoubleEvaluator.eval(division))

    val product = var1 * (var2 + var3)
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
    val product2 = x * y
    var x_vector = Array(List(x_1, x_2, x_3), x.t)
    var dot = DoubleEvaluator.eval(DotProduct(x_vector, x_vector))
    println(Evaluator.eval(Max(var1, var2)))
    println(Evaluator.eval(Max(x, var2)))
    println(DoubleEvaluator.eval(Fold(GreaterThan(x,y), x_vector.list.head, x_vector )))
    println(DoubleEvaluator.eval(Fold(GreaterThan(x,y), array.list.head, array )))


    println(Evaluator.printString(dot))
    var additionOfTwoVectors =  DoubleEvaluator.eval(x_vector + x_vector)
    var addVectorVar =  DoubleEvaluator.eval(x_vector + var2)
    var addVarVector =  DoubleEvaluator.eval(var1 + x_vector)
    println(Evaluator.printString(additionOfTwoVectors))
    println(Evaluator.printString(addVectorVar))
    println(Evaluator.printString(DoubleEvaluator.eval(x_vector * var2)))
    println(DoubleEvaluator.eval(array * var2))
    println(Evaluator.printString(addVarVector))
    println(Evaluator.printString(DoubleEvaluator.eval(Map(x, product, array))))
    println(DoubleEvaluator.eval(Pair(var2, var1)))
    println(DoubleEvaluator.eval(Zip(x_vector, x_1)))
    println(DoubleEvaluator.eval(Zip(x_1, x_vector)))
    println(DoubleEvaluator.eval(Zip(x_vector, x_vector)))
    println(Evaluator.printString(DoubleEvaluator.eval(Fold(x*x, DoubleLiteral(1), array))))
    //println(Reduce.timesTwo(array))
    println("var = "+Evaluator.eval(Evaluator.printString(nested)))
    println("lambda = "+ DoubleEvaluator.eval(Let(x,body,y)))
    println("var1 = "+ Evaluator.eval(var1))
    println("var2 = "+ Evaluator.eval(var2))
    println("product1 = "+Evaluator.printString(product))
    println("product2 = "+Evaluator.printString(Evaluator.eval(var1 * var2)))
    println("division = "+Evaluator.printString(Evaluator.eval(division)))
    println("power = "+Evaluator.printString(Evaluator.eval(power)))
}
