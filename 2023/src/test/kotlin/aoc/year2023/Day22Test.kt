package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day22Test {

  private val testInput = """
      1,0,1~1,2,1
      0,0,2~2,0,2
      0,2,3~2,2,3
      0,0,4~0,2,4
      2,0,5~2,2,5
      0,1,6~2,1,6
      1,1,8~1,1,9
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(5, Day22.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(386, Day22.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(7, Day22.solvePart2(testInput))
  }

  @Test
  @Disabled("Slow^")
  fun part2() {
    assertEquals(39933, Day22.solvePart2())
  }
}
