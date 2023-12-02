package aoc.year2021

import aoc.utils.solvePart1
import aoc.utils.solvePart2
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day11Test {
  @Test
  fun day11() {
    Day11.solvePart1() shouldBe 1656
    Day11.solvePart2() shouldBe 195
  }
}
