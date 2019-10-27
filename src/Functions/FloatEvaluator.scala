package Functions

import scala.collection.mutable

object FloatEvaluator {
  val paramToArg = mutable.HashMap[Param,Expr]()
  def eval(e:Expr) : Float = {
    e match {
      case FloatLiteral(f) => f
      case FunctionCall(FunctionCall(_:AddFloat, arg2),arg1) =>  eval(arg1) + eval(arg2)
      case FunctionCall(FunctionCall(_:MultiplyFloat, arg2),arg1) => eval(arg1) * eval(arg2)
      case FunctionCall(FunctionCall(_:DivideFloat, arg2),arg1) => eval(arg1) / eval(arg2)
      case FunctionCall(FunctionCall(_:PowerFloat, arg2),arg1) => {
        var result = 1.0
        var i = 0.0
        java.lang.Integer.valueOf(arg2)
        if(arg2 == 0.0)
          1
        for(i <- 1 to ){
          result =  result * eval(arg1)
        }
        result.toFloat
      }
      case FunctionCall(Lambda(param,body),arg) =>
        // store in a map   param -> arg and eval body
        paramToArg.put(param, arg)
        eval(body)
      case p:Param =>
        // fish it up from the map and eval the expr
        eval(paramToArg(p))
    }
  }
}