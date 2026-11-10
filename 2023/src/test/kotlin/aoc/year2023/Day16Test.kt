package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day16Test {

  private val testInput = """
      .|...\....
      |.-.\.....
      .....|-...
      ........|.
      ..........
      .........\
      ..../.\\..
      .-.-/..|..
      .|....-|.\
      ..//.|....
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(46, Day16.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(6740, Day16.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(51, Day16.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(7041, Day16.solvePart2())
  }
}
