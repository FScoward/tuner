package controllers.model

import java.time.LocalDateTime

import play.api.libs.json.Json

/**
  * Created by Fumiyasu on 2016/11/06.
  */
case class RequestList (title: String, userName: String, dates: List[LocalDateTime])
object RequestList {
  implicit val reads = Json.reads[RequestList]
}

