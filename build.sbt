// The project name
organization := "com.github.edgecaseberg"

name := "play-form-examples"

version := "0.0.0-SNAPSHOT" 

scalaVersion := "2.11.7"

scalacOptions := Seq("-encoding", "utf8", "-deprecation")

lazy val root = (project in file(".")).enablePlugins(PlayScala)

// Define global repository resolvers here
resolvers ++= Seq(
	"Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases",
	"Sonatype OSS Mvn2" at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
)

