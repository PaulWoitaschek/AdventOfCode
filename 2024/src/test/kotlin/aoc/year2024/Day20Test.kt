package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

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
    assertEquals(
      mapOf(
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
      ),
      Day20.cheats(testData),
    )
  }

  @Test
  fun part1() {
    assertEquals(1485, Day20.solvePart1())
  }

  @Test
  @Disabled
  fun part2TestInput() {
    assertEquals(42, Day20.solvePart2())
  }

  @Test
  @Disabled
  fun part2() {
    assertEquals(42, Day20.solvePart2())
  }
}
