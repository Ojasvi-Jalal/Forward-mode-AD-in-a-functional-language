package evaluationVectorVar
import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep._

object dotProductVar  extends App {
 // len: List(16, 32, 48, 64, 80, 96, 112, 128, 142, 156, 170, 184, 198, 212, 226, 240, 254, 282, 296, 310, 318)
//  SDAll: List(1.4645195, 3.1815715, 1.8243205, 7.1486955, 4.8248665, 6.8670025, 14.499372999999999, 15.367795999999998, 12.650371499999999, 32.5518745, 32.8103875, 74.67497949999999, 93.83323399999999, 38.994658, 64.696617,  95.43567399999999, 89.61338649999999, 163.6741095, 227.44659, 200.5902985, 220.58407699999998)
//  SDEvalAll: List(4.068381, 6.8202169999999995, 13.092374, 44.864762, 79.6032305, 82.934212, 100.3742855,154.7515815, 174.06241, 229.1634035, 467.615321, 644.738784, 706.4923435, 569.572332, 1194.6309145, 1211.8323189999999, 1462.0437439999998, 1940.5400475, 2222.3389125, 2539.5993439999997, 2635.5844494999997)

//  len: List(16, 32, 48, 64, 80, 96, 112, 128, 142, 156, 170, 184, 198, 212, 226, 240, 254, 282, 296, 310)
//  ADAll: List(0.12854949999999998, 0.0986335, 0.07795099999999999, 0.0725195, 0.06325599999999999, 0.0531335, 0.0854335, 0.050663, 0.048777499999999994, 0.040547, 0.038438, 0.032479, 0.035006999999999996, 0.0285465, 0.0274585, 0.029782, 0.0243135, 0.029027999999999998, 0.0259635, 0.0241545)
//  ADEvalAll: List(0.015276, 0.014480999999999999, 0.035969999999999995, 0.0145905, 0.013953499999999999, 0.013124, 0.0381155, 0.0093335, 0.0086845, 0.008161999999999999, 0.0069875, 0.007186499999999999, 0.009323, 0.006698, 0.001516, 0.002362, 0.001931, 0.0022175, 0.0019054999999999999, 0.0018989999999999999)
//  SDAll: List()
//  SDEvalAll: List()

  var evalAll: List[Double] = Nil
  var ADAll: List[Double] = Nil
  var ADEvalAll: List[Double] = Nil
  var SDAll: List[Double] = Nil
  var SDEvalAll: List[Double] = Nil

  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")

  var vectorVar16 = VectorVar(x_0,16)
  var vectorVar32 = VectorVar(x_0,32)
  var vectorVar48 = VectorVar(x_0,48)
  var vectorVar64 = VectorVar(x_0,64)
  var vectorVar80 = VectorVar(x_0,80)
  var vectorVar96 = VectorVar(x_0,96)
  var vectorVar112 = VectorVar(x_0,112)
  var vectorVar128 = VectorVar(x_0,128)
  var vectorVar142 = VectorVar(x_0,142)
  var vectorVar156 = VectorVar(x_0,156)
  var vectorVar170 = VectorVar(x_0,170)
  var vectorVar184 = VectorVar(x_0,184)
  var vectorVar198 = VectorVar(x_0,198)
  var vectorVar212 = VectorVar(x_0,212)
  var vectorVar226 = VectorVar(x_0,226)
  var vectorVar240 = VectorVar(x_0,240)
  var vectorVar254 = VectorVar(x_0,254)
  var vectorVar282 = VectorVar(x_0,282)
  var vectorVar296 = VectorVar(x_0,296)
  var vectorVar310 = VectorVar(x_0,310)

