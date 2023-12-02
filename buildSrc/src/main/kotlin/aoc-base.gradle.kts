import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
}

kotlin {
  jvmToolchain(21)
}

dependencies {
  val libs = versionCatalogs.named("libs")
  fun lib(name: String): Provider<MinimalExternalModuleDependency> {
    return libs.findLibrary(name).get()
  }
  implementation(lib("serialization"))
  implementation(lib("coroutines"))
  testImplementation(lib("kotest"))
  testImplementation(lib("jupiter.api"))
  testRuntimeOnly(lib("jupiter.engine"))
}

tasks {
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
