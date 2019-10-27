package Functions

object TypeChecker {
  def typeCheck(e:Expr) : Any = {
    e.t match {
      case _:FloatType => FloatTypeChecker.typeCheck(e)
      case _:FunctionType => FloatTypeChecker.typeCheck(e)
    }
  }
}
