ThisBuild / scalaVersion := "3.3.7"
ThisBuild / organization := "org.example"
ThisBuild / version      := "0.1.0-SNAPSHOT"

// TODO: switch to a released version and remove this resolver
resolvers += "Sonatype Central Snapshots" at "https://central.sonatype.com/repository/maven-snapshots/"
val scalusVersion = "0.16.0+259-683121c7-SNAPSHOT"

lazy val root = (project in file("."))
    .enablePlugins(ScalusBlueprintPlugin)
    .settings(
        name := "escrow",
        Compile / scalaSource := baseDirectory.value,
        Compile / unmanagedSourceDirectories := Seq(baseDirectory.value),
        Compile / unmanagedSources / excludeFilter := new SimpleFileFilter(_.toPath.startsWith((baseDirectory.value / "test").toPath)),
        Test / scalaSource := baseDirectory.value / "test",
        Test / unmanagedSourceDirectories := Seq(baseDirectory.value / "test"),
        scalacOptions ++= Seq("-deprecation", "-feature"),
        addCompilerPlugin(("org.scalus" %% "scalus-plugin" % scalusVersion).cross(CrossVersion.full)),
        libraryDependencies ++= Seq(
            "org.scalus" %% "scalus"                % scalusVersion,
            "org.scalus" %% "scalus-cardano-ledger" % scalusVersion,
            "org.scalus" %% "scalus-testkit"         % scalusVersion % Test,
            "org.scalatest" %% "scalatest"           % "3.2.19"     % Test,
            "org.scalus" %% "scalus-bloxbean-cardano-client-lib" % scalusVersion
        )
    )
