package Functions

object Evaluator {
  def eval(e:Expr) : Any = {
    e.t match {
      case _:DoubleType.type => FloatEvaluator.eval(e)
      case _:FunctionType => FloatEvaluator.eval(e)
    }
  }
}