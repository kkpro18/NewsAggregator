import org.jsoup.Jsoup

import scala.collection.mutable.HashMap
import scala.jdk.CollectionConverters.*

object practice_scrape {

  def main(args: Array[String]): Unit = {
//    val browser = JsoupBrowser()
//    val doc = browser.get("https://www.scrapingcourse.com/ecommerce/")
//    val title = doc.title
//
//    // get the first HTML product on the page
//    val htmlProductElement = doc >> element("li.product")
//
//    println(htmlProductElement)
//    // extract the desired data from it
//    val name = htmlProductElement >> text("h2")
//    val url = htmlProductElement >> element("a") >> attr("href")
//    val image = htmlProductElement >> element("img") >> attr("src")
//    val price = htmlProductElement >> text("span")
//    println((name, url, image, price))


//    val url = "https://uk.news.yahoo.com"
//    val userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"
//    val doc = Jsoup
//      .connect(url)
//      .userAgent(userAgent)
//      .get()
//    val articleSection = doc.select("a.js-content-viewer")
////    println(articleSection)
//    val title = articleSection.text()
//    println(title)
//    val articleLink = articleSection.attr("href")
//    println(s"$url$articleLink")

      val url = "https://uk.news.yahoo.com"
      val userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"
      val doc = Jsoup
        .connect(url)
        .userAgent(userAgent)
        .get()
      val articleSections = doc.select("a.js-content-viewer") // scrapes fine and loads lot of news but as one text needs to be split
//      val articleSections = articleSections1.split("</a>") // split method not working
      var articleTitles = List[String]()
      var articleLinks = List[String]()
      println(articleSections)
      for (articleSection <- articleSections.iterator().asScala
      ){
        println(articleSection)
        println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
      }
      for (articleSection <- articleSections.iterator().asScala) {
        val articleTitle = articleSection.text()
        val path = articleSection.attr("href")
        if (!(url contains path)) {
          val articleLink = s"$url$path"
          articleLinks = articleLink +: articleLinks
        } else {
          val articleLink = s"$url"
          articleLinks = articleLink +: articleLinks
        }
        articleTitles = articleTitle +: articleTitles
      }
    println(articleTitles)
    println(articleLinks)
    println(articleTitles.length)
    println(articleLinks.length)

//    val url = "https://uk.news.yahoo.com"
//
//    val userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"
//
//    val doc = Jsoup
//      .connect(url)
//      .userAgent(userAgent)
//      .get()
//
//    val articleSections = doc.select("a.js-content-viewer")
//
//    val todayNewsStories = HashMap[String, String]()
//
//    for (articleSection <- articleSections.iterator().asScala) {
//        val articleTitle = articleSection.text()
//        val path = articleSection.attr("href")
//        val articleLink = if (!(path contains url)) {
//          s"$url$path"
//        } else {
//          s"$url"
//        }
//        todayNewsStories += (articleLink -> articleTitle)
//      }
//    println(todayNewsStories.size)

  }



}
