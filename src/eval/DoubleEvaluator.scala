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
            case (arg1: Param, _) => newarg1  + newarg2 // fix this
            case (_, arg2: Param) => newarg1 + newarg2
            case (DoubleLiteral(newarg1),DoubleLiteral(newarg2)) => DoubleLiteral(newarg1 + newarg2)
            case (_:Array, _:Array) =>
              var array: Expr = eval(Zip(newarg1, newarg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x+y, array.asInstanceOf[ArrayPairs]))
              array
            case (_, _) => (eval(newarg1) + (eval(newarg2)))
          }
        }
        else {
          (arg1, arg2) match {
            case (arg1: Param, _) => arg1 + arg2
            case (_, arg2: Param) => arg1 + arg2
            case (DoubleLiteral(arg1), DoubleLiteral(arg2)) => DoubleLiteral(arg1 + arg2)
            case (_:Array, _:Array) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x+y, array.asInstanceOf[ArrayPairs]))
              array
            case (_:Array, _:Param) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x+y, array.asInstanceOf[ArrayPairs]))
              array
            case (_:Array, _:DoubleLiteral) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x+y, array.asInstanceOf[ArrayPairs]))
              array
            case (_:Param, _:Array) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x+y, array.asInstanceOf[ArrayPairs]))
              array
            case (_:DoubleLiteral, _:Array) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x+y, array.asInstanceOf[ArrayPairs]))
              array
            case (_, _) => (eval(arg1) + (eval(arg2)))
          }
        }
      }

      case FunctionCall(FunctionCall(_:MultiplyDouble, arg2),arg1) => {
        if(!hm.isEmpty){
          val newarg1 = if (hm.contains(arg1)) hm(arg1) else arg1
          val newarg2 = if (hm.contains(arg2)) eval(hm(arg2)) else arg2
          (newarg1, newarg2) match {
            case (arg1: Param, _) => newarg1  * newarg2 // fix this
            case (_, arg2: Param) => newarg1 * newarg2
            case (DoubleLiteral(newarg1),DoubleLiteral(newarg2)) => DoubleLiteral(newarg1 * newarg2)
            case (_:Array, _:Array) =>
              var array: Expr = eval(Zip(newarg1, newarg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x*y, array.asInstanceOf[ArrayPairs]))
              array
            case (_:Array, _:Param) =>
              var array: Expr = eval(Zip(newarg1, newarg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x*y, array.asInstanceOf[ArrayPairs]))
              array
            case (_:Array, _:DoubleLiteral) =>
              var array: Expr = eval(Zip(newarg1, newarg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x*y, array.asInstanceOf[ArrayPairs]))
              array
            case (_:Param, _:Array) =>
              var array: Expr = eval(Zip(newarg1, newarg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x*y, array.asInstanceOf[ArrayPairs]))
              array
            case (_:DoubleLiteral, _:Array) =>
              var array: Expr = eval(Zip(newarg1, newarg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x*y, array.asInstanceOf[ArrayPairs]))
              array
            case (_, _) => (eval(newarg1) * (eval(newarg2)))
          }
      }
        else

        (arg1, arg2) match {
          case (DoubleLiteral(arg1),DoubleLiteral(arg2)) => DoubleLiteral(arg1 * arg2)
          case (_:Array, _:Array) =>
            var array: Expr = eval(Zip(arg1, arg2))
            var x = Param("x")
            var y = Param("y")
            array = eval(Map(Pair(x, y), x*y, array.asInstanceOf[ArrayPairs]))
            array
          case (_:Array, _:Param) =>
            var array: Expr = eval(Zip(arg1, arg2))
            var x = Param("x")
            var y = Param("y")
            array = eval(Map(Pair(x, y), x*y, array.asInstanceOf[ArrayPairs]))
            array
          case (_:Array, _:DoubleLiteral) =>
            var array: Expr = eval(Zip(arg1, arg2))
            var x = Param("x")
            var y = Param("y")
            array = eval(Map(Pair(x, y), x*y, array.asInstanceOf[ArrayPairs]))
            array
          case (_:Param, _:Array) =>
            var array: Expr = eval(Zip(arg1, arg2))
            var x = Param("x")
            var y = Param("y")
            array = eval(Map(Pair(x, y), x*y, array.asInstanceOf[ArrayPairs]))
            array
          case (_:DoubleLiteral, _:Array) =>
            var array: Expr = eval(Zip(arg1, arg2))
            var x = Param("x")
            var y = Param("y")
            array = eval(Map(Pair(x, y), x*y, array.asInstanceOf[ArrayPairs]))
            array
          case (arg1: Param, _) => arg1 * arg2
          case (_, arg2: Param) => arg1 * arg2
          case (_, _) => (eval(arg1) * (eval(arg2)))
        }
      }

      case FunctionCall(FunctionCall(_:DivideDouble, arg2),arg1) => {
        (arg1, arg2) match {
          case (arg1: Param, _) => arg1 / arg2
          case (_, arg2: Param) => arg1 / arg2
          case (DoubleLiteral(arg1),DoubleLiteral(arg2)) => {
            DoubleLiteral(arg1/arg2)
          }
          case (_, _) => ((eval(arg1)) / (eval(arg2)))
        }}

      case FunctionCall(FunctionCall(_:PowerDouble, arg1),arg2) => {
        (arg1, arg2) match {
          case (arg1: Param, _) => arg1 ^ arg2
          case (_, arg2: Param) => arg1 ^ arg2
          case (DoubleLiteral(arg1),DoubleLiteral(arg2)) => {
            val exponent  = java.lang.Double.valueOf(arg2)
            val base      = java.lang.Double.valueOf(arg1)
            DoubleLiteral(scala.math.pow(base,exponent))
          }
          case (_, _) => {
            val exponent  = java.lang.Double.valueOf(eval(arg2).toString)
            val base      = java.lang.Double.valueOf(eval(arg1).toString)
            ((eval(arg1)^eval(arg2)))
          }

        }
      }

      case Map(param, body, vector) => vector match {
        case vector: Array =>
          var array: Seq[Expr] = Seq()
          for (z <- vector.asInstanceOf[Array].list) {
            array = array :+ (eval(FunctionCall((Lambda(param, body.asInstanceOf[Expr])), z)))
          }
          return Array(array, vector.t)

        case vector: ArrayPairs =>
          var array: Seq[Expr] = Seq()
          for (z <- vector.asInstanceOf[ArrayPairs].a) {
            array = array :+ (eval(FunctionCall((Lambda(param, body.asInstanceOf[Expr])), z)))
          }
          return Array(array, vector.t)
      }


