package evaluation

import eval.DoubleEvaluator
import intermediateRep.{Array, Param}
//ARRAY LENGTH 64*******************************************
//0.004710613
//4722686.5ns - 0.0047226865s

//Eval:3927501ns
//Eval:4280925ns
//Eval:4451375ns
//Eval:4518512ns
//Eval:4601452ns
//Eval:4843921ns
//Eval:5323255ns
//Eval:6148276ns
//Eval:6463532ns
//Eval:12111640ns
//***********************************************

//6268650ns - 0.00626865s

//AD time:2398679ns
//AD time:2451294ns
//AD time:2453683ns
//AD time:4352148ns
//AD time:4382126ns
//AD time:8155174ns
//AD time:8705208ns
//AD time:9218303ns
//AD time:17622145ns
//AD time:98435992ns
//***********************************************

//1258238ns - 0.001258238s

//AD eval time:905635ns
//AD eval time:936346ns
//AD eval time:958514ns
//AD eval time:1024691ns
//AD eval time:1237248ns
//AD eval time:1279228ns
//AD eval time:3263694ns
//AD eval time:10248190ns
//AD eval time:22909833ns
//AD eval time:50647982ns
//***********************************************
//***********************************************
//712346ns - 0.000712346s

//SD time:533096ns
//SD time:538318ns
//SD time:541507ns
//SD time:696956ns
//SD time:706073ns
//SD time:718619ns
//SD time:917233ns
//SD time:1117692ns
//SD time:1305356ns
//SD time:5884166ns
//***********************************************
  // 0.000989588

//SD eval time:335987ns
//SD eval time:356743ns
//SD eval time:605226ns
//SD eval time:932202ns
//SD eval time:978858ns
//SD eval time:1000318ns
//SD eval time:1044479ns
//SD eval time:1206765ns
//SD eval time:1831363ns
//SD eval time:26239419ns


object VectorScalarMult64 extends App {
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
        elemtype2, elemtype3)
    println("ARRAY LENGTH "+ exp12.length + "*******************************************")
    var vector = DoubleEvaluator.eval(x * Array(exp12, x.t))
    ExprVectorScalar.eval(exp12, true, true)
}
