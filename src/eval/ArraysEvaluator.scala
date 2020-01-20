package eval

import intermediateRep._

import scala.collection.mutable
import scala.language.implicitConversions

//TODO: Test multiplication
object ArraysEvaluator {
  val paramToArg = mutable.HashMap[Expr, Expr]()

  def eval(e: Expr, hm: mutable.HashMap[Expr, Expr] = mutable.HashMap[Expr, Expr]()): Expr= { //passing down vthe imformation -> I can start having variables //hm goes from var to a float
    e match {
      case Array(a, b) => Array(a, b)
      //case ArrayAccess(a, d) => a(d)
    }
  }
}