package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day2Test {

  @Test
  fun part1TestInput() {
    Day2.solvePart1WithTestInput() shouldBe 2
  }

  @Test
  fun part2TestInput() {
    Day2.solvePart2WithTestInput() shouldBe 1
  }

  @Test
  fun part1() {
    Day2.solvePart1() shouldBe 424
  }

  @Test
  fun part2() {
    Day2.solvePart2() shouldBe 747
  }
}
