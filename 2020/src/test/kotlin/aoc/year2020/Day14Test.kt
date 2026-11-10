package aoc.year2020

import aoc.library.solvePart1
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day14Test {

  @Test
  fun part1() {
    assertEquals(10452688630537, Day14.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(
      165,
      Day14.solvePart1(
        """
        mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
        mem[8] = 11
        mem[7] = 101
        mem[8] = 0
        """
          .trimIndent(),
      ),
    )
  }
}
