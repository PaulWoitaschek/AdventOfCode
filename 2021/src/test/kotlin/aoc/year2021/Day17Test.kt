package aoc.year2021

import aoc.utils.solvePart1
import aoc.utils.solvePart2
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day17Test {
  @Test
  fun day17() {
    Day17.solvePart1() shouldBe 45
    Day17.solvePart2() shouldBe 112
  }
}
