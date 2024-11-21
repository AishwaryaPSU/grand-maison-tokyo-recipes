version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.17"

sbtVersion := "1.5.5"

lazy val root = (project in file("."))
  .settings(
    name := "GrandMaisonTokyo"
  )

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % "2.6.20",
  "com.typesafe.akka" %% "akka-http" % "10.2.10",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.2.10",
  "org.slf4j" % "slf4j-simple" % "1.7.36",
  "com.typesafe.slick" %% "slick" % "3.5.0"


)
dependencyOverrides += "com.typesafe.sbt" % "sbt-native-packager" % "1.9.4"
dependencyOverrides += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.0.0"

resolvers ++= Resolver.sonatypeOssRepos("snapshots")
resolvers += Resolver.jcenterRepo
resolvers += Resolver.bintrayRepo("akka", "maven")
resolvers += Resolver.mavenCentral

