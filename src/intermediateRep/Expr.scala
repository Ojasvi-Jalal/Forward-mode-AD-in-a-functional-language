package intermediateRep

/**
  * the root expression
  *                            IR
  *                             |
  *                        Expression
  *                             |
  *    ----------------------------------------
  *    /        |                    \        \
  *   /         |                     \         \
  *  FuncCall   Function               Param     Values
  *           /      \                             \
  *       Anonymous    Built-in                 Double
  *       main.Functions    main.Functions
  *         |        /     \
  *       Lambda     Add    Multiply
  */

trait Expr extends IR {
  var t: Type

  override def build(newChildren: Seq[IR]): Expr

  def +(that: Expr): Expr = FunctionCall(FunctionCall(AddDouble(this), this), that)
  def times2(): Expr = this * IntLiteral(2)
  def *(that: Expr): Expr = FunctionCall(FunctionCall(MultiplyDouble(this), this), that)
  def /(that: Expr): Expr = FunctionCall(FunctionCall(DivideDouble(this), this), that)
  def ^(that: Expr): Expr = FunctionCall(FunctionCall(PowerDouble(this), this), that)
  def $(that: Param): Expr = FunctionCall(Lambda(that, this),DoubleLiteral(1)) // func $ arg// x*2 $ x+2 => (x+2)*2 => 2x+ 4 => 2

  // later: can write implicit conversions
}

case class FunctionCall(f: Expr, arg: Expr) extends Expr {
  override var t: Type = FunctionType(f.t,arg.t)
  var function: Expr = f
  var argument: Expr = arg

  override def build(newChildren: Seq[IR]): Expr = ???

  //override def toString(): String = arg.toString

  override def children: Seq[IR] = Seq(f,arg)
}

trait Function extends Expr {

}

trait AnonymousFunction extends Function {

}


