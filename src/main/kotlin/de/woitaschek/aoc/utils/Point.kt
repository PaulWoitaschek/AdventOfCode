package de.woitaschek.aoc.utils

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


  override fun toString(): String = "($x,$y)"

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
