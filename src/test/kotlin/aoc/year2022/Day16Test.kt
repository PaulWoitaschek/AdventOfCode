package aoc.year2022

import aoc.utils.aocInput
import aoc.utils.aocTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day16Test {

  @Test
  fun part1() {
    Day16.solvePart1(aocInput(2022, 16)) shouldBe 1617
  }

  @Test
  fun part1Test() {
    Day16.solvePart1(aocTestInput(2022, 16)) shouldBe 1651
  }

  @Test
  fun part2Test() {
    Day16.solvePart2(aocTestInput(2022, 16)) shouldBe 1707
  }

  @Test
  fun part2() {
    Day16.solvePart2(aocInput(2022, 16)) shouldBe 2171
  }
}
