package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day8Test {

  private val testInput =
    """
    ............
    ........0...
    .....0......
    .......0....
    ....0.......
    ......A.....
    ............
    ............
    ........A...
    .........A..
    ............
    ............
    """
      .trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(14, Day8.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(341, Day8.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(34, Day8.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(1134, Day8.solvePart2())
  }
}
