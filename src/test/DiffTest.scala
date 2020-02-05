package test

import automaticDifferentiation.AutomaticDifferentiateExpr
import differentiate._
import intermediateRep._
import test.AutoDiffTest.{array, x}
object DiffTest extends App{
  var x = Param("x")
  var y = Param("y")

  var z = Param("z")
  var array = Array(List(x, y, x), x.t)
  println("differentiate__x = "+ Differentiate.differentiate(Lambda(x, x*x), x))

  var m = DifferentiateExpr.differentiate(Map(x, (x * x), array), x)
  println(m) //investigate
//println("differentiate_Constant = "+ Differentiate.differentiate(DoubleLiteral(9), x))
//println("differentiate_Product = "+ Differentiate.differentiate(DoubleLiteral(3)*x*x*DoubleLiteral(3), x))
//println("differentiate_Quotient_Constants= "+ Differentiate.differentiate(DoubleLiteral(3)^DoubleLiteral(3), x))
  //println("differentiate_Quotient_Only_Variables= "+ Differentiate.differentiate(x^x, x)) //broken here: investigate
  //println("differentiate_Quotient_Variables_Constant= "+ Differentiate.differentiate(x^DoubleLiteral(3), x))
}
