package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day1Test {

  @Test
  fun part1TestInput() {
    Day1.solvePart1WithTestInput() shouldBe 514579
  }

  @Test
  fun part2TestInput() {
    Day1.solvePart2WithTestInput() shouldBe 241861950
  }

  @Test
  fun part1() {
    Day1.solvePart1() shouldBe 73371
  }

  @Test
  fun part2() {
    Day1.solvePart2() shouldBe 127642310
  }
}
