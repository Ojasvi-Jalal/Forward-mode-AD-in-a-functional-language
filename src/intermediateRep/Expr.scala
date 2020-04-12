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
  def >(that: Expr): Expr = this > that
  def $(that: Param): Expr = FunctionCall(Lambda(that, this),DoubleLiteral(1))
  def times2(): Expr = FunctionCall(FunctionCall(MultiplyDouble(this), this), IntLiteral(2))
}

case class FunctionCall(f: Expr, arg: Expr) extends Expr {
  override var t: Type = FunctionType(f.t,arg.t)
  var function: Expr = f
  var argument: Expr = arg

  override def build(newChildren: Seq[IR]): Expr = ???

  override def toString(): String = arg.toString

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

case class Map(param: Expr, body: Expr, vector: Expr) extends AnonymousFunction {
  var size = 0
  vector match {
    case _: Vector => size =  vector.asInstanceOf[Vector].a.size
    case _: VectorPairs => size =  vector.asInstanceOf[VectorPairs].a.size
    case _: VectorVar => size =  vector.asInstanceOf[VectorVar].len
    case _: Sequence => size = vector.asInstanceOf[Sequence].list.length
  }
  override var t: Type = VectorType(vector.t, size)

  override def build(newChildren: Seq[IR]): Map = Map(newChildren(0).asInstanceOf[Param], newChildren(1).asInstanceOf[Expr], newChildren(2).asInstanceOf[Expr] )

  override def children: Seq[IR] = Seq(param,body, vector)

}

case class Fold(body: Expr, initial : Expr, vector: Vector) extends AnonymousFunction {
  override var t: Type = vector.t

  override def build(newChildren: Seq[IR]): Fold = Fold(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr], newChildren(2).asInstanceOf[Vector] )

  override def children: Seq[IR] = Seq(body, vector)
}

case class Zip(vector1: Expr, vector2: Expr) extends AnonymousFunction {
  override var t: Type = vector1.t

  override def build(newChildren: Seq[IR]): Zip = Zip(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[IR] = Seq(vector1, vector2)
}

case class DotProduct(vector1: Expr, vector2: Expr) extends AnonymousFunction {
  override var t: Type = vector1.t

  override def build(newChildren: Seq[IR]): DotProduct = DotProduct(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[IR] = Seq(vector1, vector2)
}

case class GreaterThan(arg1: Expr, arg2: Expr) extends Expr {
  override  var t: Type = BooleanType

  override def build(newChildren: Seq[IR]): GreaterThan = GreaterThan(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[IR] = Seq()
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

  def ===(that: Var) : Boolean = {
    this.toString() == that.toString
  }

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

  def ===(that: Var) : Boolean = {
    this.d == that.asInstanceOf[IntLiteral].d
  }
}

case class EqualTo(a: Expr, b:Expr) extends Values{
  override var t: Type = BooleanType

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = EqualTo(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children = Seq()
}

case class Bool(d: Boolean) extends Values{
  override var t: Type = BooleanType

  override def toString(): String = d.toString

  override def build(newChildren: Seq[IR]) = Bool(newChildren.head.asInstanceOf[Boolean])

  override def children = Seq()
}

case class Pair(a: Expr, b: Expr) extends Expr{
  override var t: Type = a.t
  var first = a
  var second = b
  override def build(newChildren: Seq[IR]) = Pair(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])
  override def children = Seq()
}

case class Vector(a: Seq[Expr], et: Type) extends Expr{
  override var t: Type = VectorType(et, a.length)

  var list: Seq[Expr] =  a

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = Vector(newChildren(0).asInstanceOf[Seq[Expr]], newChildren(1).asInstanceOf[Type])

  override def children = Seq()
}

case class VectorVar(a: Expr, len: Int) extends Expr{
  override var t: Type = VectorType(a.t, len)

  var elem: Expr = a

  def ===(that: Var) : Boolean = {
    this.a.toString == that.asInstanceOf[VectorVar].a.toString && this.len == that.asInstanceOf[VectorVar].len
  }

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = Vector(newChildren(0).asInstanceOf[Seq[Expr]], newChildren(1).asInstanceOf[Type])

  override def children = Seq()
}

case class Sequence(a: Seq[Int]) extends Expr{
  override var t: Type = IntType

  var list: Seq[Int] =  a

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = Sequence(newChildren(0).asInstanceOf[Seq[Int]])

  override def children = Seq()
}


case class VectorPairs(a: Seq[Pair], et: Type) extends Expr{
  override var t: Type = VectorType(et, a.length)

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = VectorPairs(newChildren(0).asInstanceOf[Seq[Pair]], newChildren(1).asInstanceOf[Type])

  override def children = Seq()
}

case class Matrix(a: Seq[Seq[_]], et: Type) extends Expr {
  override var t: Type = VectorType(et, a.length)

  var matrix: Seq[Seq[_]] =  a

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = Matrix(newChildren(0).asInstanceOf[Seq[Seq[Expr]]], newChildren(1).asInstanceOf[Type])

  override def children = Seq()
}

case class VectorVarAccess(a: VectorVar, index: Expr) extends Expr {
  override var t: Type = a.t

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = VectorVarAccess(newChildren(0).asInstanceOf[VectorVar], newChildren(1).asInstanceOf[Expr])

  override def children = Seq()
}

case class VectorAccess(a: Vector, index: Int) extends Expr {
  override var t: Type = a.t

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = VectorAccess(newChildren(0).asInstanceOf[Vector], newChildren(1).asInstanceOf[Int])

  override def children = Seq()
}

case class MaxVar(arg1: Expr) extends Expr {
  override var t: Type = arg1.t

  override def build(newChildren: Seq[IR]) = MaxVar(newChildren(0).asInstanceOf[VectorVar])

  override def children = Seq(arg1)
}


case class Drop(a: VectorVar, index: Expr) extends BuiltInFunction {
  override var t: Type = a.t

  override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = Drop(newChildren(0).asInstanceOf[VectorVar], newChildren(1).asInstanceOf[Expr])

  override def children = Seq()
}

//abstract case class Build(len: Int) extends BuiltInFunction {
//  override var t: Type = IntType
//  override def toString(): String = len.toString
//
// override def build(newChildren: Seq[IR]) = Build(newChildren(0).asInstanceOf[Int])
//
//  override def children = Seq()
//}

case class Max(arg1: Expr, arg2: Expr) extends Expr {
  override var t: Type = arg1.t

  override def build(newChildren: Seq[IR]) = Max(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children = Seq(arg1, arg2)
}

case class If_Else(condition: Expr, stmt1: Expr, stmt2: Expr) extends Expr {
  override var t: Type = stmt1.t

  //override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = If_Else(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr], newChildren(2).asInstanceOf[Expr])

  override def children = Seq()
}

case class If(condition: Expr, stmt1: Expr) extends Expr {
  override var t: Type = stmt1.t

  //override def toString(): String = a.toString

  override def build(newChildren: Seq[IR]) = If(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children = Seq()
}