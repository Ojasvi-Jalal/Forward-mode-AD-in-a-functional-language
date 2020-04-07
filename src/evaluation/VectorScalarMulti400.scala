package evaluation

import eval.DoubleEvaluator
import intermediateRep.{Array, Param}


object VectorScalarMulti304 extends App{

//  ARRAY LENGTH 304*******************************************
  //  2781391ns - 0.002781391s
//    Eval:1690674ns
//    Eval:1754353ns
//    Eval:2017155ns
//    Eval:2309796ns
//    Eval:2607456ns
//    Eval:2955326ns
//    Eval:2989938ns
//    Eval:8658297ns
//    Eval:17494039ns
//    Eval:18368001ns
//    ***********************************************
  //  15209822ns - 0.015209822
//    AD time:5004724ns
//    AD time:8557809ns
//    AD time:8667605ns
//    AD time:9675105ns
//    AD time:12330387ns
//    AD time:18089257ns
//    AD time:22203381ns
//    AD time:33232531ns
//    AD time:38135819ns
//    AD time:126626126ns
//    ***********************************************
  //  8077684.5ns - 0.0080776845s
//    AD eval time:4560534ns
//    AD eval time:4768122ns
//    AD eval time:5075387ns
//    AD eval time:6943386ns
//    AD eval time:7188610ns
//    AD eval time:8966759ns
//    AD eval time:9199467ns
//    AD eval time:10940407ns
//    AD eval time:18821590ns
//    AD eval time:19028733ns
//    ***********************************************
//  ***********************************************
//    1932206.5s - 0.001932206s
//    SD time:1818285ns
//    SD time:1836569ns
//    SD time:1839713ns
//    SD time:1872804ns
//    SD time:1877629ns
//    SD time:1986784ns
//    SD time:2547168ns
//    SD time:2991736ns
//    SD time:5598975ns
//    SD time:8686916ns
//    ***********************************************
  // 1998446.5 -  0.0019984465s
//    SD eval time:1401261ns
//    SD eval time:1402059ns
//    SD eval time:1404812ns
//    SD eval time:1787205ns
//    SD eval time:1803764ns
//    SD eval time:2193129ns
//    SD eval time:2520790ns
//    SD eval time:3491967ns
//    SD eval time:5412109ns
//    SD eval time:5816452ns



  var x = Param("x")
  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = DoubleEvaluator.eval((x_1 * x_2))
  var elemtype2 = DoubleEvaluator.eval(x_0 + (x_1 + x_2))
  var elemtype3 = DoubleEvaluator.eval(x_0 * (x_1 / x_2))

  var exp = List(elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype2, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype3, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1,
    elemtype1, elemtype3, elemtype2, elemtype2, elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype3, elemtype1, elemtype3, elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1,
    elemtype3, elemtype3, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype3, elemtype2, elemtype3, elemtype2, elemtype3,
    elemtype1, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2,
    elemtype1, elemtype1, elemtype2, elemtype2, elemtype3, elemtype2, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype1, elemtype3, elemtype2, elemtype2, elemtype3, elemtype3, elemtype3, elemtype3, elemtype3, elemtype1, elemtype1, elemtype1,
    elemtype3, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype3, elemtype1, elemtype1, elemtype3, elemtype1, elemtype3, elemtype3,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2,
    elemtype2, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype2, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3,
    elemtype2, elemtype3, elemtype1, elemtype3, elemtype3, elemtype3, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype2, elemtype1,
    elemtype2, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype2, elemtype1, elemtype3, elemtype1, elemtype2, elemtype1, elemtype2,
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3, elemtype1, elemtype2, elemtype3,
    elemtype3, elemtype1, elemtype2, elemtype1, elemtype2, elemtype3, elemtype2, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype1, elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2, elemtype1, elemtype1, elemtype1,elemtype1, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype1, elemtype3, elemtype3, elemtype2,elemtype3)

  println("ARRAY LENGTH "+ exp.length + "*******************************************")
  var vector = DoubleEvaluator.eval(x * Array(exp, x.t))
  ExprVectorScalar.eval(exp, true, true)
}
