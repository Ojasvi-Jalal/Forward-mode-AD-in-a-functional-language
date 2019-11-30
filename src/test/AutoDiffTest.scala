package test

import automaticDifferentiation.AutomaticDifferentiate
import intermediateRep.{DoubleLiteral, Param}

object AutoDiffTest extends App{
  var x = Param("x")
  var y = Param("y")
  println("differentiate_x = "+ AutomaticDifferentiate.differentiate(x+x, y)) //investigate
//  println("differentiate_Constant = "+ Differentiate.differentiate(DoubleLiteral(9), x))
//  println("differentiate_Product = "+ Differentiate.differentiate(DoubleLiteral(3)*x*x*DoubleLiteral(3), x))
//  println("differentiate_Quotient_Constants= "+ Differentiate.differentiate(DoubleLiteral(3)^DoubleLiteral(3), x))
//  println("differentiate_Quotient_Only_Variables= "+ Differentiate.differentiate(x^x, x)) //broken here: investigate
//  println("differentiate_Quotient_Variables_Constant= "+ Differentiate.differentiate(x^DoubleLiteral(3), x))
}