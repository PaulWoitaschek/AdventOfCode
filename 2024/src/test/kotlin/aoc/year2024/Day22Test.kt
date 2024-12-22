package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day22Test {

  @Test
  fun part1TestInput() {
    Day22.solvePart1(
      """
      1
      10
      100
      2024
      """.trimIndent(),
    ) shouldBeExactly 37327623
  }

  @Test
  fun part1() {
    Day22.solvePart1() shouldBeExactly 16999668565
  }

  @Test
  @Disabled
  fun part2TestInput() {
    Day22.solvePart2() shouldBeExactly 42
  }

  @Test
  @Disabled
  fun part2() {
    Day22.solvePart2() shouldBeExactly 42
  }
}
