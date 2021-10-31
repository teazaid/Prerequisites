import com.typesafe.sbt.SbtNativePackager.packageArchetype
import sbtassembly.AssemblyPlugin.assemblySettings

name := "stock-screener"

version := "0.1"

scalaVersion := "2.13.6"

//val circeVersion = "0.14.1"
//
//libraryDependencies ++= Seq(
//  "io.circe" %% "circe-core",
//  "io.circe" %% "circe-generic",
//  "io.circe" %% "circe-parser"
//).map(_ % circeVersion)

enablePlugins(JavaAppPackaging)

mainClass in Compile := Some("dev.zaidel.ui.PrerequisitesWindow")
// the assembly settings
assemblySettings

// we specify the name for our fat jar
assemblyJarName in assembly := "prerequisites.jar"

// removes all jar mappings in universal and appends the fat jar
mappings in Universal := {
  val universalMappings = (mappings in Universal).value
  val fatJar = (assembly in Compile).value
  val filtered = universalMappings filter {
    case (file, name) =>  ! name.endsWith(".jar")
  }
  filtered :+ (fatJar -> ("lib/" + fatJar.getName))
}

// the bash scripts classpath only needs the fat jar
scriptClasspath := Seq( (assemblyJarName in assembly).value )