package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day18Test {

  private val testInput =
    """
    R 6 (#70c710)
    D 5 (#0dc571)
    L 2 (#5713f0)
    D 2 (#d2c081)
    R 2 (#59c680)
    D 2 (#411b91)
    L 5 (#8ceee2)
    U 2 (#caa173)
    L 1 (#1b58a2)
    U 2 (#caa171)
    R 2 (#7807d2)
    U 3 (#a77fa3)
    L 2 (#015232)
    U 2 (#7a21e3)
    """
      .trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(62, Day18.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(35991, Day18.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(952408144115, Day18.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(54058824661845, Day18.solvePart2())
  }
}
