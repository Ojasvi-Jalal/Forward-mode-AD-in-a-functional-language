package test

import automaticDifferentiation.{AutomaticDifferentiate, AutomaticDifferentiateExpr}
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._

object AutoDiffTest extends App{
  var x = Param("x")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var x_3 = Param("x_3")
  var y = Param("y")

  var z = Param("z")
  var x_vector = Array(List(x_1, x_2, x_3), x.t)
  var y_vector = DoubleEvaluator.eval(Map(x, (x * x), x_vector))

  var dot = DoubleEvaluator.eval(DotProduct(x_vector, x_vector))
  var additionVectors = DoubleEvaluator.eval(x_vector + x_vector)
  var productVectorScalar = DoubleEvaluator.eval(x_vector * x_1)

  //var m = AutomaticDifferentiate.autodifferentiate(y_vector, x_vector)

  println(Evaluator.printString(productVectorScalar))

  println("differentiate_vector_scalar_multiplication ="+ AutomaticDifferentiate.autodifferentiate(productVectorScalar, x_1))
  println("differentiate_vector_product = "+ AutomaticDifferentiate.autodifferentiate(dot, x_vector))
  println("differentiate_vector_addition = "+ AutomaticDifferentiate.autodifferentiate(additionVectors, x_vector))
  println("differentiate_param_1 = "+ AutomaticDifferentiate.autodifferentiate(y, x))
//  println("differentiate_param_0 = "+ AutomaticDifferentiate.autodifferentiate(x, x))
//  println("differentiate_param_1 = "+ AutomaticDifferentiate.autodifferentiate(y, x))
//  println("differentiate_sum_0 = "+ AutomaticDifferentiate.autodifferentiate(x+y, x))
//  println("differentiate_sum_1 = "+ AutomaticDifferentiate.autodifferentiate(x+y+z, x))
//  println("differentiate_sum_2 = "+ AutomaticDifferentiate.autodifferentiate(x+x+x+x+x+x+x, x))
//  println("differentiate_Product_1 = "+ AutomaticDifferentiate.autodifferentiate(x*x, x))
//  println("differentiate_Product_2 = "+ AutomaticDifferentiate.autodifferentiate(x*(x+x), x))
//  println("differentiate_Powers_1 = "+ AutomaticDifferentiate.autodifferentiate(x^DoubleLiteral(2), x))
//  println("differentiate_Sum_of_Powers = "+ AutomaticDifferentiate.autodifferentiate((x^DoubleLiteral(2)) + (y^DoubleLiteral(2)), x))
//  println("differentiate_Quotient_Constants= "+ AutomaticDifferentiate.autodifferentiate(DoubleLiteral(3)^DoubleLiteral(3), x))
//  println("differentiate_Quotient_Variables_Constant= "+ AutomaticDifferentiate.autodifferentiate(x^DoubleLiteral(3), x))
}
