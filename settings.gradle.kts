rootProject.name = "AdventOfCode"

pluginManagement {
  repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
    maven("https://maven.pkg.jetbrains.space/public/p/amper/amper")
  }
}

dependencyResolutionManagement {
  repositories {
    mavenCentral()
  }
}

plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version ("0.7.0")
  id("org.jetbrains.amper.settings.plugin").version("0.1.1")
}
