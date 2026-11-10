package aoc.year2018

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day8Test {

  private val testInput = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2"

  @Test
  fun part1TestInput() {
    assertEquals(138, Day8.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(48496, Day8.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(66, Day8.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(32850, Day8.solvePart2())
  }
}
