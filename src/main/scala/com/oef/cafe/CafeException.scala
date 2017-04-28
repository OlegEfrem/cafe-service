package com.oef.cafe

case class CafeException(message: String, cause: Throwable) extends Exception(message, cause) {
  // scalastyle:off
  def this(message: String) = this(message, null)

  def this(cause: Throwable) = this(null, cause)

  // scalastyle:on
}
