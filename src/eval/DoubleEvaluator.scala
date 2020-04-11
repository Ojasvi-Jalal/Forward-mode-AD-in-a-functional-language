package eval

import automaticDifferentiation.DerivativeTrace.{derivativeTrace, paramToArg}
import intermediateRep._

import scala.collection.mutable
import scala.language.implicitConversions

//TODO: Test multiplication
object DoubleEvaluator {
  val paramToArg = mutable.HashMap[Expr, Expr]()

  def eval(e: Expr, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case DoubleLiteral(d) => DoubleLiteral(d)
      case Pair(x, y) => Pair(x, y)
      //case Array(a,b) => a
      case FunctionCall(FunctionCall(_: AddDouble, arg2), arg1) => {
        if (!hm.isEmpty) {
          val newarg1 = if (hm.contains(arg1)) hm(arg1) else arg1
          val newarg2 = if (hm.contains(arg2)) eval(hm(arg2)) else arg2
          (newarg1, newarg2) match {
            case (arg1: Param, _) => newarg1 + newarg2 // fix this
            case (_, arg2: Param) => newarg1 + newarg2
            case (DoubleLiteral(newarg1), DoubleLiteral(newarg2)) => DoubleLiteral(newarg1 + newarg2)
            case (_: Vector, _: Vector) =>
              var array: Expr = eval(Zip(newarg1, newarg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x + y, array.asInstanceOf[VectorPairs]))
              array
            case (_, _) => (eval(newarg1) + (eval(newarg2)))
          }
        }
        else {
          (arg1, arg2) match {
            case (arg1: Param, _) => arg1 + arg2
            case (_, arg2: Param) => arg1 + arg2
            case (DoubleLiteral(arg1), DoubleLiteral(arg2)) => DoubleLiteral(arg1 + arg2)
            case (_: Vector, _: Param) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x + y, array.asInstanceOf[VectorPairs]))
              array
            case (_: Vector, _: DoubleLiteral) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x + y, array.asInstanceOf[VectorPairs]))
              array
            case (_: Param, _: Vector) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x + y, array.asInstanceOf[VectorPairs]))
              array
            case (_: DoubleLiteral, _: Vector) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x + y, array.asInstanceOf[VectorPairs]))
              array
            case (_: Vector, _: Vector) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x + y, array.asInstanceOf[VectorPairs]))
              array
            case (_, _) => (eval(arg1) + (eval(arg2)))
          }
        }
      }

      case FunctionCall(FunctionCall(_: MultiplyDouble, arg2), arg1) => {
        if (!hm.isEmpty) {
          val newarg1 = if (hm.contains(arg1)) hm(arg1) else arg1
          val newarg2 = if (hm.contains(arg2)) eval(hm(arg2)) else arg2
          (newarg1, newarg2) match {
            case (arg1: Param, _) => newarg1 * newarg2 // fix this
            case (_, arg2: Param) => newarg1 * newarg2
            case (DoubleLiteral(newarg1), DoubleLiteral(newarg2)) => DoubleLiteral(newarg1 * newarg2)
            case (_: Vector, _: Vector) =>
              var array: Expr = eval(Zip(newarg1, newarg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x * y, array.asInstanceOf[VectorPairs]))
              array
            case (_: Vector, _: Param) =>
              var array: Expr = eval(Zip(newarg1, newarg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x * y, array.asInstanceOf[VectorPairs]))
              array
            case (_: Vector, _: DoubleLiteral) =>
              var array: Expr = eval(Zip(newarg1, newarg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x * y, array.asInstanceOf[VectorPairs]))
              array
            case (_: Param, _: Vector) =>
              var array: Expr = eval(Zip(newarg1, newarg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x * y, array.asInstanceOf[VectorPairs]))
              array
            case (_: DoubleLiteral, _: Vector) =>
              var array: Expr = eval(Zip(newarg1, newarg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x * y, array.asInstanceOf[VectorPairs]))
              array
            case (_, _) => (eval(newarg1) * (eval(newarg2)))
          }
        }
        else

          (arg1, arg2) match {
            case (DoubleLiteral(arg1), DoubleLiteral(arg2)) => DoubleLiteral(arg1 * arg2)
            case (_: Vector, _: Vector) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x * y, array.asInstanceOf[VectorPairs]))
              array
            case (_: Vector, _: Param) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x * y, array.asInstanceOf[VectorPairs]))
              array
            case (_: Vector, _: DoubleLiteral) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x * y, array.asInstanceOf[VectorPairs]))
              array
            case (_: Param, _: Vector) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x * y, array.asInstanceOf[VectorPairs]))
              array
            case (_: DoubleLiteral, _: Vector) =>
              var array: Expr = eval(Zip(arg1, arg2))
              var x = Param("x")
              var y = Param("y")
              array = eval(Map(Pair(x, y), x * y, array.asInstanceOf[VectorPairs]))
              array
            case (arg1: Param, _) => arg1 * arg2
            case (_, arg2: Param) => arg1 * arg2
            case (_, _) => (eval(arg1) * (eval(arg2)))
          }
      }

      case FunctionCall(FunctionCall(_: DivideDouble, arg2), arg1) => {
        (arg1, arg2) match {
          case (arg1: Param, _) => arg1 / arg2
          case (_, arg2: Param) => arg1 / arg2
          case (DoubleLiteral(arg1), DoubleLiteral(arg2)) => {
            DoubleLiteral(arg1 / arg2)
          }
          case (_, _) => ((eval(arg1)) / (eval(arg2)))
        }
      }

      case FunctionCall(FunctionCall(_: PowerDouble, arg1), arg2) => {
        (arg1, arg2) match {
          case (arg1: Param, _) => arg1 ^ arg2
          case (_, arg2: Param) => arg1 ^ arg2
          case (DoubleLiteral(arg1), DoubleLiteral(arg2)) => {
            val exponent = java.lang.Double.valueOf(arg2)
            val base = java.lang.Double.valueOf(arg1)
            DoubleLiteral(scala.math.pow(base, exponent))
          }
          case (_, _) => {
            val exponent = java.lang.Double.valueOf(eval(arg2).toString)
            val base = java.lang.Double.valueOf(eval(arg1).toString)
            ((eval(arg1) ^ eval(arg2)))
          }

        }
      }

      case Map(param, body, vector) => vector match {
        case vector: Vector =>
          var array: Seq[Expr] = Seq()
          for (z <- vector.asInstanceOf[Vector].list) {
            array = array :+ (eval(FunctionCall((Lambda(param, body.asInstanceOf[Expr])), z)))
          }
          return Vector(array, vector.t)

        case vector: VectorPairs =>
          var array: Seq[Expr] = Seq()
          for (z <- vector.asInstanceOf[VectorPairs].a) {
            array = array :+ (eval(FunctionCall((Lambda(param, body.asInstanceOf[Expr])), z)))
          }
          return Vector(array, vector.t)
      }


      //        def foldLeft(list: Seq[Expr], z: Expr): Expr = {
      //          list match {
      //            case Nil => DoubleLiteral(1)
      //            case head :: tail => FunctionCall(FunctionCall(MultiplyDouble(foldLeft(tail, head)), foldLeft(tail, head)), head)
      //          }
      //          z

      case Fold(body, initial, vector) =>
        vector.a match {
          case Nil => initial
          case head :: tail =>
            body match {
              case FunctionCall(FunctionCall(_: MultiplyDouble, arg2), arg1) => eval(FunctionCall(FunctionCall(MultiplyDouble(Fold(body, initial, Vector(tail, vector.t))), Fold(body, initial, Vector(tail, vector.t))), head))
              case FunctionCall(FunctionCall(_: AddDouble, arg2), arg1) => eval(FunctionCall(FunctionCall(AddDouble((Fold(body, initial, Vector(tail, vector.t)))), (Fold(body, initial, Vector(tail, vector.t)))), head))
              case GreaterThan(arg1, arg2) =>
                //tail match {
                //
                //                case Nil => initial
                //                case head :: tail =>
                eval(Max(head, eval(Fold(body, head, Vector(tail, vector.t)))))
              // }
              //FunctionCall(FunctionCall(MultiplyDouble(Fold(param, body, head, Array(tail, vector.t))), Fold(param, body, head, Array(tail, vector.t)), head))
            }
        }

      case Zip(arg1, arg2) =>
        (arg1, arg2) match {
          case (_: Param, _: Param) => Pair(arg1, arg2)

          case (_: Param, _: Vector) =>
            var array: Seq[Pair] = Seq()
            for (z <- arg2.asInstanceOf[Vector].list) {
              array = array :+ (Pair(arg1, z))
            }
            VectorPairs(array, arg2.asInstanceOf[Vector].t)

          case (_: Vector, _: DoubleLiteral) =>
            var array: Seq[Pair] = Seq()
            for (z <- arg1.asInstanceOf[Vector].list) {
              array = array :+ (Pair(z, arg2))
            }
            VectorPairs(array, arg1.asInstanceOf[Vector].t)

          case (_: DoubleLiteral, _: Vector) =>
            var array: Seq[Pair] = Seq()
            for (z <- arg2.asInstanceOf[Vector].list) {
              array = array :+ (Pair(arg1, z))
            }
            VectorPairs(array, arg2.asInstanceOf[Vector].t)

          case (_: Vector, _: Param) =>
            var array: Seq[Pair] = Seq()
            for (z <- arg1.asInstanceOf[Vector].list) {
              array = array :+ (Pair(z, arg2))
            }
            VectorPairs(array, arg1.asInstanceOf[Vector].t)

          case (_: Vector, _: Vector) =>
            var array: Seq[Pair] = Seq()
            for (x <- arg1.asInstanceOf[Vector].list zip arg2.asInstanceOf[Vector].list) {
              array = array :+ (Pair(x._1, x._2))
            }
            VectorPairs(array, arg1.asInstanceOf[Vector].t)

          case (_, _) => Pair(arg1, arg2)
        }

      case DotProduct(array1, array2) =>
        var array: Expr = eval(Zip(array1, array2))
        var x = Param("x")
        var y = Param("y")
        array = eval(Map(Pair(x, y), x * y, array.asInstanceOf[VectorPairs]))
        eval(Fold(x + x, intermediateRep.DoubleLiteral(0), array.asInstanceOf[Vector]))

      case Max(arg1, arg2) => (arg1, arg2) match {
        case (_: DoubleLiteral, _: DoubleLiteral) => eval(If_Else(eval(GreaterThan(arg1, arg2)), arg1, arg2))
        case (_, _) => (If_Else(eval(GreaterThan(arg1, arg2)), arg1, arg2))
      }

      case GreaterThan(arg1, arg2) => (arg1, arg2) match {
        case (_: DoubleLiteral, _: DoubleLiteral) => Bool(arg1.asInstanceOf[DoubleLiteral].d > arg2.asInstanceOf[DoubleLiteral].d)
        case (_, _) => if (!hm.isEmpty) {
          val newarg1 = if (hm.contains(arg1)) hm(arg1) else arg1
          val newarg2 = if (hm.contains(arg2)) eval(hm(arg2)) else arg2
          eval(GreaterThan(newarg1, newarg2))
        }
        else {
          GreaterThan(arg1, arg2)
        }
      }

      case If_Else(expr, stmt1, stmt2) =>
        if (expr.asInstanceOf[Bool].d == true)
          stmt1
        else
          stmt2

      case FunctionCall(Lambda(param, body), arg) =>
        // store in a map   param -> arg and eval body
        (param, arg) match {
          case (_: Pair, _: Pair) =>
            paramToArg.put(param.asInstanceOf[Pair].first, arg.asInstanceOf[Pair].first)
            paramToArg.put(param.asInstanceOf[Pair].second, arg.asInstanceOf[Pair].second)
            var z = eval(body, paramToArg)
            paramToArg.clear()
            z
          case (_, _) =>
            paramToArg.put(param, arg.asInstanceOf[Expr])
            var z = eval(body, paramToArg)
            paramToArg.clear()
            z
        }

      case p: Param =>
        // fish it up from the map and eval the expr
        if (paramToArg.contains(p)) {
          eval(paramToArg(p))
        }
        else {
          p
        }
      case p: Matrix => p
      case a: Vector => a
      case Drop(vector, index) => VectorVar(vector.a, vector.len - 1)
      //      case MaxVar(vectorVar) =>
      //        Fold(Max(VectorAccess(vectorVar,i)), Sequence((0 to vectorVar.len-1).toList), vector ))
      //
    }
  }

  def deEval(): mutable.HashMap[Expr, Expr] = {
    val argToParam = mutable.HashMap[Expr, Expr]()
    //  e match {
    //   case FunctionCall(FunctionCall(_: AddDouble, arg2), arg1) => {
    for ((k, v) <- paramToArg) argToParam.put(v, k)
    argToParam
  }
}