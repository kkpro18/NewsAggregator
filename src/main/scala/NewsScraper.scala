import org.jsoup.Jsoup

object NewsScraper {
  def main(args: Array[String]): Unit = {
    val url = "https://news.yahoo.com/"
    val doc = Jsoup.connect(url).get()
    val headlines = doc.select("stream-item-title").eachText()

    println("Latest News Headlines:")

    headlines.forEach(println)


}}

