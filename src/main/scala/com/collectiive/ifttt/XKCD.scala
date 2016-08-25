package com.collectiive.ifttt

import java.io.{InputStreamReader, InputStream}
import java.net.{HttpURLConnection, URL}
import java.util.Scanner

import com.collectiive.ifttt.objectmapper.Json4sObjectMapper

/**
 * @author suj1th
 */
class XKCD {


}

object XKCD{

  /*{"month": "8", "num": 1724, "link": "", "year": "2016", "news": "", "safe_title": "Proofs",
   "transcript": "", "alt": "Next, let's assume the decision of whether to take the Axiom of
   Choice is made by a deterministic process ...", "img": "http:\/\/imgs.xkcd.com\/comics\/proofs.png",
   "title": "Proofs", "day": "24"}*/
  case class XkcdInfo(month: String, num: Int, link: String, year: String, news: String, safe_title: String,
                       transcript: String, alt: String,img: String, title: String, day: String )

  def latestComicNumber: Int = {
    val url = new URL("http://xkcd.com/info.0.json")
    val request =  url.openConnection().asInstanceOf[HttpURLConnection];
    request.connect();

    val scanner: Scanner = new Scanner(new InputStreamReader(request.getContent.asInstanceOf[InputStream])).useDelimiter("\\A");
    val result: String =scanner.hasNext match {case true => scanner.next(); case false => "{}"}
    val objectMapper = new Json4sObjectMapper
    val info = objectMapper.deserialize[XkcdInfo](result)
    println(result)
    info.num
  }
  
}
