package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day3Test {

  @Test
  fun part1TestInput() {
    Day3.solvePart1(
      """
      987654321111111
      811111111111119
      234234234234278
      818181911112111
      """.trimIndent(),
    ) shouldBeExactly 357
  }

  @Test
  fun part1() {
    Day3.solvePart1() shouldBeExactly 16842
  }

  @Test
  fun part2TestInput() {
    Day3.solvePart2(
      """
      987654321111111
      811111111111119
      234234234234278
      818181911112111
      """.trimIndent(),
    ) shouldBeExactly 3121910778619
  }

  @Test
  fun part2() {
    Day3.solvePart2() shouldBeExactly 167523425665348
  }
}
