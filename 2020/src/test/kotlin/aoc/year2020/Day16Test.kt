package aoc.year2020

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import aoc.utils.solvePart2
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day16Test {

  @Test
  fun part1() {
    Day16.solvePart1() shouldBe 29851
    Day16.solvePart1WithTestInput() shouldBe 71
  }

  @Test
  fun part2() {
    Day16.solvePart2() shouldBe 3029180675981
  }
}
