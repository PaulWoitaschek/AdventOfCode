package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day21Test {

  @Test
  @Disabled
  fun part1TestInput() {
    assertEquals(
      42,
      Day21.solvePart1(
        """
        029A
        980A
        179A
        456A
        379A
        """.trimIndent(),
      ),
    )
  }

  @Test
  @Disabled
  fun part1() {
    assertEquals(42, Day21.solvePart1())
  }

  @Test
  @Disabled
  fun part2TestInput() {
    assertEquals(42, Day21.solvePart2())
  }

  @Test
  @Disabled
  fun part2() {
    assertEquals(42, Day21.solvePart2())
  }
}
