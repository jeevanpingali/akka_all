name := "akka_all"

version := "0.1"

scalaVersion := "2.13.6"

//idePackagePrefix := Some("pingali.jeevan.learning.akka")

/*
lazy val buildSettings = Seq(
  organization        := "pingali.jeevan.learning.akka",
  version             := "1.0-SNAPSHOT"
)
*/

val AkkaVersion = "2.6.16"
resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test
)

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.6"

libraryDependencies += "pingali.jeevan.learning.protocol_buffers" % "all_events" % "1.0-SNAPSHOT"
