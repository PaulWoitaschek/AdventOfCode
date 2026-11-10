package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day12Test {

  private val testInput =
    """
    start-A
    start-b
    A-c
    A-b
    b-d
    A-end
    b-end
    """
      .trimIndent()

  @Test
  fun part1() {
    assertEquals(5212, Day12.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(10, Day12.solvePart1(testInput))
  }

  @Test
  fun part2() {
    assertEquals(134862, Day12.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(36, Day12.solvePart2(testInput))
  }
}
