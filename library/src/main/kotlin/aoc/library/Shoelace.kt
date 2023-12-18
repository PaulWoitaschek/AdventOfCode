package aoc.library

import kotlin.math.abs

fun shoelace(points: List<Point>): Long {
  val polygon = points.toMutableList()
  if (polygon.first() != polygon.last()) {
    polygon.add(polygon.first())
  }
  val x = polygon.map(Point::x).map(Int::toLong)
  val y = polygon.map(Point::y).map(Int::toLong)
  val left = x.zip(y.drop(1), Long::times)
  val right = x.drop(1).zip(y, Long::times)
  return abs(left.zip(right, Long::minus).sum() / 2)
}
