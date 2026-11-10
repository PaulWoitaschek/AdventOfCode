package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day6Test {

  private val testInput = """
      ....#.....
      .........#
      ..........
      ..#.......
      .......#..
      ..........
      .#..^.....
      ........#.
      #.........
      ......#...
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(41, Day6.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(4776, Day6.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(6, Day6.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(1586, Day6.solvePart2())
  }
}
