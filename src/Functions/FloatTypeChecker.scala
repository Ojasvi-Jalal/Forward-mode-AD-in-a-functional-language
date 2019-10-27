package Functions

object FloatTypeChecker {
  def typeCheck(e:Expr) : Type = {
    e match {
      case FloatLiteral(e) => FloatLiteral(e).t
      case FunctionCall(FunctionCall(_:AddFloat, arg2),arg1) => {
        val typeArg1 = typeCheck(arg1)
        val typeArg2 = typeCheck(arg2)
//        println(typeCheck(arg1))
//        println(typeCheck(arg1))
//        val isSameType =  (typeArg1 == typeArg2)
//        println(isSameType)
        return typeCheck(arg1)}
      case FunctionCall(FunctionCall(_:MultiplyFloat, arg2),arg1) => {
        //assert(typeCheck(arg1) == typeCheck(arg2))
        return typeCheck(arg1)}
      }
    }
  }
