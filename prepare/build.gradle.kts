plugins {
  id("aoc-base")
  application
}

dependencies {
  implementation(libs.clikt)
  implementation(libs.okhttp)
  implementation(libs.kotlinPoet)
}

application {
  mainClass = "PrepareKt"
}

tasks.named<JavaExec>("run") {
  standardInput = System.`in`
}
