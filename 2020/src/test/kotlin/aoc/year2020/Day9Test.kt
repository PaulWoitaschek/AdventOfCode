package aoc.year2020

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import aoc.utils.solvePart2
import aoc.utils.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day9Test {

  @Test
  fun test() {
    val day9 = Day9(5)
    day9.solvePart1WithTestInput() shouldBe 127
    day9.solvePart2WithTestInput() shouldBe 62
    val day91 = Day9(25)
    day91.solvePart1() shouldBe 257342611
    day91.solvePart2() shouldBe 35602097
  }
}
