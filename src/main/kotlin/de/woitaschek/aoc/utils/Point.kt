package de.woitaschek.aoc.utils

import kotlin.math.absoluteValue

data class Point(val x: Int, val y: Int) {

  fun adjacent(includeDiagonal: Boolean): List<Point> {
    val horizontal = listOf(
      Point(x = x, y = y - 1),
      Point(x = x, y = y + 1),
      Point(x = x - 1, y = y),
      Point(x = x + 1, y = y),
    )
    return if (includeDiagonal) {
      val diagonal = listOf(
        Point(x = x - 1, y = y - 1),
        Point(x = x - 1, y = y + 1),
        Point(x = x + 1, y = y - 1),
        Point(x = x + 1, y = y + 1),
      )
      horizontal + diagonal
    } else {
      horizontal
    }
  }

  fun manhattanDistanceTo(other: Point): Int {
    return (x - other.x).absoluteValue + (y - other.y).absoluteValue
  }

  override fun toString(): String = "($x,$y)"

  operator fun plus(other: Point): Point = Point(x = x + other.x, y = y + other.y)

  companion object {
    fun parse(from: String): Point {
      val (x, y) = from.split(",")
      return Point(x = x.toInt(), y = y.toInt())
    }
  }
}

fun Point.move(direction: Direction) = Point(
  x = x + when (direction) {
    Direction.Left -> -1
    Direction.Right -> 1
    Direction.Up, Direction.Down -> 0
  },
  y = y + when (direction) {
    Direction.Up -> 1
    Direction.Down -> -1
    Direction.Left, Direction.Right -> 0
  },
)

fun printString(points: Iterable<Point>): String {
  return (points.minOf { it.y }..points.maxOf { it.y }).joinToString(separator = "\n") { y ->
    (points.minOf { it.x }..points.maxOf { it.x }).joinToString(separator = "") { x ->
      if (Point(x, y) in points) "█" else " "
    }
  }
}

fun printPoints(points: Iterable<Point>) {
  println(printString(points))
}
