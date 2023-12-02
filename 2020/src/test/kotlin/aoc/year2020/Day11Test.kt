package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day11Test {

  @Test
  fun part1() {
    Day11.solvePart1() shouldBe 2178
    Day11.solvePart1WithTestInput() shouldBe 37
  }

  @Test
  fun part2() {
    Day11.solvePart2() shouldBe 1978
    Day11.solvePart2WithTestInput() shouldBe 26
  }
}
