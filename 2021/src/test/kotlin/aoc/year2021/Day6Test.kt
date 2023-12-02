package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day6Test {
  @Test
  fun day6() {
    Day6.solvePart1() shouldBe 5934
    Day6.solvePart2() shouldBe 26984457539
  }
}
