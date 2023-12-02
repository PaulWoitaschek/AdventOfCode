package aoc.year2021

import aoc.utils.solvePart1
import aoc.utils.solvePart2
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day9Test {
  @Test
  fun day9() {
    Day9.solvePart1() shouldBe 15
    Day9.solvePart2() shouldBe 1134
  }
}
