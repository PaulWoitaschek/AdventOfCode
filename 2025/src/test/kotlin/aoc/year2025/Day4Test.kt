package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day4Test {

  private val testInput = """
      ..@@.@@@@.
      @@@.@.@.@@
      @@@@@.@.@@
      @.@@@@..@.
      @@.@@@@.@@
      .@@@@@@@.@
      .@.@.@.@@@
      @.@@@.@@@@
      .@@@@@@@@.
      @.@.@@@.@.
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(
      13,
      Day4.solvePart1(
        testInput,
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(1428, Day4.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(43, Day4.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(8936, Day4.solvePart2())
  }
}
