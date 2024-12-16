package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day16Test {

  @Test
  fun part1TestInput() {
    Day16.solvePart1(
      """
      ###############
      #.......#....E#
      #.#.###.#.###.#
      #.....#.#...#.#
      #.###.#####.#.#
      #.#.#.......#.#
      #.#.#####.###.#
      #...........#.#
      ###.#.#####.#.#
      #...#.....#.#.#
      #.#.#.###.#.#.#
      #.....#...#.#.#
      #.###.#.#.#.#.#
      #S..#.....#...#
      ###############
      """.trimIndent(),
    ) shouldBeExactly 7036
  }

  @Test
  fun part1TestInput2() {
    Day16.solvePart1(
      """
      #################
      #...#...#...#..E#
      #.#.#.#.#.#.#.#.#
      #.#.#.#...#...#.#
      #.#.#.#.###.#.#.#
      #...#.#.#.....#.#
      #.#.#.#.#.#####.#
      #.#...#.#.#.....#
      #.#.#####.#.###.#
      #.#.#.......#...#
      #.#.###.#####.###
      #.#.#...#.....#.#
      #.#.#.#####.###.#
      #.#.#.........#.#
      #.#.#.#########.#
      #S#.............#
      #################
      """.trimIndent(),
    ) shouldBeExactly 11048
  }

  @Test
  fun part1() {
    Day16.solvePart1() shouldBeExactly 143580
  }

  @Test
  @Disabled
  fun part2TestInput() {
    Day16.solvePart2() shouldBeExactly 42
  }

  @Test
  @Disabled
  fun part2() {
    Day16.solvePart2() shouldBeExactly 42
  }
}
