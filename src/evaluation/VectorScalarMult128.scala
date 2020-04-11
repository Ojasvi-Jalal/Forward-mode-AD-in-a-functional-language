package evaluation

import eval.DoubleEvaluator
import intermediateRep.{Vector, Param}

//ARRAY LENGTH 128*******************************************
//0.006656528
//   4768148 - 0.004768148
//Eval:1543011ns
//Eval:1595353ns
//Eval:1808154ns
//Eval:1972326ns
//Eval:3697345ns
//Eval:5838951ns
//Eval:6947255ns
//Eval:8458383ns
//Eval:15708082ns
//Eval:23254025ns
//***********************************************
//  22180451 ns - 0.022180451s
//AD time:2964031ns
//AD time:3735385ns
//AD time:4449585ns
//AD time:15598916ns
//AD time:22088147ns
//AD time:22272755ns
//AD time:22714852ns
//AD time:32899121ns
//AD time:53831145ns
//AD time:166486895ns
//***********************************************
//
//  2103899.5ns - 0.0021038995s
//AD eval time:1745659ns
//AD eval time:1760216ns
//AD eval time:1838071ns
//AD eval time:1895409ns
//AD eval time:1938861ns
//AD eval time:2268938ns
//AD eval time:2346722ns
//AD eval time:2554516ns
//AD eval time:4088539ns
//AD eval time:25568982ns
//***********************************************
//***********************************************
// 1581772.5ns - 0.0015817725s
//SD time:1019224ns
//SD time:1023760ns
//SD time:1052213ns
//SD time:1172428ns
//SD time:1462168ns
//SD time:1701377ns
//SD time:3259038ns
//SD time:3879197ns
//SD time:7823286ns
//SD time:81401111ns
//***********************************************

//  2079016.5ns - 0.0020790165
//SD eval time:883807ns
//SD eval time:931562ns
//SD eval time:1250159ns
//SD eval time:1872346ns
//SD eval time:2017629ns
//SD eval time:2140404ns
//SD eval time:2854565ns
//SD eval time:3465638ns
//SD eval time:3739874ns
//SD eval time:6055937ns

object VectorScalarMult128 extends App {
    var x = Param("x")

    var x_0 = Param("x_0")
    var x_1 = Param("x_1")
    var x_2 = Param("x_2")
    var elemtype1 = DoubleEvaluator.eval((x_1 * x_2))
    var elemtype2 = DoubleEvaluator.eval(x_0 + (x_1 + x_2))
    var elemtype3 = DoubleEvaluator.eval(x_0 * (x_1 / x_2))


    var exp12 = List(
        elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2,
        elemtype3, elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1,
        elemtype2, elemtype3,elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2,
        elemtype3, elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1,
        elemtype2, elemtype3,elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2,
        elemtype3, elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1,
        elemtype2, elemtype3,elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2,
        elemtype3, elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1,
        elemtype2, elemtype3,elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2,
      elemtype3, elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1,
      elemtype2, elemtype3,elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2,
      elemtype3, elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1,
      elemtype2, elemtype3,elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2,
      elemtype3, elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1,
      elemtype2, elemtype3,elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2,
      elemtype3, elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1,
      elemtype2, elemtype3)
    println("ARRAY LENGTH "+ exp12.length + "*******************************************")
    var vector = DoubleEvaluator.eval(x * Vector(exp12, x.t))
    ExprVectorScalar.eval(exp12, true, true)
}
