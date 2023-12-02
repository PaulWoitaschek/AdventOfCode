package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day3Test {

  @Test
  fun part1() {
    Day3.solvePart1() shouldBe 193
    Day3.solvePart1WithTestInput() shouldBe 7
  }

  @Test
  fun part2() {
    Day3.solvePart2() shouldBe 1355323200
    Day3.solvePart2WithTestInput() shouldBe 336
  }
}
