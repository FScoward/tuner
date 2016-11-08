package controllers.model

import java.time.LocalDateTime

import play.api.libs.json.Json

/**
  * Created by Fumiyasu on 2016/11/06.
  *
  * Viewモデル
  */
case class AdjustmentDateView(start: LocalDateTime, end: LocalDateTime)
case class AdjustmentView(title: String, userName: String, dates: Seq[AdjustmentDateView])
object AdjustmentView {
  implicit val adjustmentDateReads = Json.reads[AdjustmentDateView]
  implicit val reads = Json.reads[AdjustmentView]
}

