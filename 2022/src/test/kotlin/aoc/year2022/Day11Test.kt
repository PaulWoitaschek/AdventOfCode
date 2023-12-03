package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day11Test {

  @Test
  fun test() {
    Day11.solvePart1() shouldBe 99840
    Day11.solvePart2() shouldBe 20683044837
    Day11.solvePart1WithTestInput() shouldBe 10605
    Day11.solvePart2WithTestInput() shouldBe 2713310158
  }
}