package domain.model
import java.time.LocalDateTime

import play.api.Logger

/** ドメインモデル */
case class Adjustment(id: Long, title: String, adjustmentDateList: Seq[AdjustmentDate]) {
  Logger.debug(s"create Adjustment")
  def determine(answers: Seq[Answer]) = {
    val (id, _) = answers.filter(_.status == OK).groupBy(_.adjustmentDateId).mapValues(_.length).toSeq.sortBy(_._2).head
    this.adjustmentDateList.find(_.id == id)
  }
}
case class AdjustmentDate(id :Long, schedule: Schedule, answerId: Seq[Long])
case class Schedule(start: LocalDateTime, end: LocalDateTime)
case class Answer(id: Long, adjustmentDateId: Long, userId: Long, status: Status)

sealed trait Status
case object OK extends Status
case object SoSo extends Status
case object NG extends Status

