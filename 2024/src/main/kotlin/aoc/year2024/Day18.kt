package aoc.year2024

import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.Rect
import java.util.PriorityQueue

object Day18 : Puzzle<Int, Point>(day = 18) {
  override fun solvePart1(input: String): Int = solvePart1(input = input, bytes = 1024, size = 70)

  fun solvePart1(
    input: String,
    bytes: Int,
    size: Int,
  ): Int {
    val corrupted = input.lines()
      .map {
        val (x, y) = it.split(",")
        Point(x.toInt(), y.toInt())
      }
      .take(bytes)

    val end = Point(size, size)

    data class State(val point: Point, val steps: Int)

    val queue = PriorityQueue(compareBy<State> { it.steps })
    queue.add(State(Point(0, 0), 0))

    val bounds = Rect(0, 0, size, size)

    val visited = mutableSetOf<Point>()
    while (true) {
      val state = queue.remove()!!
      if (!visited.add(state.point)) continue
      if (state.point == end) {
        return state.steps
      }
      queue += state.point.adjacentOrthogonal()
        .filter { it in bounds && it !in corrupted }
        .map { State(it, state.steps + 1) }
    }
  }

  fun solvePart2(
    input: String,
    size: Int,
  ): Point {
    val allBytes = input.lines()
      .map {
        val (x, y) = it.split(",")
        Point(x.toInt(), y.toInt())
      }
    var bytes = 0
    while (true) {
      bytes++
      if (!isSolvable(allBytes, bytes, size)) {
        return allBytes.elementAt(bytes - 1)
      }
    }
  }

  private fun isSolvable(
    allBytes: List<Point>,
    bytes: Int,
    size: Int,
  ): Boolean {
    val corrupted = allBytes
      .take(bytes)

    val end = Point(size, size)

    data class State(val point: Point, val steps: Int)

    val queue = PriorityQueue(compareBy<State> { it.steps })
    queue.add(State(Point(0, 0), 0))

    val bounds = Rect(0, 0, size, size)

    val visited = mutableSetOf<Point>()
    while (true) {
      if (queue.isEmpty()) {
        return false
      }
      val state = queue.remove()
      if (!visited.add(state.point)) continue
      if (state.point == end) {
        return true
      }
      queue += state.point.adjacentOrthogonal()
        .filter { it in bounds && it !in corrupted }
        .map { State(it, state.steps + 1) }
    }
  }

  override fun solvePart2(input: String): Point = solvePart2(input, 70)
}
