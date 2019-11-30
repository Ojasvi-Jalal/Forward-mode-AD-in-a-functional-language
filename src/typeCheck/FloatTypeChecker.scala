package typeCheck

import intermediateRep.{Expr, Type, DoubleLiteral, FunctionCall, AddDouble, MultiplyDouble, DivideDouble, PowerDouble}

object FloatTypeChecker {
  def typeCheck(e: Expr): Type = {
    e match {
      case DoubleLiteral(d) => DoubleLiteral(d).t

      case FunctionCall(FunctionCall(_: AddDouble, arg2), arg1) =>
        assert(typeCheck(arg1) === typeCheck(arg2))
        typeCheck(arg1)

      case FunctionCall(FunctionCall(_: MultiplyDouble, arg2), arg1) =>
        assert(typeCheck(arg1) === typeCheck(arg2))
        typeCheck(arg1)

      case FunctionCall(FunctionCall(_: DivideDouble, arg2), arg1) =>
        assert(typeCheck(arg1) === typeCheck(arg2))
        typeCheck(arg1)

      case FunctionCall(FunctionCall(_: PowerDouble, arg2), arg1) =>
        assert(typeCheck(arg1) === typeCheck(arg2))
        typeCheck(arg1)

    }
  }
}
