package com.oef.cafe.util

import org.scalatest.{ Matchers, WordSpec }

class NumOpsTest extends WordSpec with Matchers {

  "round2decimals" should {

    "rounded to 2 decimal places" in {
      NumOps.round2decimals(1.237) shouldBe 1.23
    }

  }
}
