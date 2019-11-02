//package typeCheck
//
////import main.Functions.IR.AddFloat
//import main.Functions.{AddDouble, Expr, FunctionCall}
//
////make a static cclass in scala
//object ExprFunctions {
//  def *(e1: Expr, e2: Expr): Expr = FunctionCall(FunctionCall(MultiplyDouble(DoubleLiteral(e1.asInstanceOf[DoubleLiteral].d)).asInstanceOf[Expr], e1), e2)
//  def /(e1: Expr, e2: Expr): Expr = FunctionCall(FunctionCall(DivideDouble(DoubleLiteral(e1.asInstanceOf[DoubleLiteral].d)).asInstanceOf[Expr], e1), e2)
//  def ^(e1: Expr, e2: Expr): Expr = FunctionCall(FunctionCall(PowerDouble(DoubleLiteral(e1.asInstanceOf[DoubleLiteral].d)).asInstanceOf[Expr], e1), e2)
//  def $(f: Function, arg: Expr): Expr = FunctionCall(f, arg) // func $ arg
//  // implicit  e.g. : FloatLiteral(2) + FloatLiteral(3.0f)    /// 2 + 3.0f
//  // later can write implicit conversions
//}



