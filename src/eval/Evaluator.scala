package eval

import intermediateRep.{VectorType, DoubleType, Expr, FunctionType}

object Evaluator {
  def eval(e:Expr ) : Expr = {
    e.t match {
      case _:DoubleType.type => DoubleEvaluator.eval(e)
      //case _:ArrayType => ArraysEvaluator.eval(e)
      case _:FunctionType => DoubleEvaluator.eval(e)
    }
  }

  def printString(e:Expr)  : Expr = {
    Print.printString(e)
  }
  def evalArrays(e: Expr) : Expr = {
    e.t match {
      case _:VectorType => ArraysEvaluator.eval(e)
      case _:VectorType => ArraysEvaluator.eval(e)
    }
  }
}