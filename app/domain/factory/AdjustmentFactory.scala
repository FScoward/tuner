package domain.factory

import controllers.model.AdjustmentDateView
import domain.model.{AdjustmentDate, Adjustment, ScheduleImp}
import util.Id64


/**
  * Created by Fumiyasu on 2016/11/06.
  */
object AdjustmentFactory {
  def newAdjustment(userName: String, title: String, dates: Seq[AdjustmentDateView]) = {
    val adjustmentDate = dates.map(d => AdjustmentDate(Id64.nextAscId(), ScheduleImp(d.start, d.end), Nil))
    Adjustment(Id64.nextAscId(), title, adjustmentDate)
  }
}
