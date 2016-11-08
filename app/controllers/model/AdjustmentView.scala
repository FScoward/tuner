package controllers.model

import java.time.LocalDateTime

import play.api.libs.json.Json

/**
  * Created by Fumiyasu on 2016/11/06.
  */
case class AdjustmentDate(start: LocalDateTime, end: LocalDateTime)
case class AdjustmentView(title: String, userName: String, dates: Seq[AdjustmentDate])
object AdjustmentView {
  implicit val adjustmentDateReads = Json.reads[AdjustmentDate]
  implicit val reads = Json.reads[AdjustmentView]
}

