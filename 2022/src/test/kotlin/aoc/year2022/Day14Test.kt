package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day14Test {

  private val testInput = """
    498,4 -> 498,6 -> 496,6
    503,4 -> 502,4 -> 502,9 -> 494,9
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(24, Day14.solvePart1(testInput))
  }

  @Test
  fun part2TestInput() {
    assertEquals(93, Day14.solvePart2(testInput))
  }

  @Test
  fun part1() {
    assertEquals(901, Day14.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(24589, Day14.solvePart2())
  }
}
