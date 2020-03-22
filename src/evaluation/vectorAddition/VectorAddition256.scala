package evaluation.vectorAddition

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import evaluation.vectorAddition.VectorAddition500.exp1
import intermediateRep.{Array, Param}

object VectorAddition300 extends App{
  //300

  //auto-differentiate:  1.013809217
  //2.047133214
  //1.743646525
  //1.356331607
  //1.202974519
  //1.054614304
  //1.013809217
  //0.999503994
  //0.966842505
  //0.920929763
  //0.909652237

  //diff:  2.356165218
  //2.622038512
  //2.618615818
  //2.562741921
  //2.355755997
  //2.356165218
  //2.325631402
  //1.981716132
  //1.9386417
  //1.868791975
  //0.751258592


  //evaluate : 0.014645304

  //0.012213081
  //0.012248214
  //0.012757058
  //0.01342155
  //0.014557253
  //0.014733355
  //0.016097943
  //0.023338684
  //0.030584571
  //0.049636707

  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp1 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_2, x_1, x_1, x_1, x_2, x_1, x_0,
    x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
    x_2, x_1, x_0,
    x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
    x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_1, x_2,
    x_0, x_0, x_2, x_0, x_0, x_0, x_1, x_0, x_2, x_0,
    x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1,
    x_2, x_1, x_2, x_2, x_2, x_0, x_1, x_0, x_1,
    x_0, x_2, x_2, x_2, x_1, x_1, x_1, x_0, x_2,
    x_2, x_2, x_2, x_1, x_1, x_1, x_2, x_1, x_0,
    x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
    x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_1, x_2,
    x_0, x_0, x_2, x_0, x_0, x_0, x_1, x_0, x_2, x_0,
    x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
  x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
  x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
  x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
  x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1,
  x_2, x_1, x_2, x_2, x_2, x_0, x_1, x_0, x_1,
  x_0, x_2, x_2, x_2, x_1, x_1, x_1, x_0, x_2,
  x_2, x_2, x_2, x_1, x_1, x_1, x_2, x_1, x_0,
  x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
  x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_1, x_2,
  x_0, x_0, x_2, x_0, x_0, x_0, x_1, x_0, x_2, x_0)


  println("ARRAY LENGTH "+ exp1.length + "*******************************************")
  ExprVectorAddition.eval(exp1, true, true)
}
