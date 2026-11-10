package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day14Test {

  private val testInput =
    """
    O....#....
    O.OO#....#
    .....##...
    OO.#O....O
    .O.....O#.
    O.#..O.#.#
    ..O..#O..O
    .......O..
    #....###..
    #OO..#....
    """
      .trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(136, Day14.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(109665, Day14.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(64, Day14.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(96061, Day14.solvePart2())
  }
}
