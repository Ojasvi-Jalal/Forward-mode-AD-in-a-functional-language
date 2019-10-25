package functions

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

object Evaluator {
  def eval(e:Expr) : Any = {
    e.t match {
      case _:FloatType => FloatEvaluator.eval(e)
    }
  }
}

object FloatEvaluator {
  val paramToArg = mutable.HashMap[Param,Expr]()
  def eval(e:Expr) : Float = {
    e match {
      case FloatLiteral(f) => f
      case FunctionCall(FunctionCall(_:AddFloat, arg2),arg1) =>  eval(arg1) + eval(arg2)
      case FunctionCall(Lambda(param,body),arg) =>
        // store in a map   param -> arg and eval body
        paramToArg.put(param, arg)
        eval(body)
      case p:Param =>
        // fish it up from the map and eval the expr
        eval(paramToArg(p))
    }
  }
}

case class FunctionCall(f: Expr, arg: Expr) extends Expr {
  override var t: Type = _

  override def build(newChildren: Seq[IR]): Expr = ???

  override def children: Seq[IR] = ???
}

trait Function extends Expr {

}

trait AnonymousFunction extends Function {

}


case class Lambda(p: Param, b: Expr) extends AnonymousFunction {
  override val t: Type = ???

  override def build(newChildren: Seq[IR]): Lambda = Lambda(newChildren(0).asInstanceOf[Param], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[IR] = Seq(p,b)

  override def toString = "(" + p + ":" + p.t + ") =>" + b

}


trait BuiltInFunction extends Function {

}

abstract case class AddFloat(x: Expr) extends BuiltInFunction {
//
//  def inferType() : Type = {
//    assert (lhs.t == rhs.t)
//    this.t = lhs.t
//    lhs.t
//  }

  override def build(newChildren: Seq[IR]): Expr

  override def children: Seq[Expr]

  //override def toString = "(" + lhs + " + " + rhs + ")" // ask
  override var t: Type = FunctionType(FloatType.asInstanceOf[Type], FunctionType(FloatType.asInstanceOf[Type], FloatType.asInstanceOf[Type]))
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
  override var t = ???

  override def build(newChildren: Seq[IR]) = ???

  override def children = ???
}

case object Variables extends Param {

}

trait Values extends Expr {

}

case class FloatLiteral(f: Float) extends Values{
  override val t: Type = FloatType()

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

case class FloatType() extends Scalar {
  override def build(newChildren: Seq[IR]): FloatType = FloatType()
  override def children: Seq[FloatType] = Seq() //there's no children of float
}

case class FunctionType(in: Type, out: Type) extends Type {
  override def build(newChildren: Seq[IR]): FunctionType = FunctionType(newChildren.head.asInstanceOf[Type], newChildren(1).asInstanceOf[Type])
  override def children: Seq[Type] = Seq(in, out)
}

