package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day6Test {

  @Test
  fun part1() {
    assertEquals(7110, Day6.solvePart1())
    assertEquals(
      11,
      Day6.solvePart1(
        """
        abc

        a
        b
        c

        ab
        ac

        a
        a
        a
        a

        b
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(3628, Day6.solvePart2())
    assertEquals(
      6,
      Day6.solvePart2(
        """
        abc

        a
        b
        c

        ab
        ac

        a
        a
        a
        a

        b
        """
          .trimIndent(),
      ),
    )
  }
}
