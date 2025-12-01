rootProject.name = "AdventOfCode"

pluginManagement {
  repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
  }
}

dependencyResolutionManagement {
  repositories {
    mavenCentral()
    google()
  }
}

plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version ("1.0.0")
}

include(":prepare", ":library")
include((2015..2025).map { year -> ":$year" })
