package aoc.year2020

import aoc.library.solvePart1
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day13Test {

  @Test
  fun part1() {
    assertEquals(161, Day13.solvePart1())
    assertEquals(
      295,
      Day13.solvePart1(
        """
        939
        7,13,x,x,59,x,31,19
        """
          .trimIndent(),
      ),
    )
  }
}
