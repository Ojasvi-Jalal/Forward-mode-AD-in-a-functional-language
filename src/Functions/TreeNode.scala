package Functions

trait TreeNode[T <: TreeNode[T]] {
  def children: Seq[T]

  final def foreach(f: T => Unit): Unit = { //apply f(_) on each child
    children.foreach(f(_))
  }

  final def visit(prePost: T => T => Unit): Unit = {
    val post = prePost(this.asInstanceOf[T])
    foreach(_.visit(prePost))
    post(this.asInstanceOf[T])
  }

  final def visit(pre: T => Unit, post: T => Unit): Unit = { // is a function which is passed to this function, it's a function
    pre(this.asInstanceOf[T])
    foreach(_.visit(pre, post))
    post(this.asInstanceOf[T])
  }
}

trait BuildableTreeNode[T <: BuildableTreeNode[T]] extends TreeNode[T] {
  def build(newChildren: Seq[T]): T

  def map(f: T => T): T = { // TODO should be final, but ArithTypeT must? override it...
    build(children.map(f(_)))
  }

  final def visitAndRebuild(prePost: T => (T, T => T)): T = {
    val (newType, post) = prePost(this.asInstanceOf[T])
    post(newType.map(_.visitAndRebuild(prePost)))
  }

  final def visitAndRebuild(pre: T => T, post: T => T): T = post(pre(this.asInstanceOf[T]).map(_.visitAndRebuild(pre, post)))
}
