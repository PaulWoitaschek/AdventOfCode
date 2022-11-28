package de.woitaschek.aoc.year2021

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

  companion object {
    fun parse(from: String): Point {
      val (x, y) = from.split(",")
      return Point(x = x.toInt(), y = y.toInt())
    }
  }
}
