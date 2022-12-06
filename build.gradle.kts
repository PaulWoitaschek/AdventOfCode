import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.kotlin.allopen)
  alias(libs.plugins.jmh)
}

allOpen {
  annotation("org.openjdk.jmh.annotations.State")
}

dependencies {
  testImplementation(libs.kotest)
  testImplementation(libs.jupiter.api)
  testRuntimeOnly(libs.jupiter.engine)
}

jmh {
  // includes.add("Day6Benchmark")

  warmup.set("2s")
  warmupIterations.set(1)
  warmupForks.set(1)

  fork.set(2)
  iterations.set(2)
  timeOnIteration.set("3s")

  benchmarkMode.set(listOf("avgt"))

  timeUnit.set("ms")
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
