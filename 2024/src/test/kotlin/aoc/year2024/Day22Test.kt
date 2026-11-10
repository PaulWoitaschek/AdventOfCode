package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day22Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      37327623,
      Day22.solvePart1(
        """
        1
        10
        100
        2024
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(16999668565, Day22.solvePart1())
  }

  @Test
  @Disabled
  fun part2TestInput() {
    assertEquals(42, Day22.solvePart2())
  }

  @Test
  @Disabled
  fun part2() {
    assertEquals(42, Day22.solvePart2())
  }
}
