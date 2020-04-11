package eval

import eval.DoubleEvaluator.eval
import intermediateRep._

import scala.collection.mutable
import scala.language.implicitConversions

//TODO: Test multiplication
object ArraysEvaluator {
  val paramToArg = mutable.HashMap[Expr, Expr]()

  def eval(e: Expr, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr= { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case Vector(a, b) => Vector(a, b)
      case Vector(a, b) => Vector(a, b)
      case VectorAccess(a, b) => a.a(b.asInstanceOf[Int])
    }
  }
}