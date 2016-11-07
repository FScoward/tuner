package domain.factory

import java.time.LocalDateTime

import controllers.model.AdjustmentDate
import domain.model.{AdjustmentDateImp, AdjustmentImp, ScheduleImp}
import util.Id64


/**
  * Created by Fumiyasu on 2016/11/06.
  */
object AdjustmentFactory {
  def newAdjustment(userName: String, title: String, dates: Seq[AdjustmentDate]) = {
    val adjustmentDate = dates.map(d => AdjustmentDateImp(Id64.nextAscId(), ScheduleImp(d.start, d.end), Nil))
    AdjustmentImp(Id64.nextAscId(), title, adjustmentDate)
  }
}
