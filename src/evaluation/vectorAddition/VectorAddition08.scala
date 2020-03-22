package evaluation.vectorAddition

import intermediateRep.{Array, Param}

object VectorAddition10 extends App{





  var x = Param("x")


  var x_0 = Param("x_0")
  var x_1 = Param("x_1")
  var x_2 = Param("x_2")
  var elemtype1 = x_0

  var elemtype2 = x_1
  var elemtype3 = x_2

  var exp1 = List(
    elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1, elemtype2, elemtype3, elemtype1, elemtype3,elemtype3, elemtype2, elemtype3, elemtype2, elemtype1, elemtype1)
  //println(exp.length)
  println("ARRAY LENGTH "+ exp1.length + "*******************************************")
  ExprVectorAddition.eval(exp1, true, true)
}
