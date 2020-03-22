package evaluation

import automaticDifferentiation.AutomaticDifferentiate
import differentiate.DifferentiateExpr
import eval.DoubleEvaluator
import intermediateRep.{Array, Param}
//ARRAY LENGTH 16*******************************************
//Eval:1066899ns
//Eval:1217393ns
//Eval:1247285ns
//Eval:2119717ns
//Eval:3318601ns
//Eval:4242791ns
//Eval:5664585ns
//Eval:5936870ns
//Eval:6553509ns
//Eval:8274188ns
//***********************************************
//AD time:1773405ns
//AD time:1968819ns
//AD time:2540523ns
//AD time:2724921ns
//AD time:3588648ns
//AD time:4021983ns
//AD time:4705414ns
//AD time:5314263ns
//AD time:15449474ns
//AD time:103019227ns
//***********************************************
//AD eval time:296314ns
//AD eval time:327637ns
//AD eval time:465103ns
//AD eval time:475402ns
//AD eval time:498637ns
//AD eval time:534913ns
//AD eval time:554562ns
//AD eval time:2476042ns
//AD eval time:7589373ns
//AD eval time:20063806ns
//***********************************************
//***********************************************
//SD time:319879ns
//SD time:335726ns
//SD time:343037ns
//SD time:343772ns
//SD time:348685ns
//SD time:349982ns
//SD time:367382ns
//SD time:378898ns
//SD time:1748365ns
//SD time:9056879ns
//***********************************************
//SD eval time:317180ns
//SD eval time:321637ns
//SD eval time:325521ns
//SD eval time:331185ns
//SD eval time:346999ns
//SD eval time:359478ns
//SD eval time:361723ns
//SD eval time:417156ns
//SD eval time:2083336ns
//SD eval time:9079987ns


object VectorScalarMult16 extends App {
    var x = Param("x")

    var x_0 = Param("x_0")
    var x_1 = Param("x_1")
    var x_2 = Param("x_2")
    var elemtype1 = DoubleEvaluator.eval((x_1 * x_2))
    var elemtype2 = DoubleEvaluator.eval(x_0 + (x_1 + x_2))
    var elemtype3 = DoubleEvaluator.eval(x_0 * (x_1 / x_2))


    var exp12 = List(
        elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3)
    println("ARRAY LENGTH "+ exp12.length + "*******************************************")
    var vector = DoubleEvaluator.eval(x * Array(exp12, x.t))
    ExprVectorScalar.eval(exp12, true, true)
}
