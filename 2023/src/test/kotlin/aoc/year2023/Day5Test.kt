package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day5Test {

  @Test
  fun part1() {
    Day5.solvePart1() shouldBeExactly 261668924
  }

  @Test
  fun part1TestInput() {
    Day5.solvePart1WithTestInput() shouldBeExactly 35
  }

  @Test
  @Disabled("Bruteforce. Works within 3 minutes on a M1")
  fun part2() {
    Day5.solvePart2() shouldBeExactly 24261545
  }

  @Test
  fun part2TestInput() {
    Day5.solvePart2WithTestInput() shouldBeExactly 46
  }
}
