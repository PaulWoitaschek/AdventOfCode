package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day8Test {

  @Test
  fun part1() {
    assertEquals(1928, Day8.solvePart1())
    assertEquals(
      5,
      Day8.solvePart1(
        """
        nop +0
        acc +1
        jmp +4
        acc +3
        jmp -3
        acc -99
        acc +1
        jmp -4
        acc +6
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(1319, Day8.solvePart2())
    assertEquals(
      8,
      Day8.solvePart2(
        """
        nop +0
        acc +1
        jmp +4
        acc +3
        jmp -3
        acc -99
        acc +1
        jmp -4
        acc +6
        """
          .trimIndent(),
      ),
    )
  }
}
