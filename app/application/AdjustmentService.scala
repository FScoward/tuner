package application

import javax.inject.{Inject, Singleton}

import controllers.model.AdjustmentView
import domain.factory.AdjustmentFactory
import domain.model.Adjustment
import infrastructure.repository.AdjustmentRepository

/**
  * Created by Fumiyasu on 2016/11/06.
  *
  * アプリケーションサービス層
  * 調整役
  */
@Singleton
class AdjustmentService @Inject()(adjustmentRepository: AdjustmentRepository) {
  def newAdjustment(adjustmentView: AdjustmentView): Adjustment = {
    val adjustment = AdjustmentFactory.newAdjustment(adjustmentView.userName, adjustmentView.title, adjustmentView.dates)
    adjustmentRepository.save(adjustment)
    adjustment
  }
}
