package aoc.year2021

import aoc.library.solvePart1
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day13Test {

  private val testInput = """
    6,10
    0,14
    9,10
    0,3
    10,4
    4,11
    6,0
    6,12
    4,1
    0,13
    10,12
    3,4
    3,0
    8,4
    1,10
    2,14
    8,10
    9,0

    fold along y=7
    fold along x=5
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(17, Day13.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(684, Day13.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(
      """
              ╔═════╗
              ║█████║
              ║█   █║
              ║█   █║
              ║█   █║
              ║█████║
              ╚═════╝
      """.trimIndent(),
      Day13.solvePart2(testInput),
    )
  }
}
