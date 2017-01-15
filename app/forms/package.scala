import play.api.data._
import play.api.data.Forms._

import models._

package object forms {
	def foo: Mapping[Foo] = mapping(
		"id" -> uuid,
		"value" -> nonEmptyText
	)(Foo.apply)(Foo.unapply)

	def bar: Mapping[Bar] = mapping(
		"fooId" -> uuid,
		"id" -> uuid,
		"value" -> nonEmptyText
	)(Bar.apply)(Bar.unapply)
}