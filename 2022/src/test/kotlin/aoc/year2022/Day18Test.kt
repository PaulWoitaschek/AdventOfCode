package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day18Test {

  @Test
  fun part1TestInput() {
    Day18.solvePart1WithTestInput() shouldBe 64
  }

  @Test
  fun part1RegularInput() {
    Day18.solvePart1() shouldBe 4370
  }

  @Test
  fun part2TestInput() {
    Day18.solvePart2WithTestInput() shouldBe 58
  }

  @Test
  fun part2RegularInput() {
    Day18.solvePart2() shouldBe 2458
  }
}
