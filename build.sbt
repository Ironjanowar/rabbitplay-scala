import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.4",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.5.6",
      "com.typesafe.akka" %% "akka-testkit" % "2.5.6" % Test,
      "com.newmotion" %% "akka-rabbitmq" % "4.0.0"
    )
  )
