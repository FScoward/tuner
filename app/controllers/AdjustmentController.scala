package controllers

import javax.inject.{Inject, Singleton}

import application.AdjustmentService
import controllers.model.{AnswerView, AdjustmentView}
import infrastructure.repository.AdjustmentRepository
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
//        val ans = r.adjustmentDateList.map(d => Answer(0L, d.id, 0L, domain.model.OK))
//        Logger.debug(s"=============> $r,\n ${r.determine(ans)}")
        Ok
      }
    )
  }

  def addAnswer = Action(parse.json) { request =>
    request.body.validate[AnswerView].fold(
      invalid => BadRequest,
      valid => {
        Ok
      }
    )
  }

  def determine = Action { request =>
    val adjustment = adjustmentRepository.resolveBy(0L)
    adjustment.determine(Nil)
    Ok
  }
}
