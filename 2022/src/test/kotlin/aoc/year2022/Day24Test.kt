package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day24Test {

  @Test
  fun part1TestData() {
    assertEquals(
      18,
      Day24.solvePart1(
        """
#.######
#>>.<^<#
#.<..<<#
#>v.><>#
#<^v^^>#
######.#
        """.trimIndent(),
      ),
    )
  }

  @Test
  @Disabled("Too slow")
  fun part1RealData() {
    assertEquals(264, Day24.solvePart1())
  }

  @Test
  fun part2TestData() {
    assertEquals(
      54,
      Day24.solvePart2(
        """
#.######
#>>.<^<#
#.<..<<#
#>v.><>#
#<^v^^>#
######.#
        """.trimIndent(),
      ),
    )
  }

  @Test
  @Disabled("Too slow")
  fun part2RealData() {
    assertEquals(789, Day24.solvePart2())
  }
}
