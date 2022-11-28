import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  alias(libs.plugins.kotlin)
}

dependencies {
  testImplementation(libs.kotest)
  testImplementation(libs.jupiter.api)
  testRuntimeOnly(libs.jupiter.engine)
}

tasks {
  wrapper {
    distributionType = Wrapper.DistributionType.ALL
  }
  withType<KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += listOf(
      "-opt-in=kotlin.RequiresOptIn",
      "-opt-in=kotlin.ExperimentalStdlibApi"
    )
  }
  withType<Test>().configureEach {
    useJUnitPlatform()
  }
}
