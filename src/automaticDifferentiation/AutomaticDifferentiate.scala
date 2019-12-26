package automaticDifferentiation

import intermediateRep._

object AutomaticDifferentiate {
  def autodifferentiate(e:Expr, p: Param) : Expr = {
    e.t match {
      case _:DoubleType.type => AutomaticDifferentiateExpr.autoDifferentiate(e, p)
      case _:FunctionType => AutomaticDifferentiateExpr.autoDifferentiate(e, p)
    }
  }
}