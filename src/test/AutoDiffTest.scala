package test

import automaticDifferentiation.{AutomaticDifferentiate, AutomaticDifferentiateExpr}
import differentiate.Differentiate
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._
import test.DiffTest.{x, x_1, x_vector, y}

object AutoDiffTest extends App{


  var x = Param("x")
  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var x_3 = Param("x_3")
  var x_vector = Vector(List(x_1, x_2, x_3), x.t)

//  var exp = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2, x_1, x_0, x_0, x_0, x_0,
//                x_1, x_1, x_0, x_2, x_2, x_1, x_2, x_2, x_0, x_2, x_0, x_1, x_0,
//                x_1, x_1, x_2, x_0, x_0, x_1, x_0, x_0, x_0, x_2, x_0, x_2, x_2,
//                x_1, x_1, x_1, x_1, x_1, x_1, x_0, x_2, x_1, x_2, x_0, x_2, x_0,
//                x_1, x_0, x_1, x_2, x_0, x_1, x_1, x_2, x_0, x_0, x_0, x_2, x_2,
//                x_2, x_1, x_2, x_1, x_0, x_1, x_2, x_1, x_2, x_0, x_0, x_0, x_1,
//                x_2, x_2, x_1, x_0, x_2, x_1, x_2, x_1, x_0, x_1, x_2, x_2, x_1,
//                x_2, x_0, x_0, x_2, x_1, x_1, x_0, x_2, x_1, x_2, x_2, x_0, x_2,
//                x_1, x_2, x_1, x_0, x_0, x_1, x_2, x_0, x_2, x_1, x_2, x_2, x_2,
//                x_2, x_2, x_1, x_0, x_0, x_2, x_1, x_2, x_1, x_0, x_0, x_2, x_2,
//                x_2, x_0, x_0, x_1, x_2, x_2, x_2, x_0, x_1, x_2, x_0, x_1, x_1,
//                x_1, x_1, x_2, x_2, x_2, x_0, x_0, x_2, x_1, x_2, x_0, x_1, x_1,
//                x_2, x_0, x_2, x_1, x_2, x_1, x_2, x_2, x_2, x_0, x_1, x_2, x_2,
//                x_1, x_2, x_2, x_0, x_2, x_0, x_1, x_0, x_0, x_0, x_2, x_2, x_2,
//                x_2, x_1, x_2, x_2, x_0, x_2, x_1, x_1, x_0, x_2, x_2, x_0, x_2,
//                x_0, x_1, x_1, x_1, x_2, x_1, x_1, x_1, x_2, x_0, x_2, x_0, x_1,
//                x_0, x_0, x_2, x_2, x_2, x_2, x_0, x_1, x_2, x_2, x_0, x_0, x_1,
//                x_1, x_2, x_1, x_2, x_0, x_2, x_1, x_2, x_2, x_0, x_2, x_0, x_0,
//                x_1, x_1, x_1, x_1, x_2, x_0, x_0, x_2, x_1, x_1, x_2, x_2, x_0,
//                x_2, x_0, x_2, x_2, x_2, x_1, x_0, x_2, x_0, x_2, x_2, x_1, x_0,
//                x_2, x_0, x_2, x_0, x_1, x_1, x_2, x_2, x_1, x_2, x_2, x_2, x_1
//            )

  var y = Param("y")
  var i = Param("i")

  AutomaticDifferentiate.autodifferentiate(x*y, x)
  var z = Param("z")
  var y_vector = DoubleEvaluator.eval(Map(x, (x * x), x_vector))
  var vectorVar = VectorVar(x,100)
  var vectorVarMax = AutomaticDifferentiate.autodifferentiate(MaxVar(vectorVar), vectorVar)
  print(DoubleEvaluator.eval(vectorVarMax))
  //Map(i, If_Else(GreaterThan(VectorVarAccess(vectorVar,i),Drop(vectorVar,i)),IntLiteral(1) , IntLiteral(0)), Sequence((0 to vectorVar.len).toList))

