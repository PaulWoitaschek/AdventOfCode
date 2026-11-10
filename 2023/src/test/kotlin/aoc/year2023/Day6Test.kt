package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day6Test {
  private val testInput: String = """
    Time:      7  15   30
    Distance:  9  40  200
  """.trimIndent()

  @Test
  fun part1() {
    assertEquals(220320, Day6.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(288, Day6.solvePart1(testInput))
  }

  @Test
  fun part2() {
    assertEquals(34454850, Day6.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(71503, Day6.solvePart2(testInput))
  }
}
