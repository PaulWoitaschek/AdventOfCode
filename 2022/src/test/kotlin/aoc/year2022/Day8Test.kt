package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
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
