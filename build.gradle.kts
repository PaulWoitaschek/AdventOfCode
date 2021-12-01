plugins {
  kotlin("jvm") version "1.6.0"
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("io.kotest:kotest-assertions-core:4.6.3")
}

tasks {
  wrapper {
    gradleVersion = "7.3"
  }
}

testing {
  suites {
    @Suppress("UNUSED_VARIABLE")
    val test by getting(JvmTestSuite::class) {
      useKotlinTest()
    }
  }
}
