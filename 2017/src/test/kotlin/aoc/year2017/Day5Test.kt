package aoc.year2017

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day5Test {

  private val testInput = """
      0
      3
      0
      1
      -3
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(5, Day5.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(343364, Day5.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(10, Day5.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(25071947, Day5.solvePart2())
  }
}
