package aoc.year2022

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import aoc.utils.solvePart2
import aoc.utils.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day24Test {

  @Test
  fun part1TestData() {
    Day24.solvePart1WithTestInput() shouldBe 18
  }

  @Test
  @Disabled("Too slow")
  fun part1RealData() {
    Day24.solvePart1() shouldBe 264
  }

  @Test
  fun part2TestData() {
    Day24.solvePart2WithTestInput() shouldBe 54
  }

  @Test
  @Disabled("Too slow")
  fun part2RealData() {
    Day24.solvePart2() shouldBe 789
  }
}
