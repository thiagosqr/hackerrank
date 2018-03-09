name := "hackerrank"

version := "1.0"

scalaVersion := "2.12.4"

libraryDependencies := Seq(
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "io.reactivex" % "rxjava" % "1.1.6",
  "com.google.code.gson" % "gson" % "2.8.2",
  "com.typesafe.play" %% "play-ahc-ws-standalone" % "1.1.6",
  "com.typesafe.play" %% "play-ws-standalone-json" % "1.1.6"
)

fork in run := true


