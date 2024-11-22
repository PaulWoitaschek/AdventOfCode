import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
  id("org.jlleitschuh.gradle.ktlint")
  `jvm-test-suite`
}

kotlin {
  jvmToolchain(17)
}

ktlint {
  version.set(
    versionCatalogs
      .named("libs")
      .findLibrary("ktlint").get().map { it.version!! },
  )
}

dependencies {
  val libs = versionCatalogs.named("libs")
  fun lib(name: String): Provider<MinimalExternalModuleDependency> {
    return libs.findLibrary(name).get()
  }
  implementation(lib("serialization"))
  implementation(lib("coroutines"))
  testImplementation(lib("kotest"))
}

tasks {
  withType<KotlinCompile>().configureEach {
    compilerOptions {
      optIn.add("kotlin.ExperimentalStdlibApi")
    }
  }
}

testing {
  suites {
    val test by getting(JvmTestSuite::class) {
      useJUnitJupiter()
    }
  }
}
