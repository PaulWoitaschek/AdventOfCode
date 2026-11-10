package aoc.year2017

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day15Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      588,
      Day15.solvePart1(
        """
          Generator A starts with 65
          Generator B starts with 8921
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(650, Day15.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      309,
      Day15.solvePart2(
        """
          Generator A starts with 65
          Generator B starts with 8921
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(336, Day15.solvePart2())
  }
}
