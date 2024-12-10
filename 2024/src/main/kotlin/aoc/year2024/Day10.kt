package aoc.year2024

import aoc.library.Point
import aoc.library.Puzzle

object Day10 : Puzzle<Int, Int>(day = 10) {

  override fun solvePart1(input: String): Int = findTrailPaths(input, countUniqueTrails = true)

  override fun solvePart2(input: String): Int = findTrailPaths(input, countUniqueTrails = false)

  private fun findTrailPaths(
    input: String,
    countUniqueTrails: Boolean,
  ): Int {
    val mountains = input.lines().flatMapIndexed { y, line ->
      line.mapIndexed { x, char ->
        Point(x, y) to (char.digitToIntOrNull() ?: -1)
      }
    }.toMap()
    return mountains.toList()
      .sumOf { (point, height) ->
        if (height == 0) {
          val reachedNines = mutableListOf<Point>()
          fun visit(
            currentHeight: Int,
            point: Point,
          ) {
            val heightAtPoint = mountains[point] ?: return
            if (heightAtPoint == currentHeight + 1) {
              if (heightAtPoint == 9) {
                reachedNines += point
              } else {
                point.adjacentOrthogonal().forEach {
                  visit(heightAtPoint, it)
                }
              }
            }
          }
          visit(-1, point)
          if (countUniqueTrails) {
            reachedNines.toSet().size
          } else {
            reachedNines.size
          }
        } else {
          0
        }
      }
  }
}
