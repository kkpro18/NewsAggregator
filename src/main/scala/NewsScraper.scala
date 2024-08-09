//import org.jsoup.Jsoup

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._


object NewsScraper {
  def main(args: Array[String]): Unit = {
//    val url = "https://news.yahoo.com/"
//    val doc = Jsoup.connect(url).get()
//    val headlines = doc.select("stream-item-title").eachText()
//    println("Latest News Headlines:")
//    headlines.forEach(println)
    val browser = JsoupBrowser()
    val doc = browser.get("https://www.scrapingcourse.com/ecommerce/")
//    val html = doc.toHtml
    val title = doc.title

    // get the first HTML product on the page
    val htmlProductElement = doc >> element("li.product")
    println(htmlProductElement)
    // extract the desired data from it
    val name = htmlProductElement >> text("h2")
    val url = htmlProductElement >> element("a") >> attr("href")
    val image = htmlProductElement >> element("img") >> attr("src")
    val price = htmlProductElement >> text("span")
    println((name, url, image, price))




  }}

