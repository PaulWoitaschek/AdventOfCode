package aoc.year2022

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import aoc.utils.solvePart2
import aoc.utils.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day23Test {

  @Test
  fun part1() {
    Day23.solvePart1() shouldBe 4025
  }

  @Test
  fun part1TestInput() {
    Day23.solvePart1WithTestInput() shouldBe 110
  }

  @Test
  @Disabled("Too slow")
  fun part2() {
    Day23.solvePart2() shouldBe 935
  }

  @Test
  fun part2TestInput() {
    Day23.solvePart2WithTestInput() shouldBe 20
  }
}
