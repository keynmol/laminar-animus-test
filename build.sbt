scalaVersion := "2.13.4"

enablePlugins(ScalaJSPlugin)

scalaJSUseMainModuleInitializer := true

libraryDependencies += "com.raquo" %%% "laminar" % "0.12.2"
libraryDependencies += "io.github.kitlangton" %%% "animus" % "0.1.5"

name := "laminar-static"
