rootProject.name = "AdventOfCode"

pluginManagement {
  repositories {
    gradlePluginPortal()
  }
}

dependencyResolutionManagement {
  repositories {
    mavenCentral()
  }
}

plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version ("0.7.0")
}
