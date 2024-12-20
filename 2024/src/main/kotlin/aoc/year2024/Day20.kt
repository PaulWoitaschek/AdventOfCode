package aoc.year2024

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.move
import aoc.library.print
import java.util.PriorityQueue

object Day20 : Puzzle<Long, Long>(day = 20) {

  override fun solvePart1(input: String): Long = cheats(input).filter { it.key >= 100 }.values.sum().toLong()

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
    val width = input.lines().first().length
    val height = input.lines().size

    data class State(val point: Point, val steps: Int)

    val queue = PriorityQueue<State>(compareBy { it.steps })
    queue += State(start, 0)

    val cheats = mutableMapOf<Int, Int>()

    val visited = mutableSetOf<Point>()
    val fastestPaths = mutableMapOf<Point, Int>()
    fun fastestPath(from: Point): Int = fastestPaths.getOrPut(from) {
      fastestPath(from, end, walls)
    }

    println("done!")

    while (true) {
      val state = queue.remove()
      if (!visited.add(state.point)) continue
      if (state.point == end) {
        break
      }

      val pathFrom = fastestPath(state.point)

      Direction.entries.forEach { direction ->
        val inDirection = state.point.move(direction)
        if (inDirection in walls) {
          val next = inDirection.move(direction)
          if (next !in walls && next.x in 0 until width && next.y in 0 until height) {
            val took = fastestPath(next)
            val saved = pathFrom - took - 2
            cheats[saved] = cheats.getOrDefault(saved, 0) + 1
          }
        }
      }

      state.point.adjacentOrthogonal()
        .filter { it !in walls }
        .forEach {
          queue += State(it, steps = state.steps + 1)
        }
    }

    walls.print()
    return cheats.filter { it.key > 0 }
  }

  data class State(val point: Point, val steps: Int)

  private fun fastestPath(
    start: Point,
    end: Point,
    walls: Set<Point>,
  ): Int {
    val queue = PriorityQueue<State>(compareBy { it.steps })
    queue += State(start, 0)

    val visited = mutableSetOf<Point>()
    while (true) {
      val state = queue.remove()
      if (!visited.add(state.point)) continue
      if (state.point == end) {
        return state.steps
      }

      state.point.adjacentOrthogonal()
        .filter { it !in walls }
        .mapTo(queue) { State(it, steps = state.steps + 1) }
    }
  }

  override fun solvePart2(input: String): Long {
    TODO()
  }
}
