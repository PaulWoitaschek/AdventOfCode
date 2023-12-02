package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day8Test {

  @Test
  fun part1() {
    Day8.solvePart1() shouldBe 1928
    Day8.solvePart1WithTestInput() shouldBe 5
  }

  @Test
  fun part2() {
    Day8.solvePart2() shouldBe 1319
    Day8.solvePart2WithTestInput() shouldBe 8
  }
}
