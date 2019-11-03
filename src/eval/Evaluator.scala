package eval

import intermediateRep.{Expr, DoubleType, FunctionType}

object Evaluator {
  def eval(e:Expr) : Any = {
    e.t match {
      case _:DoubleType.type => DoubleEvaluator.eval(e)
      case _:FunctionType => DoubleEvaluator.eval(e)
    }
  }
}