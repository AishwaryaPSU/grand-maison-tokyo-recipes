version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.17"

sbtVersion := "0.13"

lazy val root = (project in file("."))
  .settings(
    name := "GrandMaisonTokyo"
  )

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % "2.6.20", // Newer Akka version
  "com.typesafe.akka" %% "akka-http" % "10.2.10",       // Newer Akka HTTP version
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.2.10",
  "com.typesafe.akka" %% "akka-stream" % "2.6.20", // Akka Streams version (match the Akka version)
  "org.slf4j" % "slf4j-simple" % "1.7.36"

)

resolvers ++= Resolver.sonatypeOssRepos("snapshots")
resolvers += Resolver.jcenterRepo
resolvers += Resolver.bintrayRepo("akka", "maven")
resolvers += Resolver.mavenCentral

