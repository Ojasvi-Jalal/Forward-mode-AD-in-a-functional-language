package Functions

object Evaluator {
  def eval(e:Expr) : Any = {
    e.t match {
      case _:FloatType => FloatEvaluator.eval(e)
      case _:FunctionType => FloatEvaluator.eval(e)
    }
  }
}