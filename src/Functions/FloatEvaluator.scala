package Functions

import scala.collection.mutable
import scala.language.implicitConversions

object FloatEvaluator {
  val paramToArg = mutable.HashMap[Param,Expr]()
  def eval(e:Expr, hm : mutable.HashMap[Param, Double] = mutable.HashMap[Param, Double]()) : Double = { //passing down vthe imformation -> I can start having variables //hm goes to var to a float
    e match {
      case DoubleLiteral(d) => d
      case FunctionCall(FunctionCall(_:AddDouble, arg2),arg1) =>  eval(arg1) + eval(arg2)
      case FunctionCall(FunctionCall(_:MultiplyDouble, arg2),arg1) => eval(arg1) * eval(arg2)
      case FunctionCall(FunctionCall(_:DivideDouble, arg2),arg1) => eval(arg1) / eval(arg2)
      case FunctionCall(FunctionCall(_:PowerDouble, arg2),arg1) => {
        val exponent  = eval(arg1)//java.lang.Double.valueOf(eval(arg1))
        val base      = eval(arg2)//java.lang.Double.valueOf(eval(arg2))
        scala.math.pow(base,exponent).asInstanceOf[Double]
      }
      case FunctionCall(Lambda(param,body),arg) =>
        // store in a map   param -> arg and eval body
        paramToArg.put(param, arg)
        eval(body,hm)
      case p:Param =>
        // fish it up from the map and eval the expr
        eval(paramToArg(p))
    }
  }
}