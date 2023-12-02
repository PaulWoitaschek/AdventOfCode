package aoc.year2021

import aoc.utils.solvePart1
import aoc.utils.solvePart2
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day18Test {
  @Test
  fun day18() {
    Day18.solvePart1() shouldBe 4140
    Day18.solvePart2() shouldBe 3993
  }
}
