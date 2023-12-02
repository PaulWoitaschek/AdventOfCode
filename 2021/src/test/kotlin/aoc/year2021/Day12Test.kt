package aoc.year2021

import aoc.utils.solvePart1
import aoc.utils.solvePart2
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day12Test {
  @Test
  fun day12() {
    Day12.solvePart1() shouldBe 10
    Day12.solvePart2() shouldBe 36
  }
}
