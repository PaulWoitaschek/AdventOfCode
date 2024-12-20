package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.longs.shouldBeExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day20Test {

  private val testData = """
    ###############
    #...#...#.....#
    #.#.#.#.#.###.#
    #S#...#.#.#...#
    #######.#.#.###
    #######.#.#...#
    #######.#.###.#
    ###..E#...#...#
    ###.#######.###
    #...###...#...#
    #.#####.#.###.#
    #.#...#.#.#...#
    #.#.#.#.#.#.###
    #...#...#...###
    ###############
  """.trimIndent()

  @Test
  fun part1TestInput() {
    Day20.cheats(testData) shouldBe mapOf(
      2 to 14,
      4 to 14,
      6 to 2,
      8 to 4,
      10 to 2,
      12 to 3,
      20 to 1,
      36 to 1,
      38 to 1,
      40 to 1,
      64 to 1,
    )
  }

  @Test
  fun part1() {
    Day20.solvePart1() shouldBeExactly 1485
  }

  @Test
  @Disabled
  fun part2TestInput() {
    Day20.solvePart2() shouldBeExactly 42
  }

  @Test
  @Disabled
  fun part2() {
    Day20.solvePart2() shouldBeExactly 42
  }
}
