package test

import automaticDifferentiation.AutomaticDifferentiateExpr
import differentiate._
import intermediateRep._
import test.AutoDiffTest.{array, x}
object DiffTest extends App{
  var x = Param("x")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var x_3 = Param("x_3")
  var y = Param("y")

  var z = Param("z")
  var x_vector = Array(List(x_1, x_2, x_3), x.t)
  var y_vector = Map(x, (x * x), x_vector)

 // println("differentiate_x = "+ Differentiate.differentiate(y_vector, x_vector))
  //println("differentiate_x = "+ Differentiate.differentiate(Lambda(x, x*x), x))

  var m = DifferentiateExpr.differentiate(Map(x, (x), x_vector), x_vector)
  println(m) //investigate
//println("differentiate_Constant = "+ Differentiate.differentiate(DoubleLiteral(9), x))
//println("differentiate_Product = "+ Differentiate.differentiate(DoubleLiteral(3)*x*x*DoubleLiteral(3), x))
//println("differentiate_Quotient_Constants= "+ Differentiate.differentiate(DoubleLiteral(3)^DoubleLiteral(3), x))
  //println("differentiate_Quotient_Only_Variables= "+ Differentiate.differentiate(x^x, x)) //broken here: investigate
  //println("differentiate_Quotient_Variables_Constant= "+ Differentiate.differentiate(x^DoubleLiteral(3), x))
}
