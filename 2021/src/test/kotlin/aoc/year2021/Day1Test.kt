package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day1Test {
  @Test
  fun day1() {
    Day1.solvePart1() shouldBe 7
    Day1.solvePart2() shouldBe 5
  }
}
