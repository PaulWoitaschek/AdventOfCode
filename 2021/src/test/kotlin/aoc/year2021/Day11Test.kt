package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day11Test {

  private val testInput = """
    5483143223
    2745854711
    5264556173
    6141336146
    6357385478
    4167524645
    2176841721
    6882881134
    4846848554
    5283751526
  """.trimIndent()

  @Test
  fun part1() {
    assertEquals(1594, Day11.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(1656, Day11.solvePart1(testInput))
  }

  @Test
  fun part2() {
    assertEquals(437, Day11.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(195, Day11.solvePart2(testInput))
  }
}
