package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day9Test {
  private val testInput: String = """
    7,1
    11,1
    11,7
    9,7
    9,5
    2,5
    2,3
    7,3
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(50, Day9.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(4725826296, Day9.solvePart1())
  }

  @Test
  @Disabled
  fun part2TestInput() {
    assertEquals(42, Day9.solvePart2(testInput))
  }

  @Test
  @Disabled
  fun part2() {
    assertEquals(42, Day9.solvePart2())
  }
}
