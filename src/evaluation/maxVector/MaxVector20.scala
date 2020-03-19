package evaluation.maxVector

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Array, Fold, GreaterThan, Param}


object MaxVector20 extends App{

//dim: 20
  
//auto diff: 13.6469

  //7.401724005s
  //12.317221634s
  //13.072208931s
  //13.097394735s
  //13.279010375s
  //14.0148
  //14.0505788s
  //14.808587612s
  //14.724667544s
  //15.7782

  //diff:
  //0.136102223s
  //0.017797989s
  //0.019426267s
  //0.042599074s
  //0.042360167s
  //0.044283633s
  //0.044435837s
  //0.057412133s
  //0.117078967s
  //0.316564808s

  //evalution: 0.043298765
  //0.086278576s
  //0.081492552s
  //0.05827215s
  //0.044064774s
  //0.043505955s
  //0.043091575s
  //0.039476655s
  //0.034996491s
  //0.034478621s
  //0.033347594s



  var x = Param("x")
  var y = Param("y")

  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  //  var x_3 = Param("x_3")
  //  var x_vector = Array(List(x_1, x_2, x_3), x.t)

  var exp = List(x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2, x_1, x_0,x_2, x_2, x_0, x_0, x_1, x_0, x_2, x_2, x_1, x_0, x_2, x_2, x_0, x_0, x_1)

  var vector = Array(exp, x.t)
  //var maxVector = (DoubleEvaluator.eval(Fold(GreaterThan(x,y), vector.list.head, vector )))
  val t0 = System.nanoTime()
  //AutomaticDifferentiate.autodifferentiate(maxVector, vector) // call-by-name
  //DifferentiateExpr.differentiate(maxVector, vector)
  (DoubleEvaluator.eval(Fold(GreaterThan(x,y), vector.list.head, vector )))
  val t1 = System.nanoTime()
  println("Elapsed time: " + (t1 - t0)/(1e+9) + "s")
}
