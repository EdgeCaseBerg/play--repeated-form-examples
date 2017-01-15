package forms

import play.api.data._
import play.api.data.Forms.{ single, seq, nonEmptyText }

object SimpleNoIndices {
	def newForm(): Form[Seq[String]] = Form(single("strings" -> seq(nonEmptyText)))
}