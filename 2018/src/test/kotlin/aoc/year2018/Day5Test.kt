package aoc.year2018

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day5Test {

  private val testInput: String = "dabAcCaCBAcCcaDA"

  @Test
  fun part1() {
    assertEquals(11590, Day5.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(10, Day5.solvePart1(testInput))
  }

  @Test
  fun part2() {
    assertEquals(4504, Day5.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(4, Day5.solvePart2(testInput))
  }
}
