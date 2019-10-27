package Functions

object FloatTypeChecker {
  def typeCheck(e:Expr) : Type = {
    e match {
      case FloatLiteral(e) => FloatLiteral(e).t
      case FunctionCall(FunctionCall(_:AddFloat, arg2),arg1) => { typeCheck(arg1) == typeCheck(arg2)
        return typeCheck(arg1)}
    }
  }
}
