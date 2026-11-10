package aoc.year2019

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day8Test {

  @Test
  fun part1() {
    assertEquals(2356, Day8.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(
      """
          ⬜⬜⬜⬛⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬛⬛⬜⬛⬜⬜⬜⬛⬛
          ⬜⬛⬛⬜⬛⬛⬛⬛⬜⬛⬜⬛⬛⬛⬛⬜⬛⬜⬛⬛⬜⬛⬛⬜⬛
          ⬜⬛⬛⬜⬛⬛⬛⬜⬛⬛⬜⬜⬜⬛⬛⬜⬜⬛⬛⬛⬜⬜⬜⬛⬛
          ⬜⬜⬜⬛⬛⬛⬜⬛⬛⬛⬜⬛⬛⬛⬛⬜⬛⬜⬛⬛⬜⬛⬛⬜⬛
          ⬜⬛⬛⬛⬛⬜⬛⬛⬛⬛⬜⬛⬛⬛⬛⬜⬛⬜⬛⬛⬜⬛⬛⬜⬛
          ⬜⬛⬛⬛⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬛⬛⬜⬛⬜⬜⬜⬛⬛
      """.trimIndent(),
      Day8.solvePart2(),
    )
  }
}
