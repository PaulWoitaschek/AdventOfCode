import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.ktlint)
}

dependencies {
  implementation(libs.serialization)
  testImplementation(libs.kotest)
  testImplementation(libs.jupiter.api)
  testRuntimeOnly(libs.jupiter.engine)
}

ktlint {
  version.set(libs.ktlint.map { it.version!! })
}

kotlin {
  jvmToolchain(21)
}

tasks {
  wrapper {
    distributionType = Wrapper.DistributionType.ALL
  }
  withType<KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += listOf(
      "-opt-in=kotlin.RequiresOptIn",
      "-opt-in=kotlin.ExperimentalStdlibApi",
    )
  }
  withType<Test>().configureEach {
    useJUnitPlatform()
  }
}
