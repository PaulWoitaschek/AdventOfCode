package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

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
    assertEquals(21, Day7.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(1562, Day7.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(40, Day7.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(24292631346665, Day7.solvePart2())
  }
}
