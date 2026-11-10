package aoc.year2020

import aoc.library.solvePart1
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day12Test {

  @Test
  fun part1() {
    assertEquals(1148, Day12.solvePart1())
    assertEquals(
      25,
      Day12.solvePart1(
        """
        F10
        N3
        F7
        R90
        F11
        """
          .trimIndent(),
      ),
    )
  }
}
