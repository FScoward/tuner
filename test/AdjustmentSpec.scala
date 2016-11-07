import java.time.LocalDateTime

import domain.model.{AdjustmentDateImp, ScheduleImp}
import org.scalatestplus.play.PlaySpec

/**
  * Created by Fumiyasu on 2016/11/08.
  */
class AdjustmentSpec extends PlaySpec {
  "" should {
    "" in {
      AdjustmentDateImp(0L, ScheduleImp(LocalDateTime.now(), LocalDateTime.now()))
    }
  }
}
