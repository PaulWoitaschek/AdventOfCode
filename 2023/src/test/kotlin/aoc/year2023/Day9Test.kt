package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day9Test {

  @Test
  fun part1() {
    assertEquals(2174807968, Day9.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(
      114,
      Day9.solvePart1(
        """
        0 3 6 9 12 15
        1 3 6 10 15 21
        10 13 16 21 30 45
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(1208, Day9.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      2,
      Day9.solvePart2(
        """
              0 3 6 9 12 15
              1 3 6 10 15 21
              10 13 16 21 30 45
        """.trimIndent(),
      ),
    )
  }
}
