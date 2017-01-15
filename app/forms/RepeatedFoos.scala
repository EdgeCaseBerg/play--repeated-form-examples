package forms

import play.api.data._
import play.api.data.Forms.{ single, seq }

import models._

object RepeatedFoos {
	def newForm(): Form[Seq[Foo]] = Form(single("foos" -> seq(foo)))
}