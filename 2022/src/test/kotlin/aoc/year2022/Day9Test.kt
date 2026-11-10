package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day9Test {

  @Test
  fun part2RealData() {
    assertEquals(2516, Day9.solvePart2())
  }

  @Test
  fun part1RealData() {
    assertEquals(6190, Day9.solvePart1())
  }

  @Test
  fun part1TestData() {
    assertEquals(
      13,
      Day9.solvePart1(
        """
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2Short() {
    assertEquals(
      1,
      Day9.solvePart2(
        """
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2Long() {
    assertEquals(
      36,
      Day9.solvePart2(
        """
        R 5
        U 8
        L 8
        D 3
        R 17
        D 10
        L 25
        U 20
        """
          .trimIndent(),
      ),
    )
  }
}