//        def foldLeft(list: Seq[Expr], z: Expr): Expr = {
//          list match {
//            case Nil => DoubleLiteral(1)
//            case head :: tail => FunctionCall(FunctionCall(MultiplyDouble(foldLeft(tail, head)), foldLeft(tail, head)), head)
//          }
//          z

      case Fold( body, initial, vector) =>
        vector.a match {
          case Nil => initial
          case head :: tail =>
            body match {
              case FunctionCall(FunctionCall(_:MultiplyDouble, arg2),arg1) => eval(FunctionCall(FunctionCall(MultiplyDouble(Fold(body, initial, Array(tail, vector.t))), Fold(body, initial, Array(tail, vector.t))), head))
              case FunctionCall(FunctionCall(_:AddDouble, arg2),arg1) => eval(FunctionCall(FunctionCall(AddDouble(eval(Fold(body, initial, Array(tail, vector.t)))), eval(Fold(body, initial, Array(tail, vector.t)))), head))
                //FunctionCall(FunctionCall(MultiplyDouble(Fold(param, body, head, Array(tail, vector.t))), Fold(param, body, head, Array(tail, vector.t)), head))
            }
        }

      case Zip(arg1, arg2) =>
        (arg1, arg2) match {
          case(_:Param, _:Param) => Pair(arg1, arg2)

          case (_:Param, _: Array) =>
            var array : Seq[Pair] = Seq()
            for (z <- arg2.asInstanceOf[Array].list) {
              array = array:+(Pair(arg1, z))
            }
            ArrayPairs(array, arg2.asInstanceOf[Array].t)

          case (_:Array, _:DoubleLiteral) =>
            var array : Seq[Pair] = Seq()
            for (z <- arg1.asInstanceOf[Array].list) {
              array = array:+(Pair(z, arg2))
            }
            ArrayPairs(array, arg1.asInstanceOf[Array].t)

          case (_:DoubleLiteral, _: Array) =>
            var array : Seq[Pair] = Seq()
            for (z <- arg2.asInstanceOf[Array].list) {
              array = array:+(Pair(arg1, z))
            }
            ArrayPairs(array, arg2.asInstanceOf[Array].t)

          case (_:Array, _:Param) =>
            var array : Seq[Pair] = Seq()
            for (z <- arg1.asInstanceOf[Array].list) {
              array = array:+(Pair(z, arg2))
            }
            ArrayPairs(array, arg1.asInstanceOf[Array].t)

          case(_: Array, _: Array) =>
            var array : Seq[Pair] = Seq()
            for (x <- arg1.asInstanceOf[Array].list zip arg2.asInstanceOf[Array].list) {
              array = array:+(Pair(x._1, x._2))
            }
           ArrayPairs(array, arg1.asInstanceOf[Array].t)

          case(_, _) => Pair(arg1, arg2)
        }

      case DotProduct(array1, array2) =>
        var array: Expr = eval(Zip(array1, array2))
        var x = Param("x")
        var y = Param("y")
        array = eval(Map(Pair(x, y), x*y, array.asInstanceOf[ArrayPairs]))
        eval(Fold(x+x, intermediateRep.DoubleLiteral(0), array.asInstanceOf[Array]))

      case FunctionCall(Lambda(param,body),arg) =>
        // store in a map   param -> arg and eval body
        (param, arg) match {
        case (_:Pair, _: Pair) =>
          paramToArg.put (param.asInstanceOf[Pair].first, arg.asInstanceOf[Pair].first )
          paramToArg.put (param.asInstanceOf[Pair].second, arg.asInstanceOf[Pair].second)
          eval (body, paramToArg)
        case (_,_) =>
          paramToArg.put (param, arg.asInstanceOf[Expr] )
        eval (body, paramToArg)
    }

      case p:Param =>
        // fish it up from the map and eval the expr
        if (paramToArg.contains(p)){
          eval(paramToArg(p))
        }
        else{
          p
        }

      case p: Matrix => p
    }
  }

  def deEval() : mutable.HashMap[Expr, Expr] = {
    val argToParam = mutable.HashMap[Expr,Expr]()
  //  e match {
   //   case FunctionCall(FunctionCall(_: AddDouble, arg2), arg1) => {
        for ((k, v) <- paramToArg) argToParam.put(v, k)
        argToParam
      }
}