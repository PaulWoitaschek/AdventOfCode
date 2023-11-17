import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.kotlin.allopen)
  alias(libs.plugins.benchmark)
  alias(libs.plugins.compose)
  alias(libs.plugins.ktlint)
}

allOpen {
  annotation("org.openjdk.jmh.annotations.State")
}

sourceSets.create("benchmarks")

dependencies {
  implementation(libs.serialization)
  testImplementation(libs.kotest)
  testImplementation(libs.jupiter.api)
  add("benchmarksImplementation", libs.benchmark)
  testRuntimeOnly(libs.jupiter.engine)
  implementation(compose.desktop.currentOs)

  add(
    "benchmarksImplementation",
    sourceSets.main.get().output +
      sourceSets.main.get().runtimeClasspath +
      sourceSets.test.get().output +
      sourceSets.test.get().runtimeClasspath,
  )
}

compose.desktop {
  application {
    mainClass = "ComposeKt"
  }
}

benchmark {
  targets {
    register("benchmarks")
  }
  configurations {
    named("main") {
      outputTimeUnit = "ms"
      mode = "avgt"
    }
  }
}

ktlint{
  ktlintVersion.set(libs.ktlint.map { it.version })
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
