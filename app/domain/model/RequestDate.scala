package domain.model
import java.time.LocalDateTime

/** 提示する日付一覧 */
case class RequestList(id: Long, userName: String, title: String, requestDateList: Seq[RequestDate])

/** 予定日 */
case class RequestDate(id: Long, date: LocalDateTime)

/** 回答 */
case class AnswerDate(requestDateId: Long, answer: Status, userName: String)

sealed trait Status
case object OK extends Status
case object SoSo extends Status
case object NG extends Status

