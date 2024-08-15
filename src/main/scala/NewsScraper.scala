import org.jsoup.Jsoup

import scala.collection.mutable
import scala.collection.mutable.HashMap
import scala.jdk.CollectionConverters.*


object NewsScraper {
  def main(args: Array[String]): Unit = {

    val todayNewsStories = HashMap[String, String]()

    val userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"

    val url = "https://uk.news.yahoo.com"
    val doc = Jsoup
      .connect(url)
      .userAgent(userAgent)
      .get()
    val articleSections = doc.select("a.js-content-viewer")


    for (articleSection <- articleSections.iterator().asScala) {
      val articleTitle = articleSection.text()
      val path = articleSection.attr("href")
      val articleLink = if (!(path contains url)) {
        s"$url$path"
      } else {
        s"$url"
      }
      todayNewsStories += (articleLink -> articleTitle)
    }
    println(todayNewsStories)
    println(s"Total News Stories Scraped from ${url.stripPrefix("https://") } : ${todayNewsStories.size}")

    val api_key = "pub_50665991203b6d7449e05b4edaf846d8ab0aa"
    val search_term = "riot"
    val category = "crime"
    //      val url = s"https://newsdata.io/api/1/news?apikey=$api_key&q=$searchTermq&category=$category"


  }}

