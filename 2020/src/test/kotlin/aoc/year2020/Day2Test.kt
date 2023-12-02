package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
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
