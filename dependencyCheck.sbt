
lazy val failOnSnapshot = settingKey[Boolean]("Whether or not to fail a build if a dependency has a snapshot")

val warningOnlySnapshotChecks = Seq(Compile, Test, Runtime) flatMap { conf =>
	inConfig(conf)(Seq(failOnSnapshot := false))
}

val failBuildOnSnapshot = UniversalPlugin.projectConfigurations flatMap { conf =>
	inConfig(conf)(Seq(failOnSnapshot := true))	
}

failOnSnapshot in packageOptions := true

// SBT Task to verify that we are not depending on any SNAPSHOT versions
val snapshotDependencyCheck = taskKey[Unit]("Warns when project depends on any SNAPSHOT versions") 
snapshotDependencyCheck := { 
	val s: TaskStreams = streams.value
	val snapshotDependencies = (libraryDependencies in Compile).value
	s.log.info("Beginning SNAPSHOT Dependency Check...")
	val badDependencies = snapshotDependencies.filter { moduleID =>
		moduleID.jar.revision.contains("SNAPSHOT")
	}.map(_.jar)
	if(badDependencies.isEmpty) {
		s.log.info("No snapshot dependencies detected")
	} else {
		val failOnTheSnapshot = (failOnSnapshot ?? false).value
		val errorString = "\nShould not depend on SNAPSHOT versions for artifacts:\n%s".format(badDependencies.mkString("\n"))
		if(failOnTheSnapshot) {
			error(errorString)
		} else {
			s.log.warn(errorString)
		}
	}
}

// include SBT tasks as compilation requirements
compile <<= (compile in Compile).dependsOn(snapshotDependencyCheck)

test <<= (test in Test).dependsOn(snapshotDependencyCheck)

dist <<= (dist in Universal).dependsOn(snapshotDependencyCheck)
