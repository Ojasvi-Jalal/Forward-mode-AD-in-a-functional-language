package intermediateRep

import eval.DoubleEvaluator

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
  def *(that: Expr): Expr = FunctionCall(FunctionCall(MultiplyDouble(this), this), that)
  def /(that: Expr): Expr = FunctionCall(FunctionCall(DivideDouble(this), this), that)
  def ^(that: Expr): Expr = FunctionCall(FunctionCall(PowerDouble(this), this), that)
  def $(that: Param): Expr = FunctionCall(Lambda(that, this),DoubleLiteral(1))


  def times2(): Expr = FunctionCall(FunctionCall(MultiplyDouble(this), this), IntLiteral(2))
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

  override def build(newChildren: Seq[IR]): Lambda = Lambda(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[IR] = Seq(param,body)
}


object Let {
  def apply(param: Expr, value: Expr, body: Expr): Expr = FunctionCall(Lambda(param, body), value)

  //def apply(param: Expr, value: Expr, body: Array): Expr = FunctionCall(Lambda(param, body), value)
}

case class Map(param: Expr, body: Expr, vector: Array) extends AnonymousFunction {
  override var t: Type = ArrayType(vector.t, vector.a.size)

  override def build(newChildren: Seq[IR]): Map = Map(newChildren(0).asInstanceOf[Param], newChildren(1).asInstanceOf[Expr], newChildren(2).asInstanceOf[Array] )

  override def children: Seq[IR] = Seq(param,body, vector)

}

case class Fold(param: Expr, body: Expr, initial : Expr, vector: Array) extends AnonymousFunction {
  override var t: Type = vector.t

  override def build(newChildren: Seq[IR]): Fold = Fold(newChildren(0).asInstanceOf[Param], newChildren(1).asInstanceOf[Expr], newChildren(2).asInstanceOf[Expr], newChildren(3).asInstanceOf[Array] )

  override def children: Seq[IR] = Seq(param,body, vector)
}

case class Zip(vector1: Expr, vector2: Expr) extends AnonymousFunction {
  override var t: Type = vector1.t

  override def build(newChildren: Seq[IR]): Zip = Zip(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[IR] = Seq(vector1, vector2)
}

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

  override def toString(): String = x.toString

  override def build(newChildren: Seq[IR]) = ???

  override def children = Seq()
}

case class Var(x:Expr) extends Expr {
  val value : Param = Param(x.toString)

  override var t: Type = DoubleType

  override def build(newChildren: Seq[IR]) = Var(x)

  override def children = Seq()

  def ===(that: Var) : Boolean = {
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

case class Pair(a: Expr, b: Expr) extends Expr{
  override var t: Type = a.t
  var first = a
  var second = b
  override def build(newChildren: Seq[IR]) = Pair(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])
  override def children = Seq()
}

case class Vector(a: Seq[Expr], et: Type) extends Values{
  override var t: Type = VectorType(et, a.length)

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = Vector(newChildren(0).asInstanceOf[Seq[Expr]], newChildren(1).asInstanceOf[Type])

  override def children = Seq()
}

case class Array(a: Seq[Expr], et: Type) extends Expr{
  override var t: Type = ArrayType(et, a.length)

  var list: Seq[Expr] =  a

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = Array(newChildren(0).asInstanceOf[Seq[Expr]], newChildren(1).asInstanceOf[Type])

  override def children = Seq()
}

case class ArrayPairs(a: Seq[Pair], et: Type) extends Expr{
  override var t: Type = ArrayType(et, a.length)

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = ArrayPairs(newChildren(0).asInstanceOf[Seq[Pair]], newChildren(1).asInstanceOf[Type])

  override def children = Seq()
}

case class Matrix(a: Seq[Seq[_]], et: Type) extends Expr{
  override var t: Type = ArrayType(et, a.length)

  var matrix: Seq[Seq[_]] =  a

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = Matrix(newChildren(0).asInstanceOf[Seq[Seq[Expr]]], newChildren(1).asInstanceOf[Type])

  override def children = Seq()
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