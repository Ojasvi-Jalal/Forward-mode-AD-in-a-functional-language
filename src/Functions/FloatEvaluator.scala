package Functions

import scala.collection.mutable
import scala.language.implicitConversions

object FloatEvaluator {
  val paramToArg = mutable.HashMap[Param,Expr]()
  def eval(e:Expr) : Float = {
    e match {
      case FloatLiteral(f) => f
      case FunctionCall(FunctionCall(_:AddFloat, arg2),arg1) =>  eval(arg1) + eval(arg2)
      case FunctionCall(FunctionCall(_:MultiplyFloat, arg2),arg1) => eval(arg1) * eval(arg2)
      case FunctionCall(FunctionCall(_:DivideFloat, arg2),arg1) => eval(arg1) / eval(arg2)
      case FunctionCall(FunctionCall(_:PowerFloat, arg2),arg1) => {
        val exponent  = java.lang.Double.valueOf(eval(arg1))
        val base      = java.lang.Double.valueOf(eval(arg2))
        scala.math.pow(base,exponent).asInstanceOf[Float]
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