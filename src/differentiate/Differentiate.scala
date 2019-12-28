package differentiate

import intermediateRep._

object Differentiate {
  def differentiate(e:Expr, p: Param) : Expr = {
    e.t match {
      case _:DoubleType.type => DifferentiateExpr.differentiate(e, p)
      case _:FunctionType => DifferentiateExpr.differentiate(e, p)
    }
  }
}