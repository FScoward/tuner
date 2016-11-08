package infrastructure.repository

import javax.inject.Singleton

import domain.model.Adjustment

/**
  * Created by fumiyasu.sumiya on 2016/11/08.
  */
trait AdjustmentRepository {
  def resolveBy(id: Long): Adjustment
  def save(adjustment: Adjustment)
}

@Singleton
class AdjustmentDBRepository extends AdjustmentRepository {
  def resolveBy(id: Long) = ???
  def save(adjustment: Adjustment) = {
    Unit
  }
}