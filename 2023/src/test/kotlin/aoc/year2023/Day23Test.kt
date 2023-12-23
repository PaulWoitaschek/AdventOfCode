package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.ints.shouldBeExactly
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day23Test {

  @Test
  fun part1TestInput() {
    Day23.solvePart1(
      """
      #.#####################
      #.......#########...###
      #######.#########.#.###
      ###.....#.>.>.###.#.###
      ###v#####.#v#.###.#.###
      ###.>...#.#.#.....#...#
      ###v###.#.#.#########.#
      ###...#.#.#.......#...#
      #####.#.#.#######.#.###
      #.....#.#.#.......#...#
      #.#####.#.#.#########v#
      #.#...#...#...###...>.#
      #.#.#v#######v###.###v#
      #...#.>.#...>.>.#.###.#
      #####v#.#.###v#.#.###.#
      #.....#...#...#.#.#...#
      #.#########.###.#.#.###
      #...###...#...#...#.###
      ###.###.#.###v#####v###
      #...#...#.#.>.>.#.>.###
      #.###.###.#.###.#.#v###
      #.....###...###...#...#
      #####################.#
      """.trimIndent(),
    ) shouldBeExactly 94
  }

  @Test
  fun part1() {
    Day23.solvePart1() shouldBeExactly 2174
  }

  @Test
  @Disabled
  fun part2TestInput() {
    Day23.solvePart2() shouldBeExactly 42
  }

  @Test
  @Disabled
  fun part2() {
    Day23.solvePart2() shouldBeExactly 42
  }
}
