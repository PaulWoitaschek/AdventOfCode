package aoc.year2024

import aoc.library.solvePart1
import io.kotest.matchers.ints.shouldBeExactly
import org.junit.jupiter.api.Test

class Day25Test {

  @Test
  fun part1TestInput() {
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
    ) shouldBeExactly 3
  }

  @Test
  fun part1() {
    Day25.solvePart1() shouldBeExactly 3360
  }
}
