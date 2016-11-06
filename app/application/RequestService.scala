package application

import javax.inject.{Inject, Singleton}

import controllers.model.RequestList
import domain.factory.RequestFactory

/**
  * Created by Fumiyasu on 2016/11/06.
  */
@Singleton
class RequestService @Inject()() {
  def newRequest(request: RequestList): domain.model.RequestList = {
    RequestFactory.newRequest(request.title, request.userName, request.dates)
  }
}
