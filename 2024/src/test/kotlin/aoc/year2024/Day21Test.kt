package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day21Test {

  @Test
  @Disabled
  fun part1TestInput() {
    Day21.solvePart1(
      """
      029A
      980A
      179A
      456A
      379A
      """.trimIndent(),
    ) shouldBeExactly 42
  }

  @Test
  @Disabled
  fun part1() {
    Day21.solvePart1() shouldBeExactly 42
  }

  @Test
  @Disabled
  fun part2TestInput() {
    Day21.solvePart2() shouldBeExactly 42
  }

  @Test
  @Disabled
  fun part2() {
    Day21.solvePart2() shouldBeExactly 42
  }
}
