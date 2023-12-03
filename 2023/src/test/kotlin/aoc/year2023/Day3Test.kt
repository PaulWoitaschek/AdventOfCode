package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.ints.shouldBeExactly
import org.junit.jupiter.api.Test

class Day3Test {

  @Test
  fun part1() {
    Day3.solvePart1() shouldBeExactly 535078
  }

  @Test
  fun part1TestInput() {
    Day3.solvePart1WithTestInput() shouldBeExactly 4361
  }

  @Test
  fun part2() {
    Day3.solvePart2() shouldBeExactly 75312571
  }

  @Test
  fun part2TestInput() {
    Day3.solvePart2WithTestInput() shouldBeExactly 467835
  }
}
