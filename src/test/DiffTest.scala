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
  println("differentiate_Product = "+ Differentiate.differentiate(DoubleLiteral(3)*x*x*DoubleLiteral(3), x))
  println("differentiate_Quotient = "+ Differentiate.differentiate(x^DoubleLiteral(2), x))
}
