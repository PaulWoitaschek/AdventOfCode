package aoc.year2018

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

  private val testInput =
    """
    #1 @ 1,3: 4x4
    #2 @ 3,1: 4x4
    #3 @ 5,5: 2x2
    """
      .trimIndent()

  @Test
  fun part1() {
    assertEquals(100261, Day3.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(4, Day3.solvePart1(testInput))
  }

  @Test
  fun part2() {
    assertEquals(251, Day3.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(3, Day3.solvePart2(testInput))
  }
}
