package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day7Test {

  @Test
  fun part1() {
    Day7.solvePart1() shouldBe 370
    Day7.solvePart1WithTestInput() shouldBe 4
  }

  @Test
  fun part2() {
    Day7.solvePart2() shouldBe 29547
    Day7.solvePart2WithTestInput() shouldBe 32
  }
}