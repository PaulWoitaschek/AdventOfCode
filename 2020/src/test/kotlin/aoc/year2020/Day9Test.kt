package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day9Test {

  @Test
  fun part1TestInput() {
    Day9(5).solvePart1WithTestInput() shouldBe 127
  }

  @Test
  fun part2TestInput() {
    Day9(5).solvePart2WithTestInput() shouldBe 62
  }

  @Test
  fun part1() {
    Day9(25).solvePart1() shouldBe 257342611
  }

  @Test
  fun part2() {
    Day9(25).solvePart2() shouldBe 35602097
  }
}
