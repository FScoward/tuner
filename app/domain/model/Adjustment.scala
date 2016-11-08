package domain.model
import java.time.LocalDateTime

import play.api.Logger

trait Adjustment {
  val id: Long
  val title: String
  val adjustmentDateList: Seq[AdjustmentDate]
  def determine = {
    val x = for {
      a <- adjustmentDateList
    } yield {
      val count = a.answer.filter(_.status == OK).length
      (a, count)
    }
    x.sortBy(_._2).head._1
  }
}
case class AdjustmentImp(id: Long, title: String, adjustmentDateList: Seq[AdjustmentDate]) extends Adjustment {
  Logger.debug(s"================> create Adjustment Implement")
}

trait AdjustmentDate {
  val id: Long
  val schedule: Schedule
  val answer: Seq[Answer]
}
case class AdjustmentDateImp(id :Long, schedule: Schedule, answer: Seq[Answer]) extends AdjustmentDate

trait Answer {
  val id: Long
  val userId: Long
  val status: Status
}
case class AnswerImp(id: Long, userId: Long, status: Status) extends Answer

trait Schedule {
  val start: LocalDateTime
  val end: LocalDateTime
}
case class ScheduleImp(start: LocalDateTime, end: LocalDateTime) extends Schedule

sealed trait Status
case object OK extends Status
case object SoSo extends Status
case object NG extends Status

