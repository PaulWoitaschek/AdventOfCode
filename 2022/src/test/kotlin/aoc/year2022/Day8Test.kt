package aoc.year2022

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import aoc.utils.solvePart2
import aoc.utils.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day8Test {

  @Test
  fun test() {
    Day8.solvePart1() shouldBe 1672
    Day8.solvePart2() shouldBe 327180
    Day8.solvePart1WithTestInput() shouldBe 21
    Day8.solvePart2WithTestInput() shouldBe 8
  }
}
