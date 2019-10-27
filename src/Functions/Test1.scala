package Functions
import Functions.{AddFloat, Expr, FloatLiteral, FloatType}

  object Test1 extends App{
      val var1 = FloatLiteral(3)
      val var2 = FloatLiteral(4)
      val sum  =  ExprFunctions.+(var1.asInstanceOf[Expr],var2.asInstanceOf[Expr])
      val product = ExprFunctions.*(var1.asInstanceOf[Expr],var2.asInstanceOf[Expr])
      //println(s"sum of $var1 and $var2 = $sum")
      println("var1 = "+ Evaluator.eval(var1))
      println("var2 = "+ Evaluator.eval(var2))
      println("sum = "+Evaluator.eval(sum))
      println("product = "+Evaluator.eval(product))
      println(TypeChecker.typeCheck(var1))
      println(TypeChecker.typeCheck(var2))
      println(TypeChecker.typeCheck(sum))
  }

