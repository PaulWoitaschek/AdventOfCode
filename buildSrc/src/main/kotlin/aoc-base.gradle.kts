import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
  id("org.jlleitschuh.gradle.ktlint")
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
