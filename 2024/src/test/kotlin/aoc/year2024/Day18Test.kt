package aoc.year2024

import aoc.library.Point
import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day18Test {

  private val testInput = """
            5,4
            4,2
            4,5
            3,0
            2,1
            6,3
            2,4
            1,5
            0,6
            3,3
            2,6
            5,1
            1,2
            5,5
            2,5
            6,5
            1,4
            0,4
            6,4
            1,1
            6,1
            1,0
            0,5
            1,6
            2,0
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(
      22,
      Day18.solvePart1(
        input = testInput,
        bytes = 12,
        size = 6,
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(286, Day18.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(Point(6, 1), Day18.solvePart2(testInput, 6))
  }

  @Test
  fun part2() {
    assertEquals(Point(20, 64), Day18.solvePart2())
  }
}