 // println("differentiate_param_1 = "+ AutomaticDifferentiate.autodifferentiate(vector_expr, x_0)) //0
//  var max = DoubleEvaluator.eval(Max(x, y))
//  var max2 = DoubleEvaluator.eval(Max(x*x, y*y))
//
//  println("Max(x, y) wrt x = " + AutomaticDifferentiate.autodifferentiate(max, x))
//  println("Max(x*x, y*y) wrt x = " + Evaluator.printString(AutomaticDifferentiate.autodifferentiate(max2, x)))
//  var maxWrtVector = DoubleEvaluator.eval(Max(x_1, y))
//  println("Max(x, y) wrt x_vector = " + AutomaticDifferentiate.autodifferentiate(maxWrtVector, x_vector))
//
//  var maxVector = (DoubleEvaluator.eval(Fold(GreaterThan(x,y), x_vector.list.head, x_vector )))
//  println("Max([x]) wrt x_vector = " + AutomaticDifferentiate.autodifferentiate(maxVector, x_vector))
//
//  var dot = DoubleEvaluator.eval(DotProduct(x_vector, x_vector))
//  var additionVectors = DoubleEvaluator.eval(x_vector + x_vector)
//  var productVectorScalar = DoubleEvaluator.eval(x_vector * x_1)
//
//  var m = AutomaticDifferentiate.autodifferentiate(y_vector, x_vector)
//
//  println("dot = "+ Evaluator.printString(dot))
//  println("differentiate_vector_Y_wrt_vector_x = "+m) //List(List(((1.0 * x_1) + (1.0 * x_1)), ((0.0 * x_1) + (0.0 * x_1)), ((0.0 * x_1) + (0.0 * x_1))), List(((0.0 * x_2) + (0.0 * x_2)), ((1.0 * x_2) + (1.0 * x_2)), ((0.0 * x_2) + (0.0 * x_2))), List(((0.0 * x_3) + (0.0 * x_3)), ((0.0 * x_3) + (0.0 * x_3)), ((1.0 * x_3) + (1.0 * x_3))))
//  println("differentiate_vector_scalar_multiplication ="+ AutomaticDifferentiate.autodifferentiate(productVectorScalar, x_1)) // List(((1.0 * x_1) + (1.0 * x_1)), ((1.0 * x_2) + (0.0 * x_1)), ((1.0 * x_3) + (0.0 * x_1)))
//  println("differentiate_vector_dot_product = "+ AutomaticDifferentiate.autodifferentiate(dot, x_vector)) //List(((((0.0 * x_2) + (0.0 * x_2)) + (0.0 + ((0.0 * x_3) + (0.0 * x_3)))) + ((1.0 * x_1) + (1.0 * x_1))), ((((1.0 * x_2) + (1.0 * x_2)) + (0.0 + ((0.0 * x_3) + (0.0 * x_3)))) + ((0.0 * x_1) + (0.0 * x_1))), ((((0.0 * x_2) + (0.0 * x_2)) + (0.0 + ((1.0 * x_3) + (1.0 * x_3)))) + ((0.0 * x_1) + (0.0 * x_1))))
//  println("differentiate_vector_addition = "+ AutomaticDifferentiate.autodifferentiate(additionVectors, x_vector)) //List(List(2.0, 0.0, 0.0), List(0.0, 2.0, 0.0), List(0.0, 0.0, 2.0))
//  println("differentiate_param_1 = "+ AutomaticDifferentiate.autodifferentiate(y, x)) //0
//  println("differentiate_param_0 = "+ AutomaticDifferentiate.autodifferentiate(x, x)) //1
//  println("differentiate_param_1 = "+ AutomaticDifferentiate.autodifferentiate(y, x)) //0
//  println("differentiate_sum_0 = "+ AutomaticDifferentiate.autodifferentiate(x+y, x)) // 1
//  println("differentiate_sum_1 = "+ AutomaticDifferentiate.autodifferentiate(x+y+z, x)) // 1
//  println("differentiate_sum_2 = "+ AutomaticDifferentiate.autodifferentiate(x+x+x+x+x+x+x, x)) //7
//  println("differentiate_Product_1 = "+ AutomaticDifferentiate.autodifferentiate(x*x, x)) // ((1.0 * x) + (1.0 * x))
//  println("differentiate_Product_2 = "+ AutomaticDifferentiate.autodifferentiate(x*(x+x), x)) //((2.0 * x) + ((x + x) * 1.0))
//  println("differentiate_Powers_1 = "+ AutomaticDifferentiate.autodifferentiate(x^DoubleLiteral(2), x)) // ((x ^ 1.0) * 2.0)
//  println("differentiate_Quotient_Constants= "+ AutomaticDifferentiate.autodifferentiate(DoubleLiteral(3)^DoubleLiteral(3), x))
//  println("differentiate_Quotient_Variables_Constant= "+ AutomaticDifferentiate.autodifferentiate(x^DoubleLiteral(3), x))
//  println("differentiate_Sum_of_Powers = "+ AutomaticDifferentiate.autodifferentiate((x^DoubleLiteral(2)) + (y^DoubleLiteral(2)), x)) //investigate

}
