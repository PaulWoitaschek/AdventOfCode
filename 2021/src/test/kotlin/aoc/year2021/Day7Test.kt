package aoc.year2021

import aoc.utils.solvePart1
import aoc.utils.solvePart2
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day7Test {
  @Test
  fun day7() {
    Day7.solvePart1() shouldBe 37
    Day7.solvePart2() shouldBe 168
  }
}
