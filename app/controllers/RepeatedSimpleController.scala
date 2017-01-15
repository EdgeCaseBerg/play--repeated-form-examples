package controllers

import play.api.mvc._
import play.api.i18n.I18nSupport
import play.api.i18n.MessagesApi
import javax.inject.Inject

import forms._

class RepeatedSimpleController @Inject() (val messagesApi: MessagesApi) extends Controller with I18nSupport {
	def example1() = Action {
		val data = Seq("example")
		Ok(views.html.example.simpleNoIndicesEx1(data))
	}

	def example2() = Action {
		val data = Seq("example")
		val form = SimpleNoIndices.newForm().fill(data)
		Ok(views.html.example.simpleMixedIndicesEx1(form))
	}

	def whatWasPosted() = Action { implicit req =>
		SimpleNoIndices.newForm().bindFromRequest().fold(
			badSubmission => BadRequest(badSubmission.errors.mkString),
			stringsSent => Ok(stringsSent.size + ": " + stringsSent.mkString(", "))
		)
	}
}