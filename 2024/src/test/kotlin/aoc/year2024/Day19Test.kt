package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Test

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
    Day19.solvePart1(testInput) shouldBeExactly 6
  }

  @Test
  fun part1() {
    Day19.solvePart1() shouldBeExactly 340
  }

  @Test
  fun part2TestInput() {
    Day19.solvePart2(testInput) shouldBeExactly 16
  }

  @Test
  fun part2() {
    Day19.solvePart2() shouldBeExactly 717561822679428
  }
}
