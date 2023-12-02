package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
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
