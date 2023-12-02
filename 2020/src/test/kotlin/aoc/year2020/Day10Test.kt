package aoc.year2020

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import aoc.utils.solvePart2
import aoc.utils.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day10Test {

  @Test
  fun part1() {
    val part1Test = 22 * 10
    Day10.solvePart1() shouldBe 1998
    Day10.solvePart1WithTestInput() shouldBe part1Test
  }

  @Test
  fun part2() {
    Day10.solvePart2() shouldBe 347250213298688
    Day10.solvePart2WithTestInput() shouldBe 19208
  }
}
