package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day7Test {

  private val testInput: String =
    """
    32T3K 765
    T55J5 684
    KK677 28
    KTJJT 220
    QQQJA 483
    """
      .trimIndent()

  @Test
  fun part1() {
    assertEquals(252656917, Day7.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(6440, Day7.solvePart1(testInput))
  }

  @Test
  fun part2() {
    assertEquals(253499763, Day7.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(5905, Day7.solvePart2(testInput))
  }
}
