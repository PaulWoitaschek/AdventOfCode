package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2Test {

  private val testInput = """
      7 6 4 2 1
      1 2 7 8 9
      9 7 6 2 1
      1 3 2 4 5
      8 6 4 4 1
      1 3 6 7 9
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(2, Day2.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(341, Day2.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(4, Day2.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(404, Day2.solvePart2())
  }
}
