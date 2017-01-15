package controllers

import play.api.mvc._

object MiscController extends Controller {
	def index = Action {
		Ok(views.html.index())
	}
}