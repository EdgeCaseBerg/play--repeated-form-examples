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

	def example2() = Action {
		val data = Seq(Foo("My First Foo"), Foo("Another Foo"))
		val form = RepeatedFoos.newForm().fill(data)
		Ok(views.html.example.repeatedFoosEx2(form))
	}

	def example3() = Action {
		val data = Seq(Foo("My First Foo"), Foo("Another Foo"))
		Ok(views.html.example.repeatedFoosEx3(data))
	}
}