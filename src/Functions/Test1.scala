package Functions
import Functions.{AddDouble, Expr, DoubleLiteral, DoubleType}

  object Test1 extends App{
      val var1 = DoubleLiteral(3)
      val var2 = DoubleLiteral(4)
      val sum  =  var1 + var2 //ExprFunctions.+(var1,var2)
      val product = ExprFunctions.*(var1,var2)
      val division = ExprFunctions./(var1,var2)
      val power = ExprFunctions.^(var1,var2)
      //println(s"sum of $var1 and $var2 = $sum")
      println("var1 = "+ Evaluator.eval(var1))
      println("var2 = "+ Evaluator.eval(var2))
      println("sum = "+Evaluator.eval(sum))
      println("product = "+Evaluator.eval(product))
      println("division = "+Evaluator.eval(division))
      println("power = "+Evaluator.eval(power))
      println(TypeChecker.typeCheck(var1))
      println(TypeChecker.typeCheck(var2))
      println(TypeChecker.typeCheck(sum))
      println(TypeChecker.typeCheck(product))


  }

