name := "BabaScriptForScala"

organization := "com.takumibaba"

version := "0.1"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.13" % "test",
  "com.takumibaba" % "lindabaseclient_2.10" % "0.1"
)

initialCommands := "import com.takumibaba.babascriptforscala._"
