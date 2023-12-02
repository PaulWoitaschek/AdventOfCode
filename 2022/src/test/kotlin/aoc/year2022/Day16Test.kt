package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day16Test {

  @Test
  fun part1() {
    Day16.solvePart1() shouldBe 1617
  }

  @Test
  fun part1Test() {
    Day16.solvePart1WithTestInput() shouldBe 1651
  }

  @Test
  fun part2Test() {
    Day16.solvePart2WithTestInput() shouldBe 1707
  }

  @Test
  @Disabled("Too slow")
  fun part2() {
    Day16.solvePart2() shouldBe 2171
  }
}
