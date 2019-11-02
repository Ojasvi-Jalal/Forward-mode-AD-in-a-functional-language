package test

import eval.Evaluator
import intermediateRep.DoubleLiteral
import typeCheck.TypeChecker

object Test1 extends App{
    val var1 = DoubleLiteral(3)
    val var2 = DoubleLiteral(4)
    val sum  =  var1 + var2 //ExprFunctions.+(var1,var2)
    val product = var1 * var2
    val division = var1 / var2
    val power = var1 ^ var2
    //println(s"sum of $var1 and $var2 = $sum")
    println("var1 = "+ Evaluator.eval(var1))
    println("var2 = "+ Evaluator.eval(var2))
    println("sum = "+Evaluator.eval(sum))
    println("product = "+Evaluator.eval(product))
    println("division = "+Evaluator.eval(division))
    println("power = "+Evaluator.eval(power))
    println(TypeChecker.typeCheck(var1))
    println(TypeChecker.typeCheck(var2))
    println(TypeChecker.typeCheck(sum))
    println(TypeChecker.typeCheck(product))


}
