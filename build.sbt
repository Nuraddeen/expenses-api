
name := "Expenses-API"

version := "1.0"

scalaVersion := "2.13.3"

val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.4"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,

  //quill stufss
  "org.xerial" % "sqlite-jdbc" % "3.28.0",
  "io.getquill" %% "quill-jdbc" % "3.7.1",
  "org.postgresql" % "postgresql" % "42.2.8", 
  "de.heikoseeberger" %% "akka-http-circe" % "1.31.0",


  // Start with this one
  "org.tpolecat" %% "doobie-core"      % "0.12.1",

  // And add any of these as needed
  "org.tpolecat" %% "doobie-h2"        % "0.12.1",          // H2 driver 1.4.200 + type mappings.
  "org.tpolecat" %% "doobie-hikari"    % "0.12.1",          // HikariCP transactor.
  "org.tpolecat" %% "doobie-postgres"  % "0.12.1",          // Postgres driver 42.2.19 + type mappings.
  "org.tpolecat" %% "doobie-quill"     % "0.12.1",          // Support for Quill 3.6.1
  "org.tpolecat" %% "doobie-specs2"    % "0.12.1" % "test", // Specs2 support for typechecking statements.
  "org.tpolecat" %% "doobie-scalatest" % "0.12.1" % "test",  // ScalaTest support for typechecking statements.

  "io.circe" %% "circe-core" % "0.14.0-M1",
  "io.circe" %% "circe-generic" % "0.14.0-M1",
  "io.circe" %% "circe-parser" % "0.14.0-M1"
)

