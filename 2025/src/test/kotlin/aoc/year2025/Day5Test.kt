package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Test

class Day5Test {

  private val testInput = """
        3-5
        10-14
        16-20
        12-18

        1
        5
        8
        11
        17
        32
  """.trimIndent()

  @Test
  fun part1TestInput() {
    Day5.solvePart1(testInput) shouldBeExactly 3
  }

  @Test
  fun part1() {
    Day5.solvePart1() shouldBeExactly 652
  }

  @Test
  fun part2TestInput() {
    Day5.solvePart2(testInput) shouldBeExactly 14
  }

  @Test
  fun part2() {
    Day5.solvePart2() shouldBeExactly 341753674214273
  }
}
