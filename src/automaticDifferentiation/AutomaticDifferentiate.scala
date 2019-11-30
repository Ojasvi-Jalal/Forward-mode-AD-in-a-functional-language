package automaticDifferentiation

import intermediateRep._

object AutomaticDifferentiate {
  def differentiate(e:Expr, p: Param) : Expr = {
    e.t match {
      case _:DoubleType.type => AutomaticDifferentiateExpr.differentiate(e, p)
      case _:FunctionType => AutomaticDifferentiateExpr.differentiate(e, p)
    }
  }
}