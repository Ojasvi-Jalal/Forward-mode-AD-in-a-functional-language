trait ExampleTrait {
  val list: Seq[String]

  def someFunction(a: String => Unit): Unit = {
    list.foreach {
      println("ran a on")
      a(_)
    }
  }
}

class Example(val overList: Seq[String]) extends ExampleTrait {
  override val list = overList
}

object Main extends App {

  val e = new Example(
    Seq("hello", "this", "is", "a", "new", "seq")
  )

  def anotherFunction(s: String): Unit = {
    println("anotherFunction triggered with s=" + s)
  }

  e.someFunction(anotherFunction)

}