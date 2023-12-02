package aoc.year2022

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day21Test {

  @Test
  fun part1() {
    Day21.solvePart1(
    ) shouldBe 291425799367130
    Day21.solvePart1WithTestInput() shouldBe 152
  }
}
