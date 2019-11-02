package Functions

import scala.collection.mutable

/**
  * the root node of all expressions and types
  */

trait IR extends BuildableTreeNode[IR] {
  def toShortString: String = getClass.getName.split('$').head

  override def toString: String = toShortString + (if (children.nonEmpty) ("[" + children.mkString(";") + "]") else "")
}


/**
  * the root expression
  *                            IR
  *                             |
  *                        Expression
  *                             |
  *    ----------------------------------------
  *    /        |                     \        \
  *   /         |                     \         \
  *  FuncCall   Function               Param     Values
  *           /      \                          /   \
  *       Anonymous    Built-in                 Int   Float
  *       Functions    Functions
  *         |        /     \
  *       Lambda     Add    Multiply
  */

trait Expr extends IR {
  var t: Type

  override def build(newChildren: Seq[IR]): Expr

//  final def hasFreeTypeVar: Boolean = {
//    visit({
//      case _: TypeVarT => return true
//      case _ =>
//    }, _ => Unit)
//    false
//  }

  def +(that: Expr): Expr = FunctionCall(FunctionCall(AddDouble(DoubleLiteral(this.asInstanceOf[DoubleLiteral].d)).asInstanceOf[Expr], this), that)
  def *(that: Expr): Expr = FunctionCall(FunctionCall(MultiplyDouble(DoubleLiteral(this.asInstanceOf[DoubleLiteral].d)).asInstanceOf[Expr], this), that)
  def /(that: Expr): Expr = FunctionCall(FunctionCall(DivideDouble(DoubleLiteral(this.asInstanceOf[DoubleLiteral].d)).asInstanceOf[Expr], this), that)
  def ^(that: Expr): Expr = FunctionCall(FunctionCall(PowerDouble(DoubleLiteral(this.asInstanceOf[DoubleLiteral].d)).asInstanceOf[Expr], this), that)
  def $(that: Expr): Expr = FunctionCall(this, that) // func $ arg
  // implicit  e.g. : FloatLiteral(2) + FloatLiteral(3.0f)    /// 2 + 3.0f
  // later can write implicit conversions

}

case class FunctionCall(f: Expr, arg: Expr) extends Expr {
  override var t: Type = FunctionType(f.t,arg.t)

  override def build(newChildren: Seq[IR]): Expr = ???

  override def children: Seq[IR] = Seq(f,arg)
}

trait Function extends Expr {

}

trait AnonymousFunction extends Function {

}


case class Lambda(p: Param, b: Expr) extends AnonymousFunction {
  override var t: Type = ???

  override def build(newChildren: Seq[IR]): Lambda = Lambda(newChildren(0).asInstanceOf[Param], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[IR] = Seq(p,b)

  override def toString = "(" + p + ":" + p.t + ") =>" + b

}


trait BuiltInFunction extends Function {

}

case class AddDouble(x: DoubleLiteral) extends BuiltInFunction {

  override def build(newChildren: Seq[IR]): Expr = AddDouble(newChildren(0).asInstanceOf[DoubleLiteral])

  override def children: Seq[DoubleLiteral] = Seq(x)

  //override def toString = "(" + lhs + " + " + rhs + ")" // ask
  //override var t: Type = FunctionType(FloatType.asInstanceOf[Type], FunctionType(FloatType.asInstanceOf[Type], FloatType.asInstanceOf[Type]))
  override var t: Type = FunctionType(x.t, FunctionType(x.t, x.t))
}


case class MultiplyDouble(x: DoubleLiteral) extends BuiltInFunction {

  override def build(newChildren: Seq[IR]): MultiplyDouble = MultiplyDouble(newChildren(0).asInstanceOf[DoubleLiteral])

  override def children: Seq[Expr] = Seq(x)

  override var t: Type = FunctionType(x.t, FunctionType(x.t, x.t))
}

case class DivideDouble(x: DoubleLiteral) extends BuiltInFunction {

  override def build(newChildren: Seq[IR]): DivideDouble = DivideDouble(newChildren(0).asInstanceOf[DoubleLiteral])

  override def children: Seq[Expr] = Seq(x)

  override var t: Type = FunctionType(x.t, FunctionType(x.t, x.t))
}

case class PowerDouble(x: DoubleLiteral) extends BuiltInFunction {

  override def build(newChildren: Seq[IR]): PowerDouble = PowerDouble(newChildren(0).asInstanceOf[DoubleLiteral])

  override def children: Seq[Expr] = Seq(x)

  override var t: Type = FunctionType(x.t, FunctionType(x.t, x.t))
}

case class Param() extends Expr {
  override var t: Type = ???

  override def build(newChildren: Seq[IR]) = ???

  override def children = ???
}

trait Values extends Expr {

}

case class DoubleLiteral(d: Double) extends Values{
  //override var t: FloatType = FloatType(f)
  override var t: Type = DoubleType

  override def build(newChildren: Seq[IR]) = DoubleLiteral(newChildren.head.asInstanceOf[Double])

  override def children = Seq()
}

/**
  *   Type
  *         IR
  *          \
  *         Type
  *         /   \
  *     Scalar  FuncType (Unary functions)
  *     /   \
  * Float   Int
  */


trait Type extends IR { //=== or override hash
  def ===(that: Type) : Boolean
}

trait Scalar extends Type { //can use set //
  override def ===(that: Type) = {
    this == that
  }
}

object DoubleType extends Scalar {
  override def build(newChildren: Seq[IR]) = DoubleType

  override def children: Seq[Type] = Seq()
}

case class FunctionType(in: Type, out: Type) extends Type {
  override def build(newChildren: Seq[IR]): FunctionType = FunctionType(newChildren.head.asInstanceOf[Type], newChildren(1).asInstanceOf[Type])
  override def children: Seq[Type] = Seq(in, out)
  override def ===(that: Type) = {
    that match {
      case FunctionType(thatInT, thatOutT) =>
        in.equals(thatInT) && out.equals(thatOutT)
      case _ => false
    }
  }
}

