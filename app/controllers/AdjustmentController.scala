package controllers

import javax.inject.{Inject, Singleton}

import application.AdjustmentService
import controllers.model.AdjustmentView
import infrastructure.repository.AdjustmentRepository
import play.api.Logger
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}


/**
  * Created by Fumiyasu on 2016/11/03.
  */
@Singleton
class AdjustmentController @Inject()(adjustmentService: AdjustmentService, adjustmentRepository: AdjustmentRepository) extends Controller {
  def newAdjustment = Action(parse.json) { request =>
    request.body.validate[AdjustmentView].fold(
      invalid => BadRequest,
      valid => {
        val r = adjustmentService.newAdjustment(valid)
        Logger.debug(s"=============> $r,\n ${r.determine}")
        Ok
      }
    )
  }

  def determine = Action { request =>
    val adjustment = adjustmentRepository.resolveBy(0L)
    adjustment.determine
    Ok
  }
}
