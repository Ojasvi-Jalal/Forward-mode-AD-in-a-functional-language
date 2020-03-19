package evaluation.maxVector

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Array, Fold, GreaterThan, Param}


object MaxVector30 extends App{

//dim: 30
  
//auto-diff

//222.297788274s
//211.291176719s
//305.079881519s

//diff: 0.0262019405
  //0.021675836s
  //0.022492171s
  //0.024236179s
  //0.025023851s
  //0.025803993s
  //0.026599888s
  //0.027821271s
  //0.02856754s
  //0.033344484s
  //0.230236625s

  //evaluation: 0.0401921235
  //0.027412048s
  //0.027688295s
  //0.032378831s
  //0.039469512s
  //0.039918717s
  //0.04046553s
  //0.040697493s
  //0.041389466s
  //0.043107169s
  //0.048655651s

  
  var x = Param("x")
  var y = Param("y")

  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  //  var x_3 = Param("x_3")
  //  var x_vector = Array(List(x_1, x_2, x_3), x.t)

  var exp = List(x_2, x_2, x_0, x_0, x_1,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2, x_1, x_0,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2, x_1, x_0, x_2, x_2, x_0, x_0, x_1)

  var vector = Array(exp, x.t)
  //var maxVector = (DoubleEvaluator.eval(Fold(GreaterThan(x,y), vector.list.head, vector )))
  val t0 = System.nanoTime()
  //AutomaticDifferentiate.autodifferentiate(maxVector, vector) // call-by-name
  //DifferentiateExpr.differentiate(maxVector, vector)

  (DoubleEvaluator.eval(Fold(GreaterThan(x,y), vector.list.head, vector )))
  val t1 = System.nanoTime()
  println("Elapsed time: " + (t1 - t0)/(1e+9) + "s")
}
