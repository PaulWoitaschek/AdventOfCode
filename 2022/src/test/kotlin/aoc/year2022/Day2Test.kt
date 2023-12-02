package aoc.year2022

import aoc.utils.solvePart1
import aoc.utils.solvePart2
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day2Test {
  @Test
  fun day2() {
    Day2.solvePart1() shouldBe 12535
    Day2.solvePart2() shouldBe 15457
  }
}
