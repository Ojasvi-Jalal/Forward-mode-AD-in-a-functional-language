package evaluation.vectorAddition

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Array, Param}

object VectorAddition500 extends App{
  //500

  //auto differentiate:  5.046835936

  //6.723734511s
  //5.230645305s
  //5.074735066s
  //5.064860549s
  //5.099417689s
  //4.994254183
  //4.759221493s
  //4.596291372s
  //4.561457613s
  //5.099889009

  //differentiate: 7.6039724105
  //8.668511927
  //8.595623834
  //8.541462673
  //7.727909806
  //7.769036629
  //7.438908192
  //7.327297975
  //7.314331514
  //6.683878828
  //4.392939959

  //evaluate : 0.0235981335

  //0.014004849
  //0.015816896
  //0.016363391
  //0.020242531
  //0.023699018
  //0.023497249
  //0.027913127
  //0.028894727
  //0.029470728
  //0.032413292

  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp1 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1,
    x_2, x_1, x_2, x_2, x_2, x_0, x_1, x_0, x_1,
    x_0, x_2, x_2, x_2, x_1, x_1, x_1, x_0, x_2,
    x_2, x_2, x_2, x_1, x_1, x_1, x_2, x_1, x_0,
    x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
    x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_1, x_2,
    x_0, x_0, x_2, x_0, x_0, x_0, x_1, x_0, x_2, x_0,x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1,
    x_2, x_1, x_2, x_2, x_2, x_0, x_1, x_0, x_1,
    x_0, x_2, x_2, x_2, x_1, x_1, x_1, x_0, x_2,
    x_2, x_2, x_2, x_1, x_1, x_1, x_2, x_1, x_0,
    x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
    x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_1, x_2,
    x_0, x_0, x_2, x_0, x_0, x_0, x_1, x_0, x_2, x_0,x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1,
    x_2, x_1, x_2, x_2, x_2, x_0, x_1, x_0, x_1,
    x_0, x_2, x_2, x_2, x_1, x_1, x_1, x_0, x_2,
    x_2, x_2, x_2, x_1, x_1, x_1, x_2, x_1, x_0,
    x_2, x_2, x_1, x_0, x_1, x_1, x_2, x_2, x_1,
    x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_1, x_2,
    x_0, x_0, x_2, x_0, x_0, x_0, x_1, x_0, x_2, x_0,x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1, x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1,    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2, x_1, x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_0, x_1, x_0, x_1, x_2, x_1, x_1,
    x_0, x_0, x_0, x_1, x_2, x_0, x_2, x_2, x_1,
    x_0, x_1, x_0, x_1, x_2, x_2, x_1, x_2)


  println("ARRAY LENGTH "+ exp1.length + "*******************************************")
  ExprVectorAddition.eval(exp1, true, true)
}
