#!/usr/bin/env kotlin
@file:DependsOn("com.github.ajalt.clikt:clikt-jvm:4.2.1")

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.terminal
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import com.github.ajalt.clikt.parameters.types.int
import java.io.File
import java.time.LocalDate

class App : CliktCommand() {

  private val year: Int by option().int().prompt(default = LocalDate.now().year)
  private val day: Int by option().int().prompt(default = LocalDate.now().dayOfMonth)

  override fun run() {
    writeTestInput()
    val singleDay = day
    write(singleDay)
  }

  private fun write(day: Int) {
    writeSources(day)
    writeTests(day)
    writeTestInput()
  }

  private fun writeTestInput() {
    val testInputFile = File("$year/src/main/resources/$year/$day-test.txt")
    if (testInputFile.exists()) {
      println("Test input $testInputFile exists already. Don't overwrite")
      return
    }
    val testInput = terminal.prompt("Test input")
    if (testInput == null) {
      println("No test input given. Don't overwrite")
    } else {
      testInputFile.parentFile.mkdirs()
      testInputFile.writeText(testInput)
    }
  }

  private fun writeTests(day: Int) {
    val sourceFolder = File("$year/src/test/kotlin/aoc/year$year")
      .also { it.mkdirs() }
    File(sourceFolder, "Day${day}Test.kt")
      .writeTextIfNotExists(
        // language=kotlin
        """
        package aoc.year$year

        import aoc.library.solvePart1
        import aoc.library.solvePart2
        import io.kotest.matchers.ints.shouldBeExactly
        import org.junit.jupiter.api.Test

        class Day${day}Test {

          private val testInput = ""${'"'}

          ""${'"'}.trimIndent()

          @Test
          fun part1() {
            Day$day.solvePart1() shouldBeExactly 42
          }

          @Test
          fun part1TestInput() {
            Day$day.solvePart1(testInput) shouldBeExactly 42
          }

          @Test
          fun part2() {
            Day$day.solvePart2() shouldBeExactly 42
          }

          @Test
          fun part2TestInput() {
            Day$day.solvePart2(testInput) shouldBeExactly 42
          }
        }
        """.trimIndent(),
      )
  }

  private fun writeSources(day: Int) {
    val sourceFolder = File("$year/src/main/kotlin/aoc/year$year")
      .also { it.mkdirs() }
    File(sourceFolder, "Day$day.kt")
      .writeTextIfNotExists(
        // language=kotlin
        """
                package aoc.year$year

                import aoc.library.Puzzle

                object Day$day : Puzzle<Int,Int>($year, $day) {

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
