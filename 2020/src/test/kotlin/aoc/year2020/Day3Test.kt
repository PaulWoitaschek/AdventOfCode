package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day3Test {

  @Test
  fun part1() {
    assertEquals(193, Day3.solvePart1())
    assertEquals(
      7,
      Day3.solvePart1(
        """
..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(1355323200, Day3.solvePart2())
    assertEquals(
      336,
      Day3.solvePart2(
        """
..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#
        """.trimIndent(),
      ),
    )
  }
}
