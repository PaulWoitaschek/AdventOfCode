package aoc.year2017

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day12Test {

  private val testInput = """
      0 <-> 2
      1 <-> 1
      2 <-> 0, 3, 4
      3 <-> 2, 4
      4 <-> 2, 3, 6
      5 <-> 6
      6 <-> 4, 5
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(6, Day12.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(134, Day12.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(2, Day12.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(193, Day12.solvePart2())
  }
}
