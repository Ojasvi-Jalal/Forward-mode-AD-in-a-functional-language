package evaluation.dotProduct

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.{DoubleEvaluator, Evaluator}
import intermediateRep.{Array, DotProduct, Param}

object DotProduct30 extends App{
  //30

  // auto differentiate:
  //0.400514639s
  //0.368162628s
  //0.336117569s
  //0.305890819s
  //0.298980732s
  //0.298926832s
  //0.270293608s
  //0.27000929s
  //0.25973718s
  //0.25220575s

  // differentiate:
  //0.120546847s
  //0.08347052s
  //0.071433684s
  //0.070115665s
  //0.069817809s
  //0.069261881s
  //0.057339401s
  //0.054299092s
  //0.051948911s
  //0.04353292s

  // evaluate: 0.064717139
  //0.083663313s
  //0.074111876s
  //0.068839785s
  //0.067793118s
  //0.064729327s
  //0.064704951s
  //0.063176835s
  //0.063008674s
  //0.054082181s
  //0.051737092s



  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp1 = List(x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
    x_1, x_0, x_1, x_0, x_2, x_0, x_0, x_2, x_2, x_2,
  x_1, x_1, x_2, x_2, x_0, x_1, x_0, x_2, x_1,
  x_1, x_2)

  var vector = Array(exp1, x.t)
  //var dot = DoubleEvaluator.eval(DotProduct(vector, vector))
  val t0 = System.nanoTime()
  //(AutomaticDifferentiate.autodifferentiate(dot, vector)) // call-by-name
  //DifferentiateExpr.differentiate(dot, vector)
  DoubleEvaluator.eval(DotProduct(vector, vector))
  val t1 = System.nanoTime()

  println("Elapsed time: " + (t1 - t0)/(1e+9) + "s")

   println(exp1.length)
  //println(Evaluator.printString(DoubleEvaluator.eval(x * Array(exp, x.t))))
 // println(Evaluator.printString(result))
//  //println(result.t)
//  var check =  List(((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_1 * x) + ((x_2 * x_1) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))), ((DoubleLiteral(0.0) * x) + ((x_2 + x_0) * DoubleLiteral(1.0))), ((x_0 * x) + ((x_2 * x_0) * DoubleLiteral(1.0))))
//  println(check.length)
//  println(exp.length)
  // var check = List(DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0), DoubleLiteral(1.0))
 // println(check.length)
}
