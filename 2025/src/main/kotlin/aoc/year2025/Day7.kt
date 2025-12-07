package aoc.year2025

import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.grid

object Day7 : Puzzle<Long, Long>(day = 7) {

  override fun solvePart1(input: String): Long {
    val grid = grid(input)
    val start = grid.firstNotNullOf { (point, char) ->
      if (char == 'S') point else null
    }

    val splits = mutableSetOf<Point>()

    fun tick(beam: Point) {
      val below = beam + Point(0, 1)
      when (grid[below]) {
        '^' -> {
          if (splits.add(below)) {
            tick(below + Point(1, 0))
            tick(below + Point(-1, 0))
          }
        }
        '.' -> {
          tick(below)
        }
      }
    }
    tick(start)

    return splits.size.toLong()
  }

  override fun solvePart2(input: String): Long {
    TODO()
  }
}
