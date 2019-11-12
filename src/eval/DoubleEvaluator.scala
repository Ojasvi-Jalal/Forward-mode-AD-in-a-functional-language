package eval

import intermediateRep._

import scala.collection.mutable
import scala.language.implicitConversions

//TODO: Test multiplication
object DoubleEvaluator {
  val paramToArg = mutable.HashMap[Param,Expr]()
  def eval(e:Expr, hm : mutable.HashMap[Param, Double] = mutable.HashMap[Param, Double]()) : Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case DoubleLiteral(d) => DoubleLiteral(d)
      case FunctionCall(FunctionCall(_:AddDouble, arg2),arg1) =>  {
        (arg1, arg2) match {
          case (arg1: Param, _) => Param("("+arg1 + " + " + arg2+")")
          case (_, arg2: Param) => Param("("+arg1 + " + " + arg2+")")
          case (DoubleLiteral(arg1),DoubleLiteral(arg2)) => DoubleLiteral(arg1 + arg2)
          case (_, _) => eval(eval(arg1) + (eval(arg2)))
        }
      }
      case FunctionCall(FunctionCall(_:MultiplyDouble, arg2),arg1) => {
        (arg1, arg2) match {
          case (arg1: Param, _) => Param("("+arg1 + " * " + arg2+")")
          case (_, arg2: Param) => Param("("+arg1 + " * " + arg2+")")
          case (DoubleLiteral(arg1),DoubleLiteral(arg2)) => DoubleLiteral(arg1 * arg2)
          case (_, _) => eval(eval(arg1) * (eval(arg2)))
        }
      }
      case FunctionCall(FunctionCall(_:DivideDouble, arg2),arg1) => {
        (arg1, arg2) match {
          case (arg1: Param, _) => Param(arg1 + " / " + arg2)
          case (_, arg2: Param) => Param(arg1 + " / " + arg2)
          case (DoubleLiteral(arg1),DoubleLiteral(arg2)) => {
            DoubleLiteral(arg1/arg2)
          }
          case (_, _) => eval((eval(arg1)) / (eval(arg2)))
        }}
      case FunctionCall(FunctionCall(_:PowerDouble, arg1),arg2) => {
        (arg1, arg2) match {
          case (arg1: Param, _) => Param(arg1 + " ^ " + arg2)
          case (_, arg2: Param) => Param(arg1 + " ^ " + arg2)
          case (DoubleLiteral(arg1),DoubleLiteral(arg2)) => {
            val exponent  = java.lang.Double.valueOf(arg2)
            val base      = java.lang.Double.valueOf(arg1)
            DoubleLiteral(scala.math.pow(base,exponent))
          }
          case (_, _) => {
            val exponent  = java.lang.Double.valueOf(eval(arg2).toString)
            val base      = java.lang.Double.valueOf(eval(arg1).toString)
            DoubleLiteral(scala.math.pow(base,exponent))
          }
        }
      }
      case FunctionCall(Lambda(param,body),arg) =>
        // store in a map   param -> arg and eval body
        paramToArg.put(param, arg)
        eval(body,hm)
      case p:Param =>
        // fish it up from the map and eval the expr
        if (paramToArg.contains(p)){
          eval(paramToArg(p))
        }
        else{
          Var(p).value
        }
    }
  }
}