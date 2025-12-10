package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day10Test {

  private val testInput: String = """
    [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}
    [...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}
    [.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}
  """.trimIndent()

  @Test
  fun part1TestInput() {
    Day10.solvePart1(testInput) shouldBeExactly 7
  }

  @Test
  fun part1() {
    Day10.solvePart1() shouldBeExactly 535
  }

  @Test
  @Disabled
  fun part2TestInput() {
    Day10.solvePart2(testInput) shouldBeExactly 42
  }

  @Test
  @Disabled
  fun part2() {
    Day10.solvePart2() shouldBeExactly 42
  }
}
