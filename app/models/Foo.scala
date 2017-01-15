package models

/* Simple example model, parent of Bar's */
case class Foo(id: UUID, value: String)

object Foo {
	def apply(value: String) = new Foo(randomUUID(), value)
}