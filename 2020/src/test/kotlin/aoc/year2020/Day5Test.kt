package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day5Test {

  @Test
  fun part1() {
    assertEquals(933, Day5.solvePart1())
    assertEquals(
      820,
      Day5.solvePart1(
        """
BFFFBBFRRR
FFFBBBFRRR
BBFFBBFRLL
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(711, Day5.solvePart2())
  }
}
