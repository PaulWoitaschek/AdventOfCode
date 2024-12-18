package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day18Test {

  @Test
  fun part1TestInput() {
    Day18.solvePart1(
      input = """
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
      """.trimIndent(),
      bytes = 12,
      size = 6,
    ) shouldBeExactly 22
  }

  @Test
  fun part1() {
    Day18.solvePart1() shouldBeExactly 286
  }

  @Test
  @Disabled
  fun part2TestInput() {
    Day18.solvePart2() shouldBeExactly 42
  }

  @Test
  @Disabled
  fun part2() {
    Day18.solvePart2() shouldBeExactly 42
  }
}
