package aoc.year2017

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day13Test {

  private val testInput =
    """
    0: 3
    1: 2
    4: 4
    6: 4
    """
      .trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(24, Day13.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(1876, Day13.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(10, Day13.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(3964778, Day13.solvePart2())
  }
}
