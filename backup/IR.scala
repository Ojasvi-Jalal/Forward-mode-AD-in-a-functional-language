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


trait Function extends Expr{

}

case class Lambda(p: Expr, b: Expr) extends Function{
  override def build(newChildren: Seq[IR]): IR = ???

  override def children: Seq[IR] = ???
}

trait BuiltInFunc extends Function

case class Add(lhs: Expr, rhs : Expr) extends FunCall {

  def inferType() : Type = {
    if (lhs.t != rhs.t)
      thorw Excpetion...
    this.t = lhs.t
    lhs.t
  }

  def evaluate(lhs: Expr, rhs:Expr): Int ={
    lhs+rhs
  }

  override def build(newChildren: Seq[IR]): Add = Add(newChildren(0).asInstanceOf[Expr], newChildren(1).asInstanceOf[Expr])

  override def children: Seq[Expr] = Seq(lhs,rhs)
}

case class Multiply(a: Scalar, b: Scalar) extends BuiltInFunc{

}

//case class Lambda extends Function
//
//case class BuiltInFunctions extends Function

trait FunctionCall extends Expr {
  val args: Seq[IR] //the list of args
  var t: Type //function type


}

//case
/**
  * an extensible node for expression
  * extend this trait if you want to add custom expressions
  */

trait BuiltinExpr extends Expr {
  private[core] val innerIR: Expr
}

/**
  * the type of a type
  */

trait Kind

/**
  * the root type
  */

trait Type extends IR {
  def kind: Kind

  def superType: Type

  // restrict children to be of type TypeT (no further Expr can be found in the children)
  // remove these 3 lines the enable Types to contain further Expr
  override def children: Seq[Type]
  override def build(newChildren: Seq[IR]): Type
  final def visitAndRebuildTypes(pre: Type => Type, post: Type => Type): Type = post(build(pre(this).children.map(_.visitAndRebuildTypes(pre, post))))

  final def getSuperKinds: Seq[Kind] = {
    kind match {
      case AnyTypeKind => Seq(kind)
      case _ => Seq(kind) ++ superType.getSuperKinds //++ to concatenate any two collections -- and even iterators
    }
  }

  final def getCommonSuperKind(that: Type): Kind = { // getting the common super kind of a, e.g. Float a, Int b, a.getCommonSuperKind(b)
    val thatSuperKinds = that.getSuperKinds

    for (elem <- this.getSuperKinds) {
      if (thatSuperKinds.contains(elem))
        return elem
    }

    AnyTypeKind
  }

  final def isSubTypeOf(that: Type): Option[Boolean] = {
    (this, that) match {
      // Arith (handle these special cases first)
      case (thisTVA: TypeVarArithT, thatTVA: TypeVarArithT) =>
        (thisTVA.range.max - thatTVA.range.max, thisTVA.range.min - thatTVA.range.min) match {
          case (Cst(le), Cst(ge)) => Some(le <= 0 && ge >= 0)
          case _ => None
        }
      case (thisTVA: TypeVarArithT, thatAT: ArithTypeT) =>
        Some(thatAT.ae == thisTVA.range.min && thatAT.ae == thisTVA.range.max)
      case (thisAT: ArithTypeT, thatTVA: TypeVarArithT) =>
        (thisAT.ae - thatTVA.range.min, thisAT.ae - thatTVA.range.max) match {
          case (Cst(ge), Cst(le)) => Some(ge >= 0 && le <= 0) // use ArithExpr.isSmaller(,) if not working
          case _ => None
        }
      case (thisAT: ArithTypeT, thatAT: ArithTypeT) =>
        Some(thisAT.ae == thatAT.ae)
      case (_: TypeVarArithT, _) => None
      //case (_, _ : TypeVarArithT) => ??? // TODO missing?

      // Fun
      // special case: functions are contravariant over its argument type, and covariant over its return type
      case (thisFt: FunTypeT, thatFt: FunTypeT) =>
        (thatFt.inType.isSubTypeOf(thisFt.inType), thisFt.outType.isSubTypeOf(thatFt.outType)) match {
          case (Some(true), Some(true)) => Some(true)
          case (Some(false), _) | (_, Some(false)) => Some(false)
          case (_, _) => None
        }

      // TypeVars
      case (_: TypeVarT, _) if this.kind == AnyTypeKind => None // if this is AnyTypeVar we cannot say anything
      case (_, _: TypeVarT) if that.kind == AnyTypeKind => None // if that is AnyTypeVar we cannot say anything
      case (tv1: TypeVarT, tv2: TypeVarT) if tv1 == tv2 => Some(true)
      case (_, tv: TypeVarGenT) =>
        if (this.isSubTypeOf(tv.upperBound) == Option(false))
          Some(false)
        else
          None
      case (tv: TypeVarGenT, _) =>
        if (tv.upperBound.isSubTypeOf(that) == Option(true))
          Some(true)
        else
          None

      // general cases
      case (_, _) if this.kind == that.kind =>
        if (this.children.zip(that.children).forall(p => p._1.isSubTypeOf(p._2).getOrElse(false)))
          Some(true)
        else if (this.children.zip(that.children).forall(p => p._1.isSubTypeOf(p._2).getOrElse(true)))
          None
        else
          Some(false)
      case (_, _) if that.kind == AnyTypeKind => Some(true)
      case (_, _) if this.kind == AnyTypeKind => Some(false)

      // else
      case (_, _) =>
        this.superType.isSubTypeOf(that)
    }
  }
}

