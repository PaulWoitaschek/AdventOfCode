package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      11,
      Day1.solvePart1(
        """
        3   4
        4   3
        2   5
        1   3
        3   9
        3   3
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(2176849, Day1.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      31,
      Day1.solvePart2(
        """
        3   4
        4   3
        2   5
        1   3
        3   9
        3   3
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(23384288, Day1.solvePart2())
  }
}
