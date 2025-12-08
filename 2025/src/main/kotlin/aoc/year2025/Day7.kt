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

    val splitPoints = mutableSetOf<Point>()

    fun tick(beam: Point) {
      val below = beam + Point(0, 1)
      when (grid[below]) {
        '^' -> {
          if (splitPoints.add(below)) {
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

    return splitPoints.size.toLong()
  }

  override fun solvePart2(input: String): Long {
    val grid = grid(input)
    val initial = grid.firstNotNullOf { (point, char) ->
      if (char == 'S') point else null
    }

    val paths = mutableMapOf<Point, List<Point>>()

    fun tick(
      from: Point,
      beam: Point,
    ) {
      val below = beam + Point(0, 1)
      when (grid[below]) {
        '^' -> {
          paths[from] = paths.getOrElse(from) { emptyList() } + below
          if (below !in paths) {
            tick(from = below, beam = below + Point(1, 0))
            tick(from = below, beam = below + Point(-1, 0))
          }
        }
        '.' -> {
          tick(from = from, beam = below)
        }
      }
    }
    tick(initial, initial)

    val cache = mutableMapOf<Point, Long>()
    fun walk(last: Point): Long = cache.getOrPut(last) {
      val reachable = paths[last] ?: emptyList()
      reachable.sumOf { walk(it) } + 1
    }

    return walk(initial)
  }
}
