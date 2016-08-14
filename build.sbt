name := "pixelated-avatar-generator"

version := "0.0.1"

scalaVersion := "2.11.0"

resolvers ++= Seq(
  "RoundEights" at "http://maven.spikemark.net/roundeights"
)

libraryDependencies ++= Seq(
  "com.roundeights" %% "hasher" % "1.2.0",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.2" % "test"
)
