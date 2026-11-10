package aoc.year2022

import aoc.library.solvePart1
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day22Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      6032,
      Day22.solvePart1(
        """
...#
        .#..
        #...
        ....
...#.......#
........#...
..#....#....
..........#.
        ...#....
        .....#..
        .#......
        ......#.

10R5L5R10L4R5L5
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(89224, Day22.solvePart1())
  }
}
