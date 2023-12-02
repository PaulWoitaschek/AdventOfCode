package aoc.year2020

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day12Test {

  @Test
  fun part1() {
    Day12.solvePart1() shouldBe 1148
    Day12.solvePart1WithTestInput() shouldBe 25
  }
}
