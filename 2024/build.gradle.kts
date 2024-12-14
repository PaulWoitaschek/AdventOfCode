plugins {
  id("aoc")
  alias(libs.plugins.jetbrains.compose)
  alias(libs.plugins.compose.compiler)
}

dependencies {
  implementation(compose.desktop.common)
  implementation(compose.desktop.currentOs)
}
