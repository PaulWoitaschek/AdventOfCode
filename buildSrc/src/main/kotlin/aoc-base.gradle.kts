import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
  kotlin("plugin.power-assert")
  id("aoc-ktfmt")
}

kotlin {
  jvmToolchain(17)
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
powerAssert {
  functions.addAll(
    "kotlin.assert",
    "kotlin.test.assertEquals",
    "kotlin.test.assertTrue",
    "kotlin.test.assertFalse",
  )
}

dependencies {
  val libs = versionCatalogs.named("libs")
  fun lib(name: String): Provider<MinimalExternalModuleDependency> {
    return libs.findLibrary(name).get()
  }
  implementation(lib("serialization"))
  implementation(lib("coroutines"))
  testImplementation(kotlin("test"))
  testImplementation(lib("jupiter"))
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks {
  withType<KotlinCompile>().configureEach {
    compilerOptions {
      optIn.add("kotlin.ExperimentalStdlibApi")
    }
  }
  withType<Test>().configureEach {
    useJUnitPlatform()
  }
}
