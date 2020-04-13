package evaluationVectorVar
import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._


object vectorScalarVar extends App{
//
//  len: List(16, 100, 212, 318, 418, 518, 636, 736, 836, 936, 16, 100, 212, 318, 418, 518, 636, 736, 836, 936)
//  ADAll: List(0.0862595, 0.0746035, 0.065049, 0.0610465, 0.0634925, 0.053273999999999995, 0.050638999999999997, 0.047752499999999996, 0.075677, 0.054322499999999996)
//  ADEvalAll: List(0.0276825, 0.0428315, 0.020243999999999998, 0.039244999999999995, 0.019495, 0.015534999999999998, 0.015229999999999999, 0.013606, 0.031809, 0.012022999999999999)
//  SDAll: List(0.767096, 1.578563, 0.5199395, 0.9394804999999999, 1.5456185, 1.6019795, 2.806013, 8.8146135, 5.0974145, 21.894306)
//  SDEvalAll: List(0.8075985, 1.306566, 2.376716, 2.4691104999999998, 1.4761445, 5.1043275, 4.0178175, 4.2365895, 6.7455355, 6.0424619999999996)
  var evalAll: List[Double] = Nil
  var ADAll: List[Double] = Nil
  var ADEvalAll: List[Double] = Nil
  var SDAll: List[Double] = Nil
  var SDEvalAll: List[Double] = Nil

  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")

  var vectorVar16 = VectorVar(x_0,16)
  var vectorVar100 = VectorVar(x_0,100)
  var vectorVar212 = VectorVar(x_0,212)
  var vectorVar318 = VectorVar(x_0,318)
  var vectorVar418 = VectorVar(x_0,418)
  var vectorVar518 = VectorVar(x_0,518)
  var vectorVar636 = VectorVar(x_0,636)
  var vectorVar736 = VectorVar(x_0,736)
  var vectorVar836 = VectorVar(x_0,836)
  var vectorVar936 = VectorVar(x_0,936)

  var x = Param("x")

  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp16 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp100 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp212 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp318 = List(x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp418 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp518 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2, x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp636 = List(x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp736 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp836 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp936 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  //x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)

  var list_expr = List(exp16, exp100, exp212, exp318, exp418, exp518, exp636, exp736, exp836, exp936)


  var list_expr_var = List(vectorVar16, vectorVar100, vectorVar212, vectorVar318, vectorVar418, vectorVar518, vectorVar636, vectorVar736, vectorVar836, vectorVar936)

  var  lenList: List[Int] = List()
  for(exp <- list_expr_var){
    lenList = lenList :+ exp.len
    var vector = VectorVar(exp, exp.len)
    println("ARRAY LENGTH "+ exp.len + "*******************************************")
    var a = Param("a")
    var b = Param("b")
    //  var maxVector = (DoubleEvaluator.eval(Fold(GreaterThan(a,b), vector.list.head, vector )))
    var arrAD: List[Long] = List()
    for (a <- 0 to 19) {
      val t0 = System.nanoTime()
      AutomaticDifferentiate.autodifferentiate(x*vector, x)
      val t1 = System.nanoTime()
      arrAD = arrAD:+(t1-t0)
    }

    var AD = AutomaticDifferentiate.autodifferentiate(x*vector, x)
    //var ADeval = DoubleEvaluator.eval(AD)
    var arrADEval: List[Long] = List()
    for (a <- 0 to 19) {
      val t0 = System.nanoTime()
      DoubleEvaluator.eval(AD)
      val t1 = System.nanoTime()
      arrADEval = arrADEval:+(t1-t0)
    }

    var sortedADEval = arrADEval.sorted
    var sortedAD = arrAD.sorted

    var resAD =   ((sortedAD(9)+sortedAD(10))*0.000001)/2
    ADAll = ADAll :+resAD

    var resADEval =   ((sortedADEval(9)+sortedADEval(10))*0.000001)/2
    ADEvalAll = ADEvalAll  :+ resADEval

    //      for(x<- sortedSD){
    println( "AD time:" + resAD+ "ms")
    //      }

    println("***********************************************")

    //      for(x<- sortedSDEval){
    println( "AD eval time:" + resADEval + "ms")
    println()
  }

    for(exp <- list_expr){
      lenList = lenList :+ exp.length
      println("ARRAY LENGTH "+ exp.length + "*******************************************")
      var a = Param("a")
      var b = Param("b")

      var vector = DoubleEvaluator.eval(x * Vector(exp, x.t))

        var arrSD: List[Long] = List()
      for (a <- 0 to 19) {
        val t0 = System.nanoTime()
        DifferentiateExpr.differentiate(vector, x)
        val t1 = System.nanoTime()
        arrSD = arrSD:+(t1-t0)
      }

      var SD = DifferentiateExpr.differentiate(vector, x)
      var SDeval = DoubleEvaluator.eval(SD)
      var arrSDEval: List[Long] = List()
      for (a <- 0 to 19) {
        val t0 = System.nanoTime()
        Evaluator.printString(SDeval)
        val t1 = System.nanoTime()
        arrSDEval = arrSDEval:+(t1-t0)
      }

      var sortedSDEval = arrSDEval.sorted
      var sortedSD = arrSD.sorted

      var resSD =   ((sortedSD(9)+sortedSD(10))*0.000001)/2
      SDAll = SDAll :+resSD

      var resSDEval =   ((sortedSDEval(9)+sortedSDEval(10))*0.000001)/2
      SDEvalAll = SDEvalAll  :+ resSDEval

      //      for(x<- sortedSD){
      println( "SD time:" + resSD+ "ms")
      //      }

      println("***********************************************")

      //      for(x<- sortedSDEval){
      println( "SD eval time:" + resSDEval + "ms")
      println()
    }

  println("len: "+lenList)
  println("ADAll: "+ADAll)
  println("ADEvalAll: "+ADEvalAll)
  println("SDAll: "+SDAll)
  println("SDEvalAll: "+SDEvalAll)
}
