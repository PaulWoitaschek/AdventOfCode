package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      357,
      Day3.solvePart1(
        """
        987654321111111
        811111111111119
        234234234234278
        818181911112111
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(16842, Day3.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      3121910778619,
      Day3.solvePart2(
        """
        987654321111111
        811111111111119
        234234234234278
        818181911112111
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(167523425665348, Day3.solvePart2())
  }
}
