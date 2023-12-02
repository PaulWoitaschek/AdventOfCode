package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day12Test {
  @Test
  fun day12() {
    Day12.solvePart1() shouldBe 10
    Day12.solvePart2() shouldBe 36
  }
}
