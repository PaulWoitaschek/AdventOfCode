package aoc.year2025

import aoc.library.Point
import aoc.library.Puzzle
import kotlin.math.absoluteValue

object Day9 : Puzzle<Long, Long>(day = 9) {

  override fun solvePart1(input: String): Long {
    val points = input.lines().map(Point::parse)

    return points.flatMapIndexed { index, p1 ->
      points.drop(index + 1).map { p2 ->
        ((p1.x - p2.x + 1).toLong() * (p1.y - p2.y + 1)).absoluteValue
      }
    }.max()
  }

  override fun solvePart2(input: String): Long {
    TODO()
  }
}
