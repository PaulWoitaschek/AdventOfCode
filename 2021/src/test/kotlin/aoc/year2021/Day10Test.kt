package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day10Test {
  @Test
  fun day10() {
    Day10.solvePart1() shouldBe 26397
    Day10.solvePart2() shouldBe 288957
  }
}
