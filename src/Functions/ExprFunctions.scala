package Functions
//import Functions.IR.AddFloat
import Functions.{AddFloat, Expr, FunctionCall}

//make a static cclass in scala
object ExprFunctions {
  def +(e1: Expr, e2: Expr): Expr = FunctionCall(FunctionCall(AddFloat(FloatLiteral(e1.asInstanceOf[FloatLiteral].f)).asInstanceOf[Expr], e1), e2)
  def *(e1: Expr, e2: Expr): Expr = FunctionCall(FunctionCall(MultiplyFloat(FloatLiteral(e1.asInstanceOf[FloatLiteral].f)).asInstanceOf[Expr], e1), e2)
  def /(e1: Expr, e2: Expr): Expr = FunctionCall(FunctionCall(DivideFloat(FloatLiteral(e1.asInstanceOf[FloatLiteral].f)).asInstanceOf[Expr], e1), e2)
  def ^(e1: Expr, e2: Expr): Expr = FunctionCall(FunctionCall(PowerFloat(FloatLiteral(e1.asInstanceOf[FloatLiteral].f)).asInstanceOf[Expr], e1), e2)
  def $(f: Function, arg: Expr): Expr = FunctionCall(f, arg) // func $ arg
  // implicit  e.g. : FloatLiteral(2) + FloatLiteral(3.0f)    /// 2 + 3.0f
  // later can write implicit conversions
}



