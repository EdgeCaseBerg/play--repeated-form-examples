package controllers

import play.api.mvc._
import play.api.i18n.I18nSupport
import play.api.i18n.MessagesApi
import javax.inject.Inject

import models._
import forms._

class RepeatedFooController @Inject() (val messagesApi: MessagesApi) extends Controller with I18nSupport {
	def example1() = Action {
		val data = Seq.empty[Foo]
		val form = RepeatedFoos.newForm().fill(data)
		Ok(views.html.example.repeatedFoosEx1(form))
	}
}