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
  *       Anonymous    Built-in                 Int   Float
  *       Functions    Functions
  *         |        /     \
  *       Lambda     Add    Multiply
  */

trait Expr extends IR {
  var t: Type

  override def build(newChildren: Seq[IR]): Expr

  final def hasFreeTypeVar: Boolean = {
    visit({
      case _: TypeVarT => return true
      case _ =>
    }, _ => Unit)
    false
  }
}


case class FunctionCall() extends Expr {
  override var t: Type = _

  override def build(newChildren: Seq[IR]): Expr = ???

  override def children: Seq[IR] = ???
}

trait Function extends Expr {

}

trait AnonymousFunction extends Function {

}


case class Lambda(p: Expr, b: Expr) extends AnonymousFunction {
  override def build(newChildren: Seq[IR]): Lambda = Lambda(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[IR] = Seq(p,b)

  override def toString = "(" + p + ":" + p.t + ") =>" + b

  override val t: Type = _
}


trait BuiltInFunction extends Function {

}

abstract case class Add(x: Expr) extends BuiltInFunction {
//
//  def inferType() : Type = {
//    assert (lhs.t == rhs.t)
//    this.t = lhs.t
//    lhs.t
//  }

  val Expr = x

  def add(a: Expr)

  override def build(newChildren: Seq[IR]): Expr

  override def children: Seq[Int]

  //override def toString = "(" + lhs + " + " + rhs + ")" // ask
  override var t: Type = _
}

case class AddInt(x: IntLiteral) extends Add(x) { //call add with arg x and return a function that takes in y as an argument and returns x + y
  def add(x: IntLiteral): (IntLiteral => Int) = {
    (y: IntLiteral) => {
      x.t + y.t
    }
  }

  override def build(newChildren: Seq[IR]): Add = ???

  override def children: Seq[Expr] = ???

  val t: Type = _

}

case class AddFloat(x: FloatLiteral) extends Add(x) { //call add with arg x and return a function that takes in y as an argument and returns x + y
  def add(x: FloatLiteral): (FloatLiteral => Float) = {
    (y: FloatLiteral) => {
      x.t + y.t
    }
  }

  override def build(newChildren: Seq[IR]): Add = ???

  override def children: Seq[Expr] = ???

  val t: Type = _
}



case class Multiply(lhs: Expr, rhs : Expr) extends BuiltInFunction {

  def inferType() : Type = {
    assert (lhs.t == rhs.t)
    this.t = lhs.t
    lhs.t
  }

  override def build(newChildren: Seq[IR]): Multiply = Multiply(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[Expr] = Seq(lhs,rhs)

  override def toString = "(" + lhs + " * " + rhs + ")"

  override var t = _
}

case class Param extends Expr {
  override var t = _

  override def build(newChildren: Seq[IR]) = ???

  override def children = ???
}

trait Values extends Expr {

}

case class IntLiteral extends Values{
  override val t: Int = _

  override def build(newChildren: Seq[IR]): Expr = IntLiteral()

  override def children = Seq()
}

case class FloatLiteral extends Values{
  override val t: Float = _

  override def build(newChildren: Seq[IR]) = FloatLiteral()

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


trait Type extends IR

trait Scalar extends Type

case class Int() extends Scalar {
  def +(t: Int) = this

  def +(x: Int, y: Int): Int = x

  override def build(newChildren: Seq[IR]): Int = Int()
  override def children: Seq[Int] = Seq() //there's no children of int
}

case class Float() extends Scalar {
  def +(t: Float) = this

  override def build(newChildren: Seq[IR]): Float = Float()
  override def children: Seq[Float] = Seq() //there's no children of float
}

case class FunctionType(in: Type, out: Type) extends Type {
  override def build(newChildren: Seq[IR]): FunctionType = FunctionType(newChildren.head.asInstanceOf[Type], newChildren(1).asInstanceOf[Type])
  override def children: Seq[Type] = Seq(in, out)
}

