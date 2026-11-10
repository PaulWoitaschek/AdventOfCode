package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day7Test {

  private val testData =
    """
    190: 10 19
    3267: 81 40 27
    83: 17 5
    156: 15 6
    7290: 6 8 6 15
    161011: 16 10 13
    192: 17 8 14
    21037: 9 7 18 13
    292: 11 6 16 20
    """
      .trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(3749, Day7.solvePart1(testData))
  }

  @Test
  fun part1() {
    assertEquals(2299996598890, Day7.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(11387, Day7.solvePart2(testData))
  }

  @Test
  fun part2() {
    assertEquals(362646859298554, Day7.solvePart2())
  }
}
