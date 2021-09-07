ThisBuild / scalaVersion := "2.13.3"
ThisBuild / organization := "com.example"

lazy val hello = (project in file("."))
  .settings(
    scalacOptions ++= Seq(
      "-encoding", "utf8", // Option and arguments on same line
      "-Xfatal-warnings", // New lines for each options
      "-deprecation",
      "-unchecked",
      "-language:implicitConversions",
      "-language:higherKinds",
      "-language:existentials",
      "-language:postfixOps"
    ),
    libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.4.2",
    libraryDependencies += "com.typesafe.play" %% "play-json" % "2.10.0-RC5",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % Test,
    /* These dependencies don't work for me, yet. */
    libraryDependencies += "io.rest-assured" % "rest-assured" % "4.4.0",
    libraryDependencies += "junit" % "junit" % "4.13.2" % Test,
    libraryDependencies += "io.rest-assured" % "scala-support" % "4.4.0" % Test,
    Compile / run / mainClass := Some("WebReq")
  )