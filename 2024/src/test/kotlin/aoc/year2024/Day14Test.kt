package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day14Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      12,
      Day14.solvePart1(
        """
        p=0,4 v=3,-3
        p=6,3 v=-1,-3
        p=10,3 v=-1,2
        p=2,0 v=2,-1
        p=0,0 v=1,3
        p=3,0 v=-2,-2
        p=7,6 v=-1,-3
        p=3,0 v=-1,-2
        p=9,3 v=2,3
        p=7,3 v=-1,2
        p=2,4 v=2,-3
        p=9,5 v=-3,-3
        """.trimIndent(),
        11,
        7,
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(230172768, Day14.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(8087, Day14.solvePart2())
  }
}
