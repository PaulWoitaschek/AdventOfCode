package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Test
import kotlin.String

class Day6Test {

  private val testInput: String = """
    123 328  51 64
     45 64  387 23
      6 98  215 314
    *   +   *   +
  """.trimIndent()

  @Test
  fun part1TestInput() {
    Day6.solvePart1(testInput) shouldBeExactly 4277556
  }

  @Test
  fun part1() {
    Day6.solvePart1() shouldBeExactly 4309240495780
  }

  @Test
  fun part2TestInput() {
    Day6.solvePart2(testInput) shouldBeExactly 3263827
  }

  @Test
  fun part2() {
    Day6.solvePart2() shouldBeExactly 9170286552289
  }
}
