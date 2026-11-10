package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

  private val testInput = """
    199
    200
    208
    210
    200
    207
    240
    269
    260
    263
  """.trimIndent()

  @Test
  fun part1() {
    assertEquals(1791, Day1.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(7, Day1.solvePart1(testInput))
  }

  @Test
  fun part2() {
    assertEquals(1822, Day1.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(5, Day1.solvePart2(testInput))
  }
}
