package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day19Test {

  private val testInput = """
      r, wr, b, g, bwu, rb, gb, br

      brwrr
      bggr
      gbbr
      rrbgbr
      ubwu
      bwurrg
      brgr
      bbrgwb
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(6, Day19.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(340, Day19.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(16, Day19.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(717561822679428, Day19.solvePart2())
  }
}
