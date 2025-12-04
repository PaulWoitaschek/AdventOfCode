package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.ints.shouldBeExactly
import org.junit.jupiter.api.Test

class Day4Test {

  private val testInput = """
      ..@@.@@@@.
      @@@.@.@.@@
      @@@@@.@.@@
      @.@@@@..@.
      @@.@@@@.@@
      .@@@@@@@.@
      .@.@.@.@@@
      @.@@@.@@@@
      .@@@@@@@@.
      @.@.@@@.@.
  """.trimIndent()

  @Test
  fun part1TestInput() {
    Day4.solvePart1(
      testInput,
    ) shouldBeExactly 13
  }

  @Test
  fun part1() {
    Day4.solvePart1() shouldBeExactly 1428
  }

  @Test
  fun part2TestInput() {
    Day4.solvePart2(testInput) shouldBeExactly 43
  }

  @Test
  fun part2() {
    Day4.solvePart2() shouldBeExactly 8936
  }
}
