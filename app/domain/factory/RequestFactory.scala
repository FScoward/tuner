package domain.factory

import java.time.LocalDateTime

import domain.model.{RequestDate, RequestList}


/**
  * Created by Fumiyasu on 2016/11/06.
  */
object RequestFactory {
  def newRequest(userName: String, title: String, dates: Seq[LocalDateTime]): RequestList = {
    val requestDateList = dates.map(d => RequestDate(0L, d))
    RequestList(0L, userName, title, requestDateList)
  }
}
