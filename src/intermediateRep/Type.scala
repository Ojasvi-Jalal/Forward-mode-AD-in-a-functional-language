package intermediateRep

/**
  *   Type
  *              IR
  *              |
  *             Type
  *         /     |        \
  *     Scalar ArrayType  FuncType (Unary functions)
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

object IntType extends Scalar {
  override def build(newChildren: Seq[IR]) = IntType

  override def children: Seq[Type] = Seq()
}

case class ArrayType(in: Type, numberOfElements: Type ) extends Type {
  override def build(newChildren: Seq[IR]): ArrayType = ArrayType(newChildren.head.asInstanceOf[Type], newChildren(1).asInstanceOf[Type])
  override def children: Seq[Type] = Seq(in, numberOfElements)
  override def ===(that: Type): Boolean = ???
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

