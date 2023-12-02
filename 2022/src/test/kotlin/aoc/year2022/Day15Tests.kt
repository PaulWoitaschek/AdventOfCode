package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day15Tests {

  @Test
  fun testData() {
    val puzzle = Day15(lineToScan = 10, rangeMax = 20)
    puzzle.solvePart1WithTestInput() shouldBe 26
    puzzle.solvePart2WithTestInput() shouldBe 56000011
  }

  @Test
  @Disabled("Too slow")
  fun realData() {
    val puzzle = Day15(lineToScan = 2000000, rangeMax = 4000000)
    puzzle.solvePart1() shouldBe 5394423
    puzzle.solvePart2() shouldBe 11840879211051
  }
}