case class Lambda(param: Expr, body: Expr) extends AnonymousFunction {
  override var t: Type = FunctionType(param.t, FunctionType(param.t, param.t))

  override def build(newChildren: Seq[IR]): Lambda = Lambda(newChildren(0).asInstanceOf[Param], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[IR] = Seq(param,body)
}

object Let {
  def apply(param: Expr, value: Expr, body: Expr): Expr = FunctionCall(Lambda(param, body), value)
}

object Map {
  def apply[Expr, Seq[Expr]](f: Expr => Expr, list: Seq[Expr]): Seq[Expr] = {
    for {
      x <- list
    } yield f(x)
  }
}

//case class Map private[algo] (f: Expr, input: Expr, fType: Type, inputType: Type, override val t: Type = AnyTypeVar()) extends Expr {
//  override def children: Seq[IR] = Seq(innerIR, f, input, fType, inputType, t)
//  override val innerIR: Expr = {
//    val indtv = AlgoDataTypeVar()
//    val outdtv = AlgoDataTypeVar()
//    val ftv = FunTypeVar(indtv, outdtv)
//    val atv = ArithTypeVar()
//    val inseqtv = SeqTypeVar(indtv, atv)
//    val outseqt = SeqType(outdtv, atv)
//
//    FunctionCall(TypeFunctionCall(BuiltinTypeFunction(TypeFunType(Seq(ftv, inseqtv), FunType(Seq(ftv, inseqtv), outseqt))), Seq(fType, inputType)), Seq(f, input))
//  }
//  override def build(newChildren: Seq[LiftIR]): Map = new Map(newChildren(1).asInstanceOf[Expr], newChildren(2).asInstanceOf[Expr], newChildren(3).asInstanceOf[Type], newChildren(4).asInstanceOf[Type], newChildren(5).asInstanceOf[Type]) {
//    override val innerIR: Expr = newChildren.head.asInstanceOf[Expr]
//  }
//}
//
//case class Reduce private[algo] (f: Expr, input: Expr, fType: Type, inputType: Type, override val t: Type = AnyTypeVar()) extends AlgoExpr {
//  override def children: Seq[LiftIR] = Seq(innerIR, f, input, fType, inputType, t)
//  override val innerIR: Expr = {
//    val dtv = AlgoDataTypeVar()
//    val ftv = FunTypeVar(TupleTypeVar(Seq(dtv, dtv)), dtv)
//    val inseqtv = SeqTypeVar(dtv, ArithTypeVar())
//    FunctionCall(TypeFunctionCall(BuiltinTypeFunction(TypeFunType(Seq(ftv, inseqtv), FunType(Seq(ftv, inseqtv), dtv))), Seq(fType, inputType)), Seq(f, input))
//  }
//  override def build(newChildren: Seq[LiftIR]): Reduce = new Reduce(newChildren(1).asInstanceOf[Expr], newChildren(2).asInstanceOf[Expr], newChildren(3).asInstanceOf[Type], newChildren(4).asInstanceOf[Type], newChildren(5).asInstanceOf[Type]) {
//    override val innerIR: Expr = newChildren.head.asInstanceOf[Expr]
//  }
//}

//object Iterator {
//  var i = 0
//  def foreach(array: Array, ) = {
//    Let(ArrayAccess.apply())
//  }
//
//  def hasNext() : Boolean = this.hasNext()
//}
//
//class Iterable[T](val node: Array) extends AnyVal {
//  def iterator = Iterator
//    .iterate(Option(node))(_.flatMap(_.next))
//    .takeWhile(_.nonEmpty)
//    .flatten
//    .map(_.value)
//}
//[2,3]
//
//for (int i : arrayOfInt)
//
//For(exp option, exp, exp option, statement) // initial expression, condition, post-expression, body
//| ForDecl(declaration, exp, exp option, statement)

//Evaluate init.
//Evaluate condition.
//If it’s false, jump to step 7.
//Execute statement.
//Execute post-expression.
//Jump to step 2.
//Finish.

//case class For(let:Expr, condition: Expr, postExpr: Expr) extends Expr {
//  override var t: Type = _
//
//  if(Eval(condition))
//
//  override def build(newChildren: Seq[IR]): Expr = ???
//
//  override def children: Seq[IR] = ???
//}

trait BuiltInFunction extends Function {

}

case class AddDouble(x: Expr) extends BuiltInFunction {

  override def build(newChildren: Seq[IR]): Expr = AddDouble(newChildren(0).asInstanceOf[DoubleLiteral])

  override def children: Seq[Expr] = Seq(x)

  override var t: Type = FunctionType(x.t, FunctionType(x.t, x.t))
}


case class MultiplyDouble(x: Expr) extends BuiltInFunction {

  override def build(newChildren: Seq[IR]): MultiplyDouble = MultiplyDouble(newChildren(0).asInstanceOf[DoubleLiteral])

  override def children: Seq[Expr] = Seq(x)

  override var t: Type = FunctionType(x.t, FunctionType(x.t, x.t))
}

case class DivideDouble(x: Expr) extends BuiltInFunction {

  override def build(newChildren: Seq[IR]): DivideDouble = DivideDouble(newChildren(0).asInstanceOf[DoubleLiteral])

  override def children: Seq[Expr] = Seq(x)

  override var t: Type = FunctionType(x.t, FunctionType(x.t, x.t))
}

case class PowerDouble(x: Expr) extends BuiltInFunction {

  override def build(newChildren: Seq[IR]): PowerDouble = PowerDouble(newChildren(0).asInstanceOf[DoubleLiteral])

  override def children: Seq[Expr] = Seq(x)

  override var t: Type = FunctionType(x.t, FunctionType(x.t, x.t))
}

case class Param(x: String) extends Expr {

  override var t: Type = DoubleType

  override def toString(): String = x

  override def build(newChildren: Seq[IR]) = ???

  override def children = Seq()

}

case class Var(x:Param) extends Expr {
  val value : Param = x

  override var t: Type = DoubleType

  override def build(newChildren: Seq[IR]) = Var(x)

  override def children = Seq()

  def ===(that: Var) : Boolean = {
    this.value == that.value
  }

  def >==(that: Var) : Boolean = {
    that.value == this.value
  }

  def <==(that: Var) : Boolean = {
    this.value == that.value
  }
}

trait Values extends Expr {

}

case class DoubleLiteral(d: Double) extends Values{
  override var t: Type = DoubleType

  override def toString(): String = d.toString

  override def build(newChildren: Seq[IR]) = DoubleLiteral(newChildren.head.asInstanceOf[Double])

  override def children = Seq()
}

case class IntLiteral(d: Int) extends Values{
  override var t: Type = IntType

  override def toString(): String = d.toString

  override def build(newChildren: Seq[IR]) = DoubleLiteral(newChildren.head.asInstanceOf[Int])

  override def children = Seq()
}

case class Vector(a: Seq[Expr], et: Type) extends Values{
  override var t: Type = VectorType(et, a.length)

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = Vector(newChildren(0).asInstanceOf[Seq[Expr]], newChildren(1).asInstanceOf[Type])

  override def children = Seq()
//
//  def foreach(expr: Expr) ={
//    this = a.head
//  }
}

case class Array(a: Seq[Expr], et: Type) extends Values{
  override var t: Type = ArrayType(et, a.length)

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = Array(newChildren(0).asInstanceOf[Seq[Expr]], newChildren(1).asInstanceOf[Type])

  override def children = Seq()
//
//  def foreach(expr: Expr) ={
//    this = a.head
//  }
}

case class ArrayAccess(a: Array, index: Int) extends Expr {
  override var t: Type = a.t

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = ArrayAccess(newChildren(0).asInstanceOf[Array], newChildren(1).asInstanceOf[Int])

  override def children = Seq()
}


//case class Vector(a: Expr, number: Type) extends Values{
//  override var t: Type = VectorType(a.t, number)
//
//  override def toString(): String = a.toString
//
//  override def build(newChildren: Seq[IR]) = Vector(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Type])
//
//  override def children = Seq()
//}