package object functions {
  //make a static cclass in scala
  object Functions {
    def +(e1: Expr, e2: Expr): Expr = FunctionCall(FunctionCall(AddFloat.asInstanceOf[Expr], e1), e2)

    def $(f: Expr, arg: Expr): Expr = FunctionCall(f, arg) // func $ arg
    // implicit  e.g. : FloatLiteral(2) + FloatLiteral(3.0f)    /// 2 + 3.0f
    // later can write implicit conversions
  }
}


