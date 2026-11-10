plugins {
  `kotlin-dsl`
}

dependencies {
  implementation(libs.kotlin.jvmPlugin)
  implementation(libs.kotlin.powerAssertPlugin)
  implementation(libs.spotless.gradlePlugin)
}
