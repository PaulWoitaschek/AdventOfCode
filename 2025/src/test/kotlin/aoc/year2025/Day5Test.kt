package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day5Test {

  private val testInput =
    """
    3-5
    10-14
    16-20
    12-18

    1
    5
    8
    11
    17
    32
    """
      .trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(3, Day5.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(652, Day5.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(14, Day5.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(341753674214273, Day5.solvePart2())
  }
}
