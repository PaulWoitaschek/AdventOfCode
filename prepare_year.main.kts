#!/usr/bin/env kotlin
@file:DependsOn("com.github.ajalt.clikt:clikt-jvm:4.2.1")

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import com.github.ajalt.clikt.parameters.types.int
import java.io.File
import java.time.LocalDate

class App : CliktCommand() {

  private val year: Int by option().int().prompt(default = LocalDate.now().year)
  private val singleDay: Int? by option().int()

  override fun run() {
    val singleDay = singleDay
    if (singleDay != null) {
      write(singleDay)
    } else {
      (1..26).forEach { day ->
        write(day)
      }
    }
  }

  private fun write(day: Int) {
    writeSources(day)
    writeResources(day)
    writeTests(day)
  }

  private fun writeTests(day: Int) {
    val sourceFolder = File("src/test/kotlin/de/woitaschek/aoc/year$year")
      .also { it.mkdirs() }
    File(sourceFolder, "Day${day}Test.kt")
      .writeTextIfNotExists(
        // language=kotlin
        """
        package de.woitaschek.aoc.year$year

        import de.woitaschek.aoc.test
        import org.junit.jupiter.api.Test

        class Day${day}Test {

          @Test
          fun test() {
            Day$day.test(
              part1Test = null,
              part1 = null,
              part2Test = null,
              part2 = null,
            )
          }
        }

        """.trimIndent(),
      )
  }

  private fun writeResources(day: Int) {
    val folder = File("src/main/resources/$year")
      .also { it.mkdirs() }
    File(folder, "day$day.txt").createNewFile()
    File(folder, "day${day}test.txt").createNewFile()
  }

  private fun writeSources(day: Int) {
    val sourceFolder = File("src/main/kotlin/de/woitaschek/aoc/year$year")
      .also { it.mkdirs() }
    File(sourceFolder, "Day$day.kt")
      .writeTextIfNotExists(
        // language=kotlin
        """
                package de.woitaschek.aoc.year$year

                import de.woitaschek.aoc.utils.Puzzle

                object Day$day : Puzzle($year, $day) {

                  override fun solvePart1(input: String): Int {
                    TODO()
                  }

                  override fun solvePart2(input: String): Int {
                    TODO()
                  }
                }

        """.trimIndent(),
      )
  }

  private fun File.writeTextIfNotExists(text: String) {
    if (exists()) {
      println("File $this exists. Don't overwrite")
    } else {
      writeText(text)
    }
  }
}

App().main(args)
