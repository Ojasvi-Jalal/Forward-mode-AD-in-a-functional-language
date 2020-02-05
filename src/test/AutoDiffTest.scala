package test

import automaticDifferentiation.{AutomaticDifferentiate, AutomaticDifferentiateExpr}
import intermediateRep._

object AutoDiffTest extends App{
  var x = Param("x")
  var y = Param("y")
  var z = Param("z")
  var array = Array(List(x, x, x), x.t)
  var body = x * x


  var m = Map(x, AutomaticDifferentiateExpr.autoDifferentiate(x * x, x), array)

  //println(m)
  println("differentiate_param_0 = "+ AutomaticDifferentiate.autodifferentiate(x, x))
  println("differentiate_param_1 = "+ AutomaticDifferentiate.autodifferentiate(y, x))
  println("differentiate_sum_0 = "+ AutomaticDifferentiate.autodifferentiate(x+y, x))
  println("differentiate_sum_1 = "+ AutomaticDifferentiate.autodifferentiate(x+y+z, x))
  println("differentiate_sum_2 = "+ AutomaticDifferentiate.autodifferentiate(x+x+x+x+x+x+x, x))
  println("differentiate_Product_1 = "+ AutomaticDifferentiate.autodifferentiate(x*x, x))
  println("differentiate_Product_2 = "+ AutomaticDifferentiate.autodifferentiate(x*(x+x), x))
  println("differentiate_Powers_1 = "+ AutomaticDifferentiate.autodifferentiate(x^DoubleLiteral(2), x))
  println("differentiate_Sum_of_Powers = "+ AutomaticDifferentiate.autodifferentiate((x^DoubleLiteral(2)) + (y^DoubleLiteral(2)), x))
  println("differentiate_Quotient_Constants= "+ AutomaticDifferentiate.autodifferentiate(DoubleLiteral(3)^DoubleLiteral(3), x))
  println("differentiate_Quotient_Variables_Constant= "+ AutomaticDifferentiate.autodifferentiate(x^DoubleLiteral(3), x))
}
