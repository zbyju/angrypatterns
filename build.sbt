name := "angrypatterns"
organization := "fit"
version := "0.1-SNAPSHOT"

scalaVersion := "3.3.0"

libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "20.0.0-R31",
  "org.scalatest" %% "scalatest" % "3.2.15" % "test"
)

// Fork a new JVM for 'run' and 'test:run' to avoid JavaFX double initialization problems
fork := true
