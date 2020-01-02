package test

import automaticDifferentiation.AutomaticDifferentiate
import intermediateRep.{DoubleLiteral, Param}

object AutoDiffTest extends App{
  var x = Param("x")
  var y = Param("y")
  println("differentiate_sum_0 = "+ AutomaticDifferentiate.autodifferentiate(x+y, x)) //investigate
  println("differentiate_Product_0 = "+ AutomaticDifferentiate.autodifferentiate(x*y, x))
  println("differentiate_sum_1 = "+ AutomaticDifferentiate.autodifferentiate(x+x, x)) //investigate
  println("differentiate_Product_1 = "+ AutomaticDifferentiate.autodifferentiate(x*y, x))
  //println("differentiate_Sum_of_Powers = "+ AutomaticDifferentiate.autodifferentiate((x^DoubleLiteral(2)) + (y^DoubleLiteral(2)), x))
//  println("differentiate_Quotient_Constants= "+ Differentiate.differentiate(DoubleLiteral(3)^DoubleLiteral(3), x))
//  println("differentiate_Quotient_Only_Variables= "+ Differentiate.differentiate(x^x, x)) //broken here: investigate
//  println("differentiate_Quotient_Variables_Constant= "+ Differentiate.differentiate(x^DoubleLiteral(3), x))
}
