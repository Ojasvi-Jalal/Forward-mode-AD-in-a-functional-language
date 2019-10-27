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

case class AddFloat(x: FloatLiteral) extends BuiltInFunction {
//
//  def inferType() : Type = {
//    assert (lhs.t == rhs.t)
//    this.t = lhs.t
//    lhs.t
//  }

  override def build(newChildren: Seq[IR]): Expr = ???

  override def children: Seq[FloatLiteral] = Seq(x)

  //override def toString = "(" + lhs + " + " + rhs + ")" // ask
  //override var t: Type = FunctionType(FloatType.asInstanceOf[Type], FunctionType(FloatType.asInstanceOf[Type], FloatType.asInstanceOf[Type]))
  override var t: Type = FunctionType(x.t, FunctionType(x.t, x.t))
}

//case class AddInt(x: Integer) extends Add(x) { //call add with arg x and return a function that takes in y as an argument and returns x + y
//  def add(x: Integer): (Integer => Integer) = {
//    (y: IntLiteral) => {
//      x.t + y.t
//    }
//  }
//
//  override def build(newChildren: Seq[IR]): Add = ???
//
//  override def children: Seq[Expr] = ???
//
//  val t: Type = _
//
//}

//case class Multiply(lhs: Expr, rhs : Expr) extends BuiltInFunction {
//
//  def inferType() : Type = {
//    assert (lhs.t == rhs.t)
//    this.t = lhs.t
//    lhs.t
//  }
//
//  override def build(newChildren: Seq[IR]): Multiply = Multiply(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])
//
//  override def children: Seq[Expr] = Seq(lhs,rhs)
//
//  override def toString = "(" + lhs + " * " + rhs + ")"
//
//  override var t = _
//}

case class Param() extends Expr {
  override var t: Type = ???

  override def build(newChildren: Seq[IR]) = ???

  override def children = ???
}
//
//case object Variables extends Param {
//
//}

trait Values extends Expr {

}

case class FloatLiteral(f: Float) extends Values{
  //override var t: FloatType = FloatType(f)
  override var t: Type = FloatType(f)

  override def build(newChildren: Seq[IR]) = FloatLiteral(newChildren.head.asInstanceOf[Float])

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

case class FloatType(f:Float) extends Scalar {
  override def build(newChildren: Seq[IR]): FloatType = FloatType(f)
  override def children: Seq[Type] = Seq() //there's no children of float
}

case class FunctionType(in: Type, out: Type) extends Type {
  override def build(newChildren: Seq[IR]): FunctionType = FunctionType(newChildren.head.asInstanceOf[Type], newChildren(1).asInstanceOf[Type])
  override def children: Seq[Type] = Seq(in, out)
}

