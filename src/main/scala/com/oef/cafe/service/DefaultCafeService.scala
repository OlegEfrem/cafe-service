package com.oef.cafe.service

import com.oef.cafe.{ CafeService, model }
import com.oef.cafe.model.MenuItem

private[cafe] class DefaultCafeService extends CafeService {

  override def serviceCharge(items: Seq[MenuItem]) = {
    import com.oef.cafe.util.NumOps._
    val sc = fullServiceCharge(items)
    if (sc > 20) 20
    else round2decimals(sc)
  }

  private def fullServiceCharge(items: Seq[MenuItem]): Double = {
    val standardPrice = standardBillFor(items)
    val modelItems = toModel(items)
    if (modelItems.forall(_.isDrink)) 0
    else if (modelItems.exists(_.isHotFood)) standardPrice * 0.2
    else standardPrice * 0.1
  }

  override def standardBillFor(items: Seq[MenuItem]) = {
    toModel(items).view.map(_.price).sum
  }

  private def toModel(items: Seq[MenuItem]): Seq[model.MenuItem] = items.map(name => MenuItem(name))

}
