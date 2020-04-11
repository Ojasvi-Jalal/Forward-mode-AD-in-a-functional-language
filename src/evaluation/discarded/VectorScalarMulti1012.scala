package evaluation.discarded

import automaticDifferentiation.AutomaticDifferentiate
import eval.DoubleEvaluator
import evaluation.ExprVectorScalar
import evaluation.discarded.VectorScalarMulti2024.{exp, x}
import intermediateRep.{Vector, Param}

object VectorScalarMulti1012 extends App{

  //1012

  //0.147482933s
  //0.134964282s
  //0.13168147s
  //0.129130194s
  //0.12760251s
  //0.123243281s
  //0.121442183s
  //0.120521442s
  //0.116729797s
  //0.11613755s


  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = DoubleEvaluator.eval((x_1 * x_2))

  var elemtype2 = DoubleEvaluator.eval(x_0 + (x_1 + x_2))
  var elemtype3 = DoubleEvaluator.eval(x_0 * (x_1 / x_2))

  var exp = List(elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype3, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype3,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype2, elemtype2, elemtype2,
    elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3,
  elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3)

  println("ARRAY LENGTH "+ exp.length + "*******************************************")
  var vector = DoubleEvaluator.eval(x * Vector(exp, x.t))
  ExprVectorScalar.eval(exp, true, true)
}
