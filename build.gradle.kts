plugins {
  id(libs.plugins.kotlin.jvm.get().pluginId) apply false
  id("aoc-ktfmt")
}

tasks {
  wrapper {
    distributionType = Wrapper.DistributionType.ALL
  }
}
