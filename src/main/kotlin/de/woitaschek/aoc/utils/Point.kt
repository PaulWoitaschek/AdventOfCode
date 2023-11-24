package de.woitaschek.aoc.utils

import kotlin.math.absoluteValue
import kotlin.math.atan2

data class Point(val x: Int, val y: Int) {

  fun adjacent(includeDiagonal: Boolean = false): List<Point> {
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

  fun degreesTo(other: Point): Double {
    val atan2 = atan2(
      y = (other.y - this.y).toDouble(),
      x = (other.x - this.x).toDouble(),
    )
    return (Math.toDegrees(atan2) + 90 + 360) % 360
  }

  override fun toString(): String = "($x,$y)"

  operator fun plus(other: Point): Point = Point(x = x + other.x, y = y + other.y)

  companion object {
    val Zero = Point(0, 0)
    fun parse(from: String): Point {
      val (x, y) = from.split(",")
      return Point(x = x.toInt(), y = y.toInt())
    }
  }
}

fun Point.move(
  direction: Direction,
  upIsPositive: Boolean = true,
) = Point(
  x = x + when (direction) {
    Direction.Left -> -1
    Direction.Right -> 1
    Direction.Up, Direction.Down -> 0
  },
  y = y + when (direction) {
    Direction.Up -> if (upIsPositive) 1 else -1
    Direction.Down -> if (upIsPositive) -1 else 1
    Direction.Left, Direction.Right -> 0
  },
)

fun Collection<Point>.printString(): String = associateWith { }.printString {
  if (it in this) "⬛" else "⬜"
}

inline fun <T> Map<Point, T>.printString(crossinline tile: (Point) -> String): String {
  if (isEmpty()) {
    return "EMPTY MAP"
  }
  val points = keys
  return (points.minOf { it.y }.rangeTo(points.maxOf { it.y })).joinToString(separator = "\n") { y ->
    (points.minOf { it.x }.rangeTo(points.maxOf { it.x })).joinToString(separator = "") { x ->
      tile(Point(x, y))
    }
  }
}

fun Collection<Point>.print() {
  println(printString())
}

inline fun <T> Map<Point, T>.print(crossinline tile: (Point) -> String) {
  println(printString(tile))
}
