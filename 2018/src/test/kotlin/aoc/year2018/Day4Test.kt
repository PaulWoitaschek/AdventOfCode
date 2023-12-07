package aoc.year2018

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.ints.shouldBeExactly
import org.junit.jupiter.api.Test

class Day4Test {

  @Test
  fun part1() {
    Day4.solvePart1() shouldBeExactly 143415
  }

  @Test
  fun part1TestInput() {
    Day4.solvePart1WithTestInput() shouldBeExactly 240
  }

  @Test
  fun part2() {
    Day4.solvePart2() shouldBeExactly 49944
  }

  @Test
  fun part2TestInput() {
    Day4.solvePart2WithTestInput() shouldBeExactly 4455
  }
}
