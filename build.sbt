name := "akka_all"

version := "0.1"

scalaVersion := "2.13.6"

idePackagePrefix := Some("pingali.jeevan.learning.akka")

val AkkaVersion = "2.6.16"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test
)

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
