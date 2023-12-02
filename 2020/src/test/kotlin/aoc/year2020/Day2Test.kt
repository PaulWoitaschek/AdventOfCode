package aoc.year2020

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import aoc.utils.solvePart2
import aoc.utils.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day2Test {

  @Test
  fun test() {
    Day2.solvePart1() shouldBe 424
    Day2.solvePart2() shouldBe 747
    Day2.solvePart1WithTestInput() shouldBe 2
    Day2.solvePart2WithTestInput() shouldBe 1
  }
}
