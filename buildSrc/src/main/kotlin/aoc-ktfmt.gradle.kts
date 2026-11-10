plugins {
  id("com.diffplug.spotless")
}

val ktfmtVersion = versionCatalogs.named("libs").findVersion("ktfmt").get().requiredVersion

spotless {
  kotlin {
    target("src/**/*.kt")
    ktfmt(ktfmtVersion).googleStyle()
  }
  kotlinGradle {
    target("*.kts")
    ktfmt(ktfmtVersion).googleStyle()
  }
}
