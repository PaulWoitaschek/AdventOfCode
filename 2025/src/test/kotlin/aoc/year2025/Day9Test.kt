package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day9Test {
  private val testInput: String = """
    7,1
    11,1
    11,7
    9,7
    9,5
    2,5
    2,3
    7,3
  """.trimIndent()

  @Test
  fun part1TestInput() {
    Day9.solvePart1(testInput) shouldBeExactly 50
  }

  @Test
  fun part1() {
    Day9.solvePart1() shouldBeExactly 4725826296
  }

  @Test
  @Disabled
  fun part2TestInput() {
    Day9.solvePart2(testInput) shouldBeExactly 42
  }

  @Test
  @Disabled
  fun part2() {
    Day9.solvePart2() shouldBeExactly 42
  }
}
