package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.String
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day6Test {

  private val testInput: String =
    """
    123 328  51 64
     45 64  387 23
      6 98  215 314
    *   +   *   +
    """
      .trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(4277556, Day6.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(4309240495780, Day6.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(3263827, Day6.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(9170286552289, Day6.solvePart2())
  }
}
