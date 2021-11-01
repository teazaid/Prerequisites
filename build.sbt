import com.typesafe.sbt.SbtNativePackager.packageArchetype
import sbtassembly.AssemblyPlugin.assemblySettings
import sbtassembly.AssemblyPlugin.autoImport.assemblyJarName

name := "prerequisites"

version := "0.1"

scalaVersion := "2.13.6"

libraryDependencies += "com.typesafe" % "config" % "1.4.1"

enablePlugins(JavaAppPackaging)

Compile / mainClass := Some("dev.zaidel.ui.PrerequisitesWindow")
// the assembly settings
assemblySettings

// we specify the name for our fat jar
assembly / assemblyJarName := "prerequisites.jar"

// removes all jar mappings in universal and appends the fat jar
Universal / mappings := {
  val universalMappings = (mappings in Universal).value
  val fatJar = (assembly in Compile).value
  val filtered = universalMappings filter {
    case (file, name) =>  ! name.endsWith(".jar")
  }
  filtered :+ (fatJar -> ("lib/" + fatJar.getName))
}

// the bash scripts classpath only needs the fat jar
scriptClasspath := Seq( ( assembly / assemblyJarName).value )

