package intermediateRep


/**
  * the root node of all expressions and types
  */

trait IR extends BuildableTreeNode[IR] {
  def toShortString: String = ""
}