package evaluation.maxVector

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Array, Fold, GreaterThan, Param}


object MaxVector25 extends App{

//dim: 25
  
//auto-diff

//8.007168136
//9.912286955s
//11.911243111
//12.770650005
//14.575255155
//16.761184192
//16.392452347
//19.571018908
//19.40179705
//20.153105645

//diff: 0.037135839
  //0.129348461s
  //0.102792089s
  //0.064678228s
  //0.048727232s
  //0.040480964s
  //0.033790714s
  //0.03155855s
  //0.026482702s
  //0.021858664s
  //0.017473807s

  //evaluation:

  //0.024680819s
  //0.030703224s
  // 0.031472677s
 // 0.039266053s
  //0.040805562s
  //0.043281398s
  //0.043487711s
  //0.04866358s
  ////0.049440277s
  //0.052247505s


  var x = Param("x")
  var y = Param("y")

  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  //  var x_3 = Param("x_3")
  //  var x_vector = Array(List(x_1, x_2, x_3), x.t)

  var exp = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2, x_1, x_0,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2, x_1, x_0, x_2, x_2, x_0, x_0, x_1)

  var vector = Array(exp, x.t)
 // var maxVector = (DoubleEvaluator.eval(Fold(GreaterThan(x,y), vector.list.head, vector )))
  val t0 = System.nanoTime()
  //AutomaticDifferentiate.autodifferentiate(maxVector, vector) // call-by-name
  (DoubleEvaluator.eval(Fold(GreaterThan(x,y), vector.list.head, vector )))
  val t1 = System.nanoTime()
  println("Elapsed time: " + (t1 - t0)/(1e+9) + "s")
}
