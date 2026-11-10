package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day12Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      31,
      Day12.solvePart1(
        """
Sabqponm
abcryxxl
accszExk
acctuvwj
abdefghi
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      29,
      Day12.solvePart2(
        """
Sabqponm
abcryxxl
accszExk
acctuvwj
abdefghi
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(383, Day12.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(377, Day12.solvePart2())
  }
}
