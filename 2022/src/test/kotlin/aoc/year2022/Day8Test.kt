package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day8Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      21,
      Day8.solvePart1(
        """
        30373
        25512
        65332
        33549
        35390
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      8,
      Day8.solvePart2(
        """
        30373
        25512
        65332
        33549
        35390
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(1672, Day8.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(327180, Day8.solvePart2())
  }
}
