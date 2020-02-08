package eval

import automaticDifferentiation.DerivativeTrace.{derivativeTrace, paramToArg}
import intermediateRep._

import scala.collection.mutable
import scala.language.implicitConversions

//TODO: Test multiplication
object DoubleEvaluator {
  val paramToArg = mutable.HashMap[Expr,Expr]()
  def eval(e:Expr, hm : mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()) : Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case DoubleLiteral(d) => DoubleLiteral(d)
      case Pair(x,y) => Pair(x,y)
      //case Array(a,b) => a
      case FunctionCall(FunctionCall(_:AddDouble, arg2), arg1) => {
        if(!hm.isEmpty){
          val newarg1 = if (hm.contains(arg1)) hm(arg1) else arg1
          val newarg2 = if (hm.contains(arg2)) eval(hm(arg2)) else arg2
          (newarg1, newarg2) match {
            case (arg1: Param, _) => Param("("+newarg1 + " + " + newarg2+")") // fix this
            case (_, arg2: Param) => Param("("+newarg1 + " + " + newarg2+")")
            case (DoubleLiteral(newarg1),DoubleLiteral(newarg2)) => DoubleLiteral(newarg1 + newarg2)
            case (_, _) => eval(eval(newarg1) + (eval(newarg2)))
          }
        }
        else {
          (arg1, arg2) match {
            case (arg1: Param, _) => Param("(" + arg1 + " + " + arg2 + ")")
            case (_, arg2: Param) => Param("(" + arg1 + " + " + arg2 + ")")
            case (DoubleLiteral(arg1), DoubleLiteral(arg2)) => DoubleLiteral(arg1 + arg2)
            case (_, _) => eval(eval(arg1) + (eval(arg2)))
          }
        }
      }

      case FunctionCall(FunctionCall(_:MultiplyDouble, arg2),arg1) => {
        if(!hm.isEmpty){
          val newarg1 = if (hm.contains(arg1)) hm(arg1) else arg1
          val newarg2 = if (hm.contains(arg2)) eval(hm(arg2)) else arg2
          (newarg1, newarg2) match {
            case (arg1: Param, _) => Param("("+newarg1 + " * " + newarg2+")") // fix this
            case (_, arg2: Param) => Param("("+newarg1 + " * " + newarg2+")")
            case (DoubleLiteral(newarg1),DoubleLiteral(newarg2)) => DoubleLiteral(newarg1 * newarg2)
            case (_, _) => eval(eval(newarg1) * (eval(newarg2)))
          }
        }
        else

        (arg1, arg2) match {
          case (arg1: Param, _) =>Param("("+arg1 + " * " + arg2+")")
          case (_, arg2: Param) => Param("("+arg1 + " * " + arg2+")")
          case (DoubleLiteral(arg1),DoubleLiteral(arg2)) => DoubleLiteral(arg1 * arg2)
          case (_, _) => eval(eval(arg1) * (eval(arg2)))
        }
      }

      case FunctionCall(FunctionCall(_:DivideDouble, arg2),arg1) => {
        (arg1, arg2) match {
          case (arg1: Param, _) => Param("("+arg1 + " / " + arg2+")")
          case (_, arg2: Param) => Param("("+arg1 + " / " + arg2+")")
          case (DoubleLiteral(arg1),DoubleLiteral(arg2)) => {
            DoubleLiteral(arg1/arg2)
          }
          case (_, _) => eval((eval(arg1)) / (eval(arg2)))
        }}

      case FunctionCall(FunctionCall(_:PowerDouble, arg1),arg2) => {
        (arg1, arg2) match {
          case (arg1: Param, _) => Param("("+arg1 + " ^ " + arg2+")")
          case (_, arg2: Param) => Param("("+arg1 + " ^ " + arg2+")")
          case (DoubleLiteral(arg1),DoubleLiteral(arg2)) => {
            val exponent  = java.lang.Double.valueOf(arg2)
            val base      = java.lang.Double.valueOf(arg1)
            DoubleLiteral(scala.math.pow(base,exponent))
          }
          case (_, _) => {
            val exponent  = java.lang.Double.valueOf(eval(arg2).toString)
            val base      = java.lang.Double.valueOf(eval(arg1).toString)
            eval((eval(arg1)^eval(arg2)))
          }

        }
      }

      case Map(param, body, vector) =>
        var array : Seq[Expr] = Seq()
        for (z <- vector.a) {
          array = array:+(eval(FunctionCall((Lambda(param, body.asInstanceOf[Expr])), z)))
        }
        Array(array, vector.t)

//      case Fold(param, body, initial, vector) =>
//        vector.a match {
//          case Nil => initial
//          case head :: tail =>
//            body match {
//              case FunctionCall(FunctionCall(_:MultiplyDouble, arg2),arg1) => FunctionCall(FunctionCall(MultiplyDouble(Fold(tail, head)), Fold(tail, head)), head)
//            }
//        }

      case Zip(vector1, vector2) =>
          var array : Seq[(Expr, Expr)] = Seq()
          ArrayPairs(vector1.a zip vector2.a, vector1.t)
////        for ((x,y) <- vector1.a zip vector2.a) {
////          array:+(Pair(x,y))
////        }
////        Array(array, vector1.t)
//
//        (vector1.a, vector2.a) match {
//          case (Nil, _) => Nil
//          case (_, Nil) => Nil
//            case (x :: xs, y :: ys) =>
//              array:+(Pair(x, y))
//          }
//          Array(array, vector1.t)

      case FunctionCall(Lambda(param,body),arg) =>
        // store in a map   param -> arg and eval body
        paramToArg.put(param, arg.asInstanceOf[Expr])
        eval(body,paramToArg)

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

  def deEval() : mutable.HashMap[Expr, Expr] = {
    val argToParam = mutable.HashMap[Expr,Expr]()
  //  e match {
   //   case FunctionCall(FunctionCall(_: AddDouble, arg2), arg1) => {
        for ((k, v) <- paramToArg) argToParam.put(v, k)
        argToParam
      }
//    }
//  }
}