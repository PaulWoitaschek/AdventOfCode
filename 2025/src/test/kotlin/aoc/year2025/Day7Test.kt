package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day7Test {

  private val testInput: String = """
    .......S.......
    ...............
    .......^.......
    ...............
    ......^.^......
    ...............
    .....^.^.^.....
    ...............
    ....^.^...^....
    ...............
    ...^.^...^.^...
    ...............
    ..^...^.....^..
    ...............
    .^.^.^.^.^...^.
    ...............
  """.trimIndent()

  @Test
  fun part1TestInput() {
    Day7.solvePart1(testInput) shouldBeExactly 21
  }

  @Test
  fun part1() {
    Day7.solvePart1() shouldBeExactly 1562
  }

  @Test
  @Disabled
  fun part2TestInput() {
    Day7.solvePart2(testInput) shouldBeExactly 42
  }

  @Test
  @Disabled
  fun part2() {
    Day7.solvePart2() shouldBeExactly 42
  }
}
