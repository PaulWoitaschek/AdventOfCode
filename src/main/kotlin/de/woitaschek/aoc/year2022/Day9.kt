package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.utils.Point
import de.woitaschek.aoc.utils.Puzzle
import kotlin.math.abs
import kotlin.math.sign

object Day9 : Puzzle(2022, 9) {

  override fun solvePart1(input: String) = solve(knots = 2, input = input)

  override fun solvePart2(input: String) = solve(knots = 10, input = input)

  private fun solve(knots: Int, input: String): Int {
    var head = Point(0, 0)
    var tail = List(knots - 1) { head }
    val visitedPoints = mutableSetOf<Point>()
    parseInput(input).forEach { direction ->
      head = head.copy(
        x = when (direction) {
          Direction.Left -> head.x - 1
          Direction.Right -> head.x + 1
          Direction.Up, Direction.Down -> head.x
        },
        y = when (direction) {
          Direction.Up -> head.y + 1
          Direction.Down -> head.y - 1
          Direction.Left, Direction.Right -> head.y
        },
      )
      tail = tail.scan(head) { head, tail ->
        val xDistance = head.x - tail.x
        val yDistance = head.y - tail.y
        when {
          abs(xDistance) == 2 && abs(yDistance) == 2 -> Point(
            x = tail.x + xDistance.sign,
            y = tail.y + yDistance.sign,
          )
          abs(xDistance) == 2 -> Point(
            x = tail.x + xDistance.sign,
            y = head.y,
          )
          abs(yDistance) == 2 -> Point(
            y = tail.y + yDistance.sign,
            x = head.x,
          )
          else -> tail
        }
      }.drop(1)
      visitedPoints.add(tail.last())
    }
    return visitedPoints.size
  }

  private fun parseInput(input: String): List<Direction> = input.lines().filter { it.isNotEmpty() }
    .flatMap {
      val direction = Direction.parse(it.first())
      List(it.drop(2).toInt()) {
        direction
      }
    }

  private enum class Direction(var char: Char) {
    Left('L'), Right('R'), Up('U'), Down('D');

    companion object {
      fun parse(input: Char) = values().first { it.char == input }
    }
  }
}
