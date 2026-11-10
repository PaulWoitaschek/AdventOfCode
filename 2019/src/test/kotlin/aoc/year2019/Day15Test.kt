package aoc.year2019

import aoc.library.Point
import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day15Test {

  @Test
  fun part1() {
    assertEquals(308, Day15.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(328, Day15.solvePart2())
  }

  @Test
  fun oxygenFillTime() {
    val map = """
         ##
        #..##
        #.#..#
        #.O.#
         ###
    """.trimIndent().lines().flatMapIndexed { y, line ->
      line.mapIndexed { x, char ->
        Point(x, y) to when (char) {
          ' ', '.' -> Day15.Tile.Floor
          'O' -> Day15.Tile.Target
          '#' -> Day15.Tile.Wall
          else -> error("Invalid tile=$char")
        }
      }
    }.associate { it }
    assertEquals(
      4,
      Day15.oxygenFillTime(
        map,
      ),
    )
  }
}
