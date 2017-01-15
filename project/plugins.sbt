// Play! plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.6")
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

// Scalariform for code format
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.5.1")

// Scoverage for test coverage reports
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.5")