package aoc.year2022

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import aoc.utils.solvePart2
import aoc.utils.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day12Test {

  @Test
  fun test() {
    Day12.solvePart1() shouldBe 383
    Day12.solvePart2() shouldBe 377
    Day12.solvePart1WithTestInput() shouldBe 31
    Day12.solvePart2WithTestInput() shouldBe 29
  }
}
