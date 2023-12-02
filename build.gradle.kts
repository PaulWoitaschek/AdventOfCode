plugins {
  id(libs.plugins.kotlin.jvm.get().pluginId) apply false
  alias(libs.plugins.ktlint)
}

ktlint {
  version.set(libs.ktlint.map { it.version!! })
}

tasks {
  wrapper {
    distributionType = Wrapper.DistributionType.ALL
  }
}
