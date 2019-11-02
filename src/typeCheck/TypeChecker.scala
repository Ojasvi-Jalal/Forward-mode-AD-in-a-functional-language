package typeCheck

import intermediateRep.{Expr, DoubleType, FunctionType}
object TypeChecker {
  def typeCheck(e:Expr) : Any = {
    e.t match {
      case _:DoubleType.type => FloatTypeChecker.typeCheck(e)
      case _:FunctionType => FloatTypeChecker.typeCheck(e)
    }
  }
}
