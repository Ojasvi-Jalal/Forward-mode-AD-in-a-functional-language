package evaluation.discarded

import eval.DoubleEvaluator
import evaluation.ExprVectorScalar
import intermediateRep.{Array, Param}

object VectorScalarMulti2024 extends App{

  //2024

  //evaluation: 0.6166729375

  //1.355051172s
  //1.293869214s
  //1.003181277s
  //0.770577325s
  //0.71378693s
  //0.519558945s
  //0.451070898s
  //0.359674334s
  //0.339817588s
  //0.313163387s


  //auto-diff

  //0.417791368s
  //0.382832388s
  //0.328135653s
  //0.286653867s
  //0.27011022s
  //0.252360247s
  //0.248012202s
  //0.211589423s
  //0.197507353s
  //0.191476797s

  //diff:  0.3979654295
  //0.64688568s
  //0.627954018s
  //0.491026135s
  //0.400510369s
  //0.400310376s
  //0.395620483s
  //0.391075283s
  //0.345544634s
  //0.338045669s
  //0.29393969s


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
  elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3,
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
    elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3
  )

  println("ARRAY LENGTH "+ exp.length + "*******************************************")
  var vector = DoubleEvaluator.eval(x * Array(exp, x.t))
  ExprVectorScalar.eval(exp, true, true)
}
