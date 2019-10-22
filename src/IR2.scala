import java.util.concurrent.atomic.AtomicLong

import scala.language.implicitConversions


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
  *    Anonymous    Built-in                  Int   Float
  *    Functions    Functions
  *         |        /     \
  *     Lambda     Add    Multiply
  */

trait Expr extends IR {
  val t: Type

  override def build(newChildren: Seq[IR]): Expr

  final def hasFreeTypeVar: Boolean = {
    visit({
      case _: TypeVarT => return true
      case _ =>
    }, _ => Unit)
    false
  }
}


trait FunctionCall extends Expr {
  val args: Seq[Expr] //the list of args
  var t: Type //function type // remove this
}

trait Function extends Expr {

}

trait AnonymousFunction extends Function {

}


case class Lambda(p: Expr, b: Expr) extends AnonymousFunction {
  override def build(newChildren: Seq[IR]): Lambda = Lambda(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[IR] = Seq(p,b)

  override val t: Type = _
}


trait BuiltInFunction extends Function {

}

case class Add(lhs: Expr, rhs : Expr) extends BuiltInFunction {

  def inferType() : Type = {
    assert (lhs.t == rhs.t)
    this.t = lhs.t
    lhs.t
  }

  override def build(newChildren: Seq[IR]): Add = Add(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[Expr] = Seq(lhs,rhs)

  override var t: Type = _
}

case class Multiply(lhs: Expr, rhs : Expr) extends BuiltInFunction {

  def inferType() : Type = {
    assert (lhs.t == rhs.t)
    this.t = lhs.t
    lhs.t
  }

  override def build(newChildren: Seq[IR]): Multiply = Multiply(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[Expr] = Seq(lhs,rhs)
}

case class Param extends Expr {

}

trait Values extends Expr {

}

case object IntLiteral extends Values{
  val intLiteral: Int

  override def build(newChildren: Seq[IR]): Expr = ???

  override def children: Seq[IR] = ???
}

case object FloatLiteral extends Values{
  override var t: Type = _

  override def build(newChildren: Seq[IR]): Expr = ???

  override def children: Seq[IR] = ???
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


trait Type extends IR

trait Scalar extends Type

case class Int() extends Scalar {
  override def build(newChildren: Seq[IR]): Int = Int()
  override def children: Seq[Int] = Seq() //there's no children of int
}

case class Float() extends Scalar {
  override def build(newChildren: Seq[IR]): Float = Float()
  override def children: Seq[Float] = Seq() //there's no children of float
}

case class FunctionType(in: Type, out: Type) extends Type {
  override def build(newChildren: Seq[IR]): FunctionType = FunctionType(newChildren.head.asInstanceOf[Type], newChildren(1).asInstanceOf[Type])
  override def children: Seq[Type] = Seq(in, out)
}