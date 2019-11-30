package differentiate

import intermediateRep._

object Differentiate {
  def differentiate(e:Expr, p: Param) : Expr = {
    e.t match {
      case _:DoubleType.type => DifferentiateDouble.differentiate(e, p)
      case _:FunctionType => DifferentiateDouble.differentiate(e, p)
    }
  }
}