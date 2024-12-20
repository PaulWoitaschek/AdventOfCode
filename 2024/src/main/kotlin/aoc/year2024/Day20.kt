package aoc.year2024

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.bounds
import aoc.library.move

object Day20 : Puzzle<Int, Long>(day = 20) {

  override fun solvePart1(input: String): Int = cheats(input).filter { it.key >= 100 }.values.sum()

  fun cheats(input: String): Map<Int, Int> {
    val walls = mutableSetOf<Point>()
    var start = Point(0, 0)
    var end = Point(0, 0)
    input.lines().forEachIndexed { y, line ->
      line.forEachIndexed { x, char ->
        val point = Point(x, y)
        when (char) {
          '#' -> walls += point
          'S' -> start = point
          'E' -> end = point
        }
      }
    }
    val bounds = walls.bounds()

    val path = mutableListOf(start)
    while (path.last() != end) {
      path += path.last().adjacentOrthogonal().single { it !in walls && it !in path }
    }

    val fastestPaths = path.associateWith { path.size - path.indexOf(it) }

    val cheats = mutableMapOf<Int, Int>()

    path.forEach { point ->
      Direction.entries.forEach { direction ->
        val next = point.move(direction, 2)
        if (next !in walls && next in bounds) {
          val saved = fastestPaths.getValue(point) - fastestPaths.getValue(next) - 2
          cheats[saved] = cheats.getOrDefault(saved, 0) + 1
        }
      }
    }

    return cheats.filter { it.key > 0 }
  }

  override fun solvePart2(input: String): Long {
    TODO()
  }
}
