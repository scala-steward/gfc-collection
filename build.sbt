
name := "gfc-collection"

organization := "org.gfccollective"

scalaVersion := "2.13.4"

crossScalaVersions := Seq(scalaVersion.value, "2.12.13")

scalacOptions += "-target:jvm-1.8"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.5" % Test,
  "org.scalatestplus" %% "scalacheck-1-15" % "3.2.4.0" % Test,
  "org.scalacheck" %% "scalacheck" % "1.15.3" % Test
)

releaseCrossBuild := true

releasePublishArtifactsAction := PgpKeys.publishSigned.value

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("Apache-style" -> url("https://raw.githubusercontent.com/gfc-collective/gfc-collection/master/LICENSE"))

homepage := Some(url("https://github.com/gfc-collective/gfc-collection"))

pomExtra := (
  <scm>
    <url>https://github.com/gfc-collective/gfc-collection.git</url>
    <connection>scm:git:git@github.com:gfc-collective/gfc-collection.git</connection>
  </scm>
  <developers>
    <developer>
      <id>gheine</id>
      <name>Gregor Heine</name>
      <url>https://github.com/gheine</url>
    </developer>
    <developer>
      <id>ebowman</id>
      <name>Eric Bowman</name>
      <url>https://github.com/ebowman</url>
    </developer>
    <developer>
      <id>andreyk0</id>
      <name>Andrey Kartashov</name>
      <url>https://github.com/andreyk0</url>
    </developer>
  </developers>
)
