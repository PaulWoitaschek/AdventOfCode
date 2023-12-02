package aoc.year2020

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import aoc.utils.solvePart2
import aoc.utils.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day6Test {

  @Test
  fun part1() {
    Day6.solvePart1() shouldBe 7110
    Day6.solvePart1WithTestInput() shouldBe 11
  }

  @Test
  fun part2() {
    Day6.solvePart2() shouldBe 3628
    Day6.solvePart2WithTestInput() shouldBe 6
  }
}
