package aoc.year2017

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {

  @Test
  fun part1() {
    assertEquals(58975, Day2.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(
      18,
      Day2.solvePart1(
        """
        5 1 9 5
        7 5 3
        2 4 6 8
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(308, Day2.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      9,
      Day2.solvePart2(
        """
        5 9 2 8
        9 4 7 3
        3 8 6 5
        """
          .trimIndent(),
      ),
    )
  }
}
