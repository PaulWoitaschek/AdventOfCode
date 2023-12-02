plugins {
  id(libs.plugins.kotlin.jvm.get().pluginId) apply false
  id(libs.plugins.ktlint.get().pluginId)
}

ktlint {
  version.set(libs.ktlint.map { it.version!! })
}

tasks {
  wrapper {
    distributionType = Wrapper.DistributionType.ALL
  }
}
