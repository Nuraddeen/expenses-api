
name := "expenses-api"

version := "1.0"

scalaVersion := "2.13.3"

val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.4"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "org.scalatest" %% "scalatest" % "3.2.7" % "test",
  "com.typesafe.akka" %% "akka-stream-testkit" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % AkkaHttpVersion,
  "org.xerial" % "sqlite-jdbc" % "3.28.0",
  "io.getquill" %% "quill-jdbc" % "3.7.1",
  "de.heikoseeberger" %% "akka-http-circe" % "1.31.0",
  "io.circe" %% "circe-core" % "0.14.0-M1",
  "io.circe" %% "circe-generic" % "0.14.0-M1",
  "io.circe" %% "circe-parser" % "0.14.0-M1",
)

