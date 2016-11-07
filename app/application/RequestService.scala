package application

import javax.inject.{Inject, Singleton}

import controllers.model.RequestList
import domain.factory.AdjustmentFactory

/**
  * Created by Fumiyasu on 2016/11/06.
  */
@Singleton
class RequestService @Inject()() {
  def newRequest(request: RequestList) = AdjustmentFactory.newAdjustment(request.userName, request.title, request.dates)
}
