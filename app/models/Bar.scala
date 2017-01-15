package models

case class Bar(fooId: UUID, id: UUID, value: String)

object Bar {
	def apply(fooId: UUID, value: String) = new Bar(fooId, randomUUID(), value)
}