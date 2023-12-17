package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day12Test {

  @Test
  fun part1TestInput() {
    Day12.solvePart1WithTestInput() shouldBe 31
  }

  @Test
  fun part2TestInput() {
    Day12.solvePart2WithTestInput() shouldBe 29
  }

  @Test
  fun part1() {
    Day12.solvePart1() shouldBe 383
  }

  @Test
  fun part2() {
    Day12.solvePart2() shouldBe 377
  }
}
