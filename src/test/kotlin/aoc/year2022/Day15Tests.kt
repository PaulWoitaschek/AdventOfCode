package aoc.year2022

import aoc.utils.aocInput
import aoc.utils.aocTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day15Tests {

  @Test
  fun testData() {
    val input = aocTestInput(2022, 15)
    val puzzle = Day15(lineToScan = 10, rangeMax = 20)
    puzzle.solvePart1(input) shouldBe 26
    puzzle.solvePart2(input) shouldBe 56000011
  }

  @Test
  @Disabled("Too slow")
  fun realData() {
    val input = aocInput(2022, 15)
    val puzzle = Day15(lineToScan = 2000000, rangeMax = 4000000)
    puzzle.solvePart1(input) shouldBe 5394423
    puzzle.solvePart2(input) shouldBe 11840879211051
  }
}
