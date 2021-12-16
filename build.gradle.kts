plugins {
  kotlin("jvm") version "1.6.10"
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("io.kotest:kotest-assertions-core:5.0.1")
}

tasks {
  wrapper {
    gradleVersion = "7.3.2"
    distributionType = Wrapper.DistributionType.ALL
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
