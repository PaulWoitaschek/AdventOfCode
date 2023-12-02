package aoc.year2020

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import aoc.utils.solvePart2
import aoc.utils.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day11Test {

  @Test
  fun part1() {
    Day11.solvePart1(
    ) shouldBe 2178
    Day11.solvePart1WithTestInput() shouldBe 37
  }

  @Test
  fun part2() {
    Day11.solvePart2() shouldBe 1978
    Day11.solvePart2WithTestInput() shouldBe 26
  }
}