trait Scalar extends Type

case class Int extends Scalar{
  override def build(newChildren: Seq[IR]): Int = Int()

  override def children: Seq[Int] = Seq() //there's no children of int

  override def kind: Kind = ???

  override def superType: Type = ???
}

case class Float extends Scalar{
  override def build(newChildren: Seq[IR]): IR = ???

  override def children: Seq[Float_comp] = ???
}

case class FunctionType(in: Type, out: Type) extends Type{
  override def kind: Kind = ??? //get rid
  override def superType: Type = ??? //rid
  override def build(newChildren: Seq[IR]): FunctionType = FunctionType(newChildren.head.asInstanceOf[Type], newChildren(1).asInstanceOf[Type])
  override def children: Seq[Type] = Seq(in, out)
}

case class ArrayType(el: Type) extends Type {
  override def build(newChildren: Seq[IR]): IR = ??
  override def children: Seq[ArrayType] = ???
}

case object AnyTypeKind extends Kind

sealed trait AnyTypeT extends Type {
  override def kind: Kind = AnyTypeKind

  override def superType: Type = this

  override def children: Seq[Type] = Seq()
}

final case class AnyType() extends AnyTypeT {
  override def build(newChildren: Seq[IR]): AnyTypeT = this
}

final case class AnyTypeVar() extends AnyTypeT with TypeVarT {
  override def buildNewTV(newChildren: Seq[Type]): TypeVarT = AnyTypeVar()
}

object TypeVarCounter {
  private val cnt = new AtomicLong(0) /* Instance counter */

  def next(): Long = cnt.getAndIncrement()
}

trait TypeVarT extends Type {
  // must not override the kind

  override final def build(newChildren: Seq[IR]): TypeVarT = this

  def buildNewTV(newChildren: Seq[Type]): TypeVarT

  val tvid: Long = TypeVarCounter.next()

  override def equals(that: Any): Boolean =
    that match {
      case thatTV: TypeVarT => this.tvid == thatTV.tvid
      case _ => false
    }

  override def hashCode(): Int = 8 * 79 + tvid.hashCode // need to be the same hash function as in ArithExpr Var class

  override def toShortString: String = super.toShortString + "(" + tvid + ")"
}

trait TypeVarGenT extends TypeVarT {
  def upperBound: Type
}

trait TypeVarArithT extends TypeVarT {
  def range: Range
}

trait ValueTypeT extends AnyTypeT

trait MetaTypeT extends AnyTypeT

case object ArithTypeKind extends Kind

sealed trait ArithTypeT extends MetaTypeT {
  val ae: ArithExpr

  override def kind: Kind = ArithTypeKind

  override def superType: Type = AnyType()

  // filter '_ != this' to avoid infinite recursion (and stack overflow exceptions)
  override def children: Seq[Type] = ae.varList.filter(_ != this).filter(_.isInstanceOf[TypeVarArithT]).map(_.asInstanceOf[TypeVarArithT])
}

final case class ArithType(ae: ArithExpr) extends ArithTypeT {
  override def build(newChildren: Seq[IR]): ArithTypeT = ArithType(
    ae.visitAndRebuild({
      case at: ArithTypeT if children.contains(at) => newChildren(children.indexOf(at)).asInstanceOf[ArithTypeT].ae
      case at => at
    })
  )

  override def map(f: IR => IR): ArithTypeT = ArithType(
    ae.visitAndRebuild({
      case at: ArithTypeVar => f(at).asInstanceOf[ArithTypeT].ae
      case at => at
    })
  )

  override def toShortString: String = super.toShortString + "(" + ae.toString + ")"
}

sealed case class ArithTypeVar(override val range: Range = RangeUnknown, tvFixedId: Option[Long] = None) extends ExtensibleVar("", range) with ArithTypeT with TypeVarArithT {
  override def cloneSimplified(): Var with SimplifiedExpr = new ArithTypeVar(range, Some(tvid)) with SimplifiedExpr

  override val tvid: Long = tvFixedId.getOrElse(TypeVarCounter.next())

  val ae: ArithExpr = this

  override def buildNewTV(newChildren: Seq[Type]): TypeVarArithT = ArithTypeVar(range = this.range) // TODO FIXME

  override lazy val hashCode: Int = super[TypeVarArithT].hashCode()
  override lazy val toString: String = super[TypeVarArithT].toString()

  override def copy(r: Range) = ArithTypeVar(r)

  override def visitAndRebuild(f: ArithExpr => ArithExpr): ArithExpr = f(ArithTypeVar(range.visitAndRebuild(f), Some(this.tvid)))
}

/**
  * an extensible node for types
  * extend this trait if you want to add custom types
  */

case object BuiltinDataTypeKind extends Kind

trait BuiltinDataTypeT extends ValueTypeT {
  override def kind: Kind = BuiltinDataTypeKind

  override def superType: Type = AnyType()
}

final case class BuiltinDataType() extends BuiltinDataTypeT {
  override def build(newChildren: Seq[IR]): BuiltinDataTypeT = this
}

final case class BuiltinDataTypeVar() extends BuiltinDataTypeT with TypeVarGenT {
  override def buildNewTV(newChildren: Seq[Type]): TypeVarT = BuiltinDataTypeVar()

  override def upperBound: BuiltinDataTypeT = BuiltinDataType()
}
