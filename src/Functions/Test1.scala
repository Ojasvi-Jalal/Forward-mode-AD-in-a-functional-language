package Functions
import Functions.{AddFloat, Expr, FloatLiteral, FloatType}

  object Test1 extends App{
      val var1 = FloatLiteral(3)
      val var2 = FloatLiteral(4)
      val ans  =  ExprFunctions.+(var1.asInstanceOf[Expr],var2.asInstanceOf[Expr])

      println(ans)
      println(Evaluator.eval(ans))
  }

