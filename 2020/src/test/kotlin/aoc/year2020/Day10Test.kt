package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day10Test {

  @Test
  fun part1() {
    Day10.solvePart1() shouldBe 1998
    Day10.solvePart1WithTestInput() shouldBe 22 * 10
  }

  @Test
  fun part2() {
    Day10.solvePart2() shouldBe 347250213298688
    Day10.solvePart2WithTestInput() shouldBe 19208
  }
}
