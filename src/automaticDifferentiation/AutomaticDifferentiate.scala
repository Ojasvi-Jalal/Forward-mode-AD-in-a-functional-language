package automaticDifferentiation

import intermediateRep._

object AutomaticDifferentiate {
  def autodifferentiate(e:Expr, p: Expr) : Expr = {
    e.t match {
      case _:DoubleType.type => AutomaticDifferentiateExpr.autoDifferentiate(e, p)
      //case _:FunctionType => PrimalTrace2.autoDifferentiate(e, p)
      case _ => AutomaticDifferentiateExpr.autoDifferentiate(e, p)
    }
  }
}