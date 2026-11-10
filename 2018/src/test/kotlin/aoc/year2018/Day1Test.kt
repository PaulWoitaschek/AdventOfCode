package aoc.year2018

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

  @Test
  fun part1() {
    assertEquals(569, Day1.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(77666, Day1.solvePart2())
  }

  @Test
  fun part2Test() {
    assertEquals(
      14,
      Day1.solvePart2(
        """
        +7
        +7
        -2
        -7
        -4
        """.trimIndent(),
      ),
    )
  }
}
