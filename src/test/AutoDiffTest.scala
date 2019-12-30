package test

import automaticDifferentiation.AutomaticDifferentiate
import intermediateRep.{DoubleLiteral, Param}

object AutoDiffTest extends App{
  var x = Param("x")
  var y = Param("y")
  println("differentiate_x = "+ AutomaticDifferentiate.autodifferentiate(x+x, x)) //investigate
  println("differentiate_Product = "+ AutomaticDifferentiate.autodifferentiate(x*x, x))
  println("differentiate_Product = "+ AutomaticDifferentiate.autodifferentiate(x/y, x))
//  println("differentiate_Quotient_Constants= "+ Differentiate.differentiate(DoubleLiteral(3)^DoubleLiteral(3), x))
//  println("differentiate_Quotient_Only_Variables= "+ Differentiate.differentiate(x^x, x)) //broken here: investigate
//  println("differentiate_Quotient_Variables_Constant= "+ Differentiate.differentiate(x^DoubleLiteral(3), x))
}
