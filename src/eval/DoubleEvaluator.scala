package eval

import intermediateRep._

import scala.collection.mutable
import scala.language.implicitConversions

//TODO: Test multiplication
object DoubleEvaluator {
  val paramToArg = mutable.HashMap[Expr, Expr]()

  def eval(e: Expr, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr = { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case DoubleLiteral(d) => DoubleLiteral(d)
      case IntLiteral(d) => IntLiteral(d)
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
        else
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
            case (scalar: Param, _: VectorVar) =>
              var y = Param("y")
              var array = eval(Map(y, scalar * y, newarg2.asInstanceOf[VectorVar]))
              array

            case (_: VectorVar, scalar: Param) =>
              var y = Param("y")
              var array = eval(Map(y, scalar * y, newarg1.asInstanceOf[VectorVar]))
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
            case (scalar: Param, vector: VectorVar) =>
              var i = Param("i")
              //              var array = eval(Map(y, scalar * y, arg2.asInstanceOf[VectorVar]))
              //              array
              Map(i, scalar * VectorVarAccess(vector, i), Sequence((0 to vector.len - 1).toList))

            case (vector: VectorVar, scalar: Param) =>
              var i = Param("i")
              // var array = eval(Map(y, scalar * y, arg1.asInstanceOf[VectorVar]))
              eval(Map(i, scalar * VectorVarAccess(vector, i), Sequence((0 to vector.len - 1).toList)))

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

      case Map(param, body, vector) => (body, vector) match {

        case (v: EqualTo, vector: Vector) =>
          v match {
            case EqualTo(a, b) => {
              var array: Seq[Expr] = Seq()
              for (z <- vector.list) {
                array = array :+ eval(EqualTo(a, z))
              }
              paramToArg.clear()
              return (Vector(array, vector.t))
            }
          }

        case (_, vector: Sequence) =>
          var result_matrix: Seq[Seq[Expr]] = Seq()
          for(i<-vector.list){
            var small_array: Seq[Expr] = Seq()
            for(j<-vector.list){
              small_array = small_array :+ eval(eval(If_Else(EqualTo(IntLiteral(i),IntLiteral(j)),IntLiteral(1),IntLiteral(0))))
            }
            result_matrix = result_matrix :+ small_array
          }
          Matrix(result_matrix, vector.t)






//          var newV = paramToArg.values.head
//          if (paramToArg.contains(v)) {
//            newV = paramToArg(v)
//          }
//
//          var array: Seq[Expr] = Seq()
//          for (z <- vector.list) {
//            array = array :+ eval(EqualTo(v, z))
//          }
//          paramToArg.clear()
//          return eval(Vector(array, vector.t))

        case (_, vector: VectorPairs) =>
          var array: Seq[Expr] = Seq()
          for (z <- vector.asInstanceOf[VectorPairs].a) {
            array = array :+ (eval(FunctionCall((Lambda(param, body.asInstanceOf[Expr])), z)))
          }
          return Vector(array, vector.t)

        case (_, vector: Sequence) =>
          var array: Seq[Expr] = Seq()
          for (z <- vector.list) {
            array = array :+ (eval(FunctionCall((Lambda(param, body.asInstanceOf[Expr])), IntLiteral(z))))
          }
          return Vector(array, vector.t)

        case (vector1: Vector, vector2: Vector) =>
          var array: Seq[Expr] = Seq()
          for (x <- (0 to vector1.list.length-1).toList) {
              array = array :+ (eval(VectorAccess(vector2,x)))
          }
          return Vector(array, vector.t)

        case (_, vector: Vector) =>
          var array: Seq[Expr] = Seq()
          for (z <- vector.asInstanceOf[Vector].list) {
            array = array :+ (eval(FunctionCall((Lambda(param, body.asInstanceOf[Expr])), z)))
          }
          return Vector(array, vector.t)

    }

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
          val newarg2 = if (hm.contains(arg2)) eval(hm(eval(arg2))) else arg2
          eval(GreaterThan(newarg1, newarg2))
        }
        else {
          GreaterThan(arg1, arg2)
        }
      }

      case If_Else(expr, stmt1, stmt2) =>
      expr match{
       case GreaterThan(arg1,arg2) =>
          if (!hm.isEmpty) {
            val newarg1 = if (hm.contains(arg1)) hm(arg1) else arg1
            val newarg2 = if (hm.contains(arg2)) eval(hm(arg2)) else arg2
            eval(GreaterThan(newarg1, eval(newarg2,paramToArg)))
          }
          eval(expr)
        case GreaterThan(_, _) => eval(expr)
//        case GreaterThan(_, _) =>
//          //                (access,drop) match {
//          //                    case (VectorAccess(vec,i), Drop(vec,i)) =>
//          //                        var newV = vector
//          //                        if(hm.contains(vec)){
//          //                           newV = hm(vec).asInstanceOf[Vector]
//          //                        }
//          var newV = (paramToArg.values.head.asInstanceOf[Sequence])
//
//          var array: Seq[Expr] = Seq()
//          for(i <- (0 to newV.list.length).toList) {
//            array = array :+ eval(EqualTo(MaxVec(newV),IntLiteral(i)))
//            // array = array :+ eval(If_Else(GreaterThan(VectorSequenceAccess(newV,i),eval(MaxVec(eval(Drop(newV,IntLiteral(i))).asInstanceOf[Sequence]))), DoubleLiteral(0),DoubleLiteral(1)))
//          }
//          Vector(array, newV.t)


      case EqualTo(arg1,arg2) =>
        if(arg1.asInstanceOf[IntLiteral].d == arg1.asInstanceOf[IntLiteral].d)
          stmt1
        else
          stmt2

        case _ =>
          if (expr.asInstanceOf[Bool].d == true)
            stmt1
          else
            stmt2
      }

