package com.collectiive.ifttt.objectmapper

/**
 * @author Sujith
 */
trait ObjectMapper {

  def serialize[T](obj: T): String

  def deserialize[T](json: String)(implicit manifest: Manifest[T]): T
}
