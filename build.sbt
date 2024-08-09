ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "NewsAggregator"
  )

libraryDependencies ++= Seq(
  "org.jsoup" % "jsoup" % "1.18.1", // Adjust the version if needed
  "net.ruippeixotog" %% "scala-scraper" % "3.1.1"

)