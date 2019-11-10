package test

import differentiate.Differentiate
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{DoubleLiteral, Expr, Param}
import typeCheck.TypeChecker

object DiffTest extends App{
  var x = Param("x")
  var y = Param("y")
  println("differentiate_x = "+ Differentiate.differentiate(x, y)) //investigate
  println("differentiate_Constant = "+ Differentiate.differentiate(DoubleLiteral(9), x))
  println("differentiate_Product = "+ Differentiate.differentiate(DoubleLiteral(3)*x*DoubleLiteral(3), x))
  println("differentiate_Quotient = "+ Differentiate.differentiate(x^DoubleLiteral(2), x))
  //    println("var = "+x)
  //    println("var1 = "+ Evaluator.eval(var1))
  //    println("var2 = "+ Evaluator.eval(var2))
  //    println("sum = "+Evaluator.eval(sum))
  //    println("product = "+Evaluator.eval(product))
  //    println("division = "+Evaluator.eval(division))
  //    println("power = "+Evaluator.eval(power))
  //    println(TypeChecker.typeCheck(var1))
  //    println(TypeChecker.typeCheck(var2))
  //    println(TypeChecker.typeCheck(sum))
  //    println(TypeChecker.typeCheck(product))
  //    println(TypeChecker.typeCheck(division))
  //    println(TypeChecker.typeCheck(power))
}
