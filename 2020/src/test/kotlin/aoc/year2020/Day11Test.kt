package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day11Test {

  @Test
  fun part1() {
    assertEquals(2178, Day11.solvePart1())
    assertEquals(
      37,
      Day11.solvePart1(
        """
        L.LL.LL.LL
        LLLLLLL.LL
        L.L.L..L..
        LLLL.LL.LL
        L.LL.LL.LL
        L.LLLLL.LL
        ..L.L.....
        LLLLLLLLLL
        L.LLLLLL.L
        L.LLLLL.LL
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(1978, Day11.solvePart2())
    assertEquals(
      26,
      Day11.solvePart2(
        """
        L.LL.LL.LL
        LLLLLLL.LL
        L.L.L..L..
        LLLL.LL.LL
        L.LL.LL.LL
        L.LLLLL.LL
        ..L.L.....
        LLLLLLLLLL
        L.LLLLLL.L
        L.LLLLL.LL
        """
          .trimIndent(),
      ),
    )
  }
}
