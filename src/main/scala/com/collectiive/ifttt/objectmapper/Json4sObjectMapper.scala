package com.collectiive.ifttt.objectmapper


import com.collectiive.ifttt.XKCD.XkcdInfo
import org.json4s._
import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization.{read, write}


/**
 * @author Sujith
 */
class Json4sObjectMapper extends ObjectMapper {

  implicit val formats = Serialization.formats(
    ShortTypeHints(
      List(
        classOf[XkcdInfo]
      )
    )
  )


  override def serialize[T](obj: T): String = write(obj.asInstanceOf[AnyRef])

  override def deserialize[T](json: String)(implicit manifest: Manifest[T]): T = read[T](json)

}
