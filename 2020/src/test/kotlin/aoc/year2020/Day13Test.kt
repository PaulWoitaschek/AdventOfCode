package aoc.year2020

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day13Test {

  @Test
  fun part1() {
    Day13.solvePart1() shouldBe 161
    Day13.solvePart1WithTestInput() shouldBe 295
  }
}
