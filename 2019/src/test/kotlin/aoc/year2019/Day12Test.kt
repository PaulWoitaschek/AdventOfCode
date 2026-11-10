package aoc.year2019

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day12Test {

  @Test
  fun part1() {
    assertEquals(7722, Day12.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(292653556339368, Day12.solvePart2())
  }

  @Test
  fun part2Test() {
    assertEquals(
      2772,
      Day12.solvePart2(
        """
        <x=-1, y=0, z=2>
        <x=2, y=-10, z=-7>
        <x=4, y=-8, z=8>
        <x=3, y=5, z=-1>
        """
          .trimIndent(),
      ),
    )
  }
}
