package controllers

import javax.inject.{Inject, Singleton}

import application.RequestService
import controllers.model.RequestList
import play.api.Logger
import play.api.mvc.{Action, Controller}


/**
  * Created by Fumiyasu on 2016/11/03.
  */
@Singleton
class RequestController @Inject()(requestService: RequestService) extends Controller {
  def sample = Action(parse.json) { request =>
    request.body.validate[RequestList].fold(
      invalid => BadRequest,
      valid => {
        val r = requestService.newRequest(valid)
        Logger.debug(s"=========r: $r")
        Ok
      }
    )
  }
}
