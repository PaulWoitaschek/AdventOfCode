package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day11Test {

  private val testInput = """
      ...#......
      .......#..
      #.........
      ..........
      ......#...
      .#........
      .........#
      ..........
      .......#..
      #...#.....
  """.trimIndent()

  @Test
  fun part1() {
    assertEquals(9563821, Day11.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(374, Day11.solvePart1(testInput))
  }

  @Test
  fun part2() {
    assertEquals(827009909817, Day11.solvePart2())
  }

  @Test
  fun part2GalaxyExpansion10() {
    assertEquals(1030, Day11.solve(testInput, 10))
  }

  @Test
  fun part2GalaxyExpansion100() {
    assertEquals(8410, Day11.solve(testInput, 100))
  }
}