      case FunctionCall(Lambda(param, body), arg) =>
        // store in a map   param -> arg and eval body

            (param, body, arg) match {
              case (elem:Vector,input:Vector,value:Vector) => {
                paramToArg.put(Param("x_0"),DoubleLiteral(0))
                paramToArg.put(Param("x_1"),DoubleLiteral(1))
                paramToArg.put(Param("x_2"),DoubleLiteral(2))
                var array: Seq[Expr] = Seq()
                for (z <- value.list) {
                    array = array :+ eval(z,paramToArg)
                  }
                  paramToArg.clear()
                  Vector(array,Param("x_0").t)
                }
              case (_: Pair, _,  _: Pair) =>
                paramToArg.put(param.asInstanceOf[Pair].first, arg.asInstanceOf[Pair].first)
                paramToArg.put(param.asInstanceOf[Pair].second, arg.asInstanceOf[Pair].second)
                var z = eval(body, paramToArg)
                paramToArg.clear()
                z
              case(_, MaxVar(vectorVar), _) =>
                eval(arg,paramToArg)
//                var x = Param("x")
//                var y = Param("y")
//                var listNew = (paramToArg.values.head.asInstanceOf[Vector])
//                //var listNew = (paramToArg.values.head.asInstanceOf[Sequence])
//                var max = eval(Fold(GreaterThan(x,y), (listNew.list.head), listNew))
//               // var max = (listNew.list.max)
//                var i = Param("i")
//                eval(Map(i,EqualTo(max,i), listNew ))
//
//                var array: Seq[Expr] = Seq()
//                for (z <- listNew.list) {
//                  array = array :+ eval(EqualTo(max, z))
//                }
//                paramToArg.clear()
//                Vector(array,listNew.t)
              //case(_, DotProduct(_:VectorVar,_:VectorVar), _) => eval(arg)
              case(_,body,vector:Vector) =>
//                body match{
                  paramToArg.put(param, vector)
                   eval(body,paramToArg)
               // }
              case(_,body:VectorVar,_) =>
                //                body match{
                //paramToArg.put(param, vector)
                eval(arg,paramToArg)
              case (_,_, _) =>
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
      case a: Vector => if(hm.contains(a)){
        var temp = hm(a)
        var result :Seq[Seq[Expr]] = Seq()
        for (ely <- temp.asInstanceOf[Matrix].a) {
            var small_array: Seq[Expr] = Seq()
            for (x <- ely.asInstanceOf[Seq[Expr]]) {
              small_array = small_array :+ x
            }
          result = result :+ small_array
          }
        Matrix(result, a.t)
      }
        else
        a
      case a: Sequence => a
      case a: VectorVar =>
        if (paramToArg.contains(a)) {
          eval(paramToArg(a))
        }
        else {
          a
        }
      case Drop(vector, index) =>
      vector match {
        case _:VectorVar =>
          index  match {
            case index: IntLiteral => VectorVar(vector.asInstanceOf[VectorVar].a, vector.asInstanceOf[VectorVar].len - 1)
            case _ => Drop(vector, index)
          }

        case _:Vector =>
          var array: Seq[Expr] = Seq()
          for(x <- (0 to vector.asInstanceOf[Vector].list.length).toList){
            if(x != index.asInstanceOf[IntLiteral].d){
              array = array :+ VectorAccess(vector.asInstanceOf[Vector],x)
            }
          }
          Vector(array, vector.t)

//        case seq:Sequence =>
//          var newS:Seq[Expr] = Seq()
//          for(x<-(0 to seq.list.length-1).toList){
//            if(x != index){
//              newS = newS :+ VectorSequenceAccess(seq,x)
//            }
//          }
//

      }

      case MaxVar(vectorVar) =>
        var i = Param("i")
        if(paramToArg.contains(e))
          eval(paramToArg(e))
        MaxVar(vectorVar)

      case VectorAccess(vector: Vector,index:Int) => vector.a(index)
      case VectorSequenceAccess(vector: Sequence,index:Int) => IntLiteral(vector.list(index))
      case MaxVec(v) =>
//        var max = 0
//        for(x <- v.list){
//          if(x > max){
//            max = x
//          }
//        }
//        IntLiteral(max)
        IntLiteral(v.list.max)

      case EqualTo(arg1,arg2) =>
        if(arg1.asInstanceOf[DoubleLiteral].d == arg2.asInstanceOf[DoubleLiteral].d)
          return IntLiteral(1)
        else
          return IntLiteral(0)
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