package domain.model
import java.time.LocalDateTime

import play.api.Logger

/** ドメインモデル */
case class Adjustment(id: Long, title: String, adjustmentDateList: Seq[AdjustmentDate]) {
  Logger.debug(s"================> create Adjustment Implement")
  def determine = {
    val x = for {
      a <- adjustmentDateList
    } yield {
      val count = a.answer.filter(_.status == OK).length
      (a, count)
    }
    x.sortBy(_._2).head._1
  }

  def addAnswer(adjustmentDateId: Long, answer: Answer): Adjustment = {
    val result = for {
      adjustmentDate <- adjustmentDateList
    } yield {
      adjustmentDate.id == adjustmentDateId match {
        case true => adjustmentDate.addAnswer(answer)
        case _ => adjustmentDate
      }
    }
    this.copy(adjustmentDateList = result)
  }
}

case class AdjustmentDate(id :Long, schedule: Schedule, answer: Seq[Answer]) {
  def addAnswer(answer: Answer): AdjustmentDate = {
    this.answer.find(_.userId == answer.userId) match {
      case Some(_) =>
        this
      case None =>
        this.copy(answer = this.answer :+ answer)
    }
  }
}

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

