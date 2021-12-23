ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.7"

lazy val root = (project in file("."))
  .settings(
    name := "Lab6_Gaussian",
    idePackagePrefix := Some("pl.tw.lab6")
  )
