package test

import automaticDifferentiation.AutomaticDifferentiateExpr
import differentiate._
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._
import test.Test1._
object DiffTest extends App{
  var x = Param("x")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var x_3 = Param("x_3")
  var y = Param("y")

  var z = Param("z")
  var x_vector = Vector(List(x_1, x_2, x_3), x.t)
  var y_vector = DoubleEvaluator.eval(Map(x, (x * x), x_vector))
  var max = Max(x, y)
  var max2 = Max(x*x, y*y)

  println("Max(x, y) wrt x = " + Differentiate.differentiate(max, x))
  println("Max(x*x, y*y) wrt x = " + Evaluator.printString(Differentiate.differentiate(max2, x)))
  var maxWrtVector = Max(x_1, y)
  println("Max(x, y) wrt x_vector = " + Differentiate.differentiate(maxWrtVector, x_vector))

  var maxVector = (DoubleEvaluator.eval(Fold(GreaterThan(x,y), x_vector.list.head, x_vector )))
  println("Max([x]) wrt x_vector = " + Differentiate.differentiate(maxVector, x_vector))

  var dot = DoubleEvaluator.eval(DotProduct(x_vector, x_vector))
  var additionVectors = DoubleEvaluator.eval(x_vector + x_vector)
  var productVectors = DoubleEvaluator.eval(x_vector * x_1)
  println(Evaluator.printString(dot))
  println(Evaluator.printString(additionVectors))
  var diffDot = DifferentiateExpr.differentiate(dot, x_vector)

  println("differentiate_x = "+ DifferentiateExpr.differentiate(y_vector, x_vector))
  println("differentiate_x = "+ DifferentiateExpr.differentiate(Lambda(x, x*x), x))


  //var m = DifferentiateExpr.differentiate(Map(x, (x), x_vector), x_vector)
  println((Evaluator.printString(diffDot))) //investigate
  println((Evaluator.printString(DifferentiateExpr.differentiate(additionVectors, x_vector))))

  println((Evaluator.printString(DifferentiateExpr.differentiate(productVectors, x_1))))
  println("differentiate_Constant = "+ Differentiate.differentiate(DoubleLiteral(9), x))
  println("differentiate_Product = "+ Differentiate.differentiate(DoubleLiteral(3)*x*x*DoubleLiteral(3), x))
  println("differentiate_Quotient_Constants= "+ Differentiate.differentiate(DoubleLiteral(3)^DoubleLiteral(3), x))
  println("differentiate_Quotient_Variables_Constant= "+ Differentiate.differentiate(x^DoubleLiteral(3), x))
}
