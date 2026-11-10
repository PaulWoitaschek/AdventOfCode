package aoc.year2023

import aoc.library.solvePart1
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day24Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      2,
      Day24.solvePart1(
        input = """
              19, 13, 30 @ -2,  1, -2
              18, 19, 22 @ -1, -1, -2
              20, 25, 34 @ -2, -2, -4
              12, 31, 28 @ -1, -2, -1
              20, 19, 15 @  1, -5, -3
        """.trimIndent(),
        range = 7L..27L,
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(19523, Day24.solvePart1())
  }
}
