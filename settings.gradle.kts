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
  }
}

plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version ("0.8.0")
}

include(
  ":prepare",
  ":library",
  ":2015",
  ":2016",
  ":2017",
  ":2018",
  ":2019",
  ":2020",
  ":2021",
  ":2022",
  ":2023",
)
