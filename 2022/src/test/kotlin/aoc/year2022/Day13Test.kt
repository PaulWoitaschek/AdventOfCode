package aoc.year2022

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import aoc.utils.solvePart2
import aoc.utils.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day13Test {

  @Test
  fun part1TestInput() {
    Day13.solvePart1WithTestInput() shouldBe 13
  }

  @Test
  fun part1() {
    Day13.solvePart1() shouldBe 6568
  }

  @Test
  fun part2Test() {
    Day13.solvePart2WithTestInput() shouldBe 140
  }

  @Test
  fun part2() {
    Day13.solvePart2() shouldBe 19493
  }
}
