import org.jsoup.Jsoup

object practice_scrape {

  import org.jsoup.Jsoup
  import org.jsoup.nodes.Document
  import scala.util.matching.Regex


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
      val articleSections1 = doc.select("a.js-content-viewer") // scrapes fine and loads lot of news but as one text needs to be split
      val articleSections = articleSections1.split("</a>") // split method not working

      var articleTitles = List[String]()
      var articleLinks = List[String]()
      println(articleSections)
      for (articleSection <- articleSections) {
        val title = articleSection.text()
        val path = articleSection.attr("href")
        val articleLink = s"$url$path"
        articleTitles = articleTitle :: articleTitles
        articleLinks = articleLink :: articleLinks
      }
    println(articleTitles)
    println(articleLinks)

  }



}
