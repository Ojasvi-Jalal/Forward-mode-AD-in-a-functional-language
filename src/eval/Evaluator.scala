package eval

import intermediateRep.{ArrayType, DoubleType, Expr, FunctionType, VectorType}

object Evaluator {
  def eval(e:Expr ) : Expr = {
    e.t match {
      case _:DoubleType.type => DoubleEvaluator.eval(e)
      //case _:ArrayType => ArraysEvaluator.eval(e)
      case _:FunctionType => DoubleEvaluator.eval(e)
    }
  }

  def evalArrays(e: Expr) : Expr = {
    e.t match {
      case _:ArrayType => ArraysEvaluator.eval(e)
      case _:VectorType => ArraysEvaluator.eval(e)
    }
  }
}