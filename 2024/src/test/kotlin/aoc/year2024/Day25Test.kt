package aoc.year2024

import aoc.library.solvePart1
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day25Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      3,
      Day25.solvePart1(
        """
        #####
        .####
        .####
        .####
        .#.#.
        .#...
        .....

        #####
        ##.##
        .#.##
        ...##
        ...#.
        ...#.
        .....

        .....
        #....
        #....
        #...#
        #.#.#
        #.###
        #####

        .....
        .....
        #.#..
        ###..
        ###.#
        ###.#
        #####

        .....
        .....
        .....
        #....
        #.#..
        #.#.#
        #####
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(3360, Day25.solvePart1())
  }
}
