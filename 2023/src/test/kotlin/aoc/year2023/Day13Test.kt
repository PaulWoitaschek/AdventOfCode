package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day13Test {

  private val testInput: String = """
    #.##..##.
    ..#.##.#.
    ##......#
    ##......#
    ..#.##.#.
    ..##..##.
    #.#.##.#.

    #...##..#
    #....#..#
    ..##..###
    #####.##.
    #####.##.
    ..##..###
    #....#..#
  """.trimIndent()

  @Test
  fun part1() {
    assertEquals(33975, Day13.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(405, Day13.solvePart1(testInput))
  }

  @Test
  fun part2() {
    assertEquals(29083, Day13.solvePart2())
  }

  @Test
  fun part2Problematic() {
    assertEquals(
      1000,
      Day13.solvePart2(
        """
        #...##...#..#.#..
        #...##...#..#.#..
        .#.#...#.#....#..
        #.#..#.##..##.#.#
        #..###.#..#..#...
        ###.#####.##.#.#.
        ##############...
        #.....#######..#.
        ..##..##.####..##
        #.####..##.#..#.#
        #.####..##.#..#.#
        ..##..##.####..##
        #.....#######..#.
        ##############..#
        ###.#####.##.#.#.
        #..###.#..#..#...
        #.#..#.##..##.#.#
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2TestInput() {
    assertEquals(400, Day13.solvePart2(testInput))
  }
}
