package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

  @Test
  fun part1() {
    assertEquals(535078, Day3.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(
      4361,
      Day3.solvePart1(
        """
        467..114..
        ...*......
        ..35..633.
        ......#...
        617*......
        .....+.58.
        ..592.....
        ......755.
        ...$.*....
        .664.598..
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(75312571, Day3.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      467835,
      Day3.solvePart2(
        """
        467..114..
        ...*......
        ..35..633.
        ......#...
        617*......
        .....+.58.
        ..592.....
        ......755.
        ...$.*....
        .664.598..
        """
          .trimIndent(),
      ),
    )
  }
}