  var x = Param("x")

  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp16 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0)

  var exp32 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_1, x_2)

  var exp48 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
    x_1, x_2, x_1, x_2,x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0)

  var exp64 = List(x_1, x_1, x_2, x_1, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2, x_1, x_1, x_2, x_1, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0,x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1,x_2,x_0, x_1, x_2,x_0, x_0, x_1)

  var exp70 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0,x_1, x_1, x_2, x_1, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2, x_1, x_1, x_2, x_1, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0,x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1,x_2,x_0, x_1, x_2,x_0, x_0, x_1)

  var exp86 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0,x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0,x_1, x_1, x_2, x_1, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2, x_1, x_1, x_2, x_1, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0,x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1,x_2,x_0, x_1, x_2,x_0, x_0, x_1)

  var exp102 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0,x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0,x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_1, x_2, x_2, x_0, x_1, x_0,x_1, x_1, x_2, x_1, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2, x_1, x_1, x_2, x_1, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1, x_2,x_0, x_1, x_2,x_0,x_2,x_0, x_1, x_2,x_0, x_0, x_1, x_2,x_0, x_1,x_2,x_0, x_1, x_2,x_0, x_0, x_1)

  //var exp114 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp128 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp142 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp156 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp170 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp184 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp198 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp212 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp226 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp240 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp254 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp268 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp282 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp296 = List(x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)
  var exp304 = List(x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_1, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2,x_0, x_2)

  var list_expr = List(exp16,exp32,exp48,exp64,exp70,exp86,exp102,
    exp128,exp142, exp156, exp170, exp184, exp198, exp212, exp226, exp226
    ,exp240, exp254, exp268, exp282, exp296, exp304)

  var list_expr_var = List(vectorVar16,vectorVar32,vectorVar48,vectorVar64,vectorVar80,vectorVar96,vectorVar112,
    vectorVar128,vectorVar142, vectorVar156, vectorVar170, vectorVar184, vectorVar198, vectorVar212, vectorVar226
    ,vectorVar240, vectorVar254, vectorVar282,  vectorVar296, vectorVar310)

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
      AutomaticDifferentiate.autodifferentiate(DotProduct(exp,exp), exp)
      val t1 = System.nanoTime()
      arrAD = arrAD:+(t1-t0)
    }

    var AD = AutomaticDifferentiate.autodifferentiate(DotProduct(exp,exp), exp)
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

//  for(exp <- list_expr){
//    lenList = lenList :+ exp.length
//    println("ARRAY LENGTH "+ exp.length + "*******************************************")
//    var a = Param("a")
//    var b = Param("b")
//
//    var vector = Vector(exp, x.t)
//    var dot = DoubleEvaluator.eval(DotProduct(vector, vector))
//      var arrSD: List[Long] = List()
//    for (a <- 0 to 19) {
//      val t0 = System.nanoTime()
//      DifferentiateExpr.differentiate(dot, vector)
//      val t1 = System.nanoTime()
//      arrSD = arrSD:+(t1-t0)
//    }
//
//    var SD = DifferentiateExpr.differentiate(dot, vector)
//    var SDeval = DoubleEvaluator.eval(SD)
//    var arrSDEval: List[Long] = List()
//    for (a <- 0 to 19) {
//      val t0 = System.nanoTime()
//      Evaluator.printString(SDeval)
//      val t1 = System.nanoTime()
//      arrSDEval = arrSDEval:+(t1-t0)
//    }
//
//    var sortedSDEval = arrSDEval.sorted
//    var sortedSD = arrSD.sorted
//
//    var resSD =   ((sortedSD(9)+sortedSD(10))*0.000001)/2
//    SDAll = SDAll :+resSD
//
//    var resSDEval =   ((sortedSDEval(9)+sortedSDEval(10))*0.000001)/2
//    SDEvalAll = SDEvalAll  :+ resSDEval
//
//    //      for(x<- sortedSD){
//    println( "SD time:" + resSD+ "ms")
//    //      }
//
//    println("***********************************************")
//
//    //      for(x<- sortedSDEval){
//    println( "SD eval time:" + resSDEval + "ms")
//    println()
//  }

  println("len: "+lenList)
  println("ADAll: "+ADAll)
  println("ADEvalAll: "+ADEvalAll)
  println("SDAll: "+SDAll)
  println("SDEvalAll: "+SDEvalAll)

}
