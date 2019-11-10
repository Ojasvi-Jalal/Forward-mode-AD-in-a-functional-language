package intermediateRep


/**
  * the root node of all expressions and types
  */

trait IR extends BuildableTreeNode[IR] {
  def toShortString: String = ""//getClass.toString//.getName.//.split('$').head

  //override def toString: String = toShortString + (if (children.nonEmpty) ("[" + children.mkString(";") + "]") else "")
  //override def toString: String = children.mkString(",")
}