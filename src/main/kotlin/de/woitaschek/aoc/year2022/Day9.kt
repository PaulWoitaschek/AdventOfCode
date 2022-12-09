package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.utils.Point
import de.woitaschek.aoc.utils.Puzzle
import kotlin.math.abs

object Day9 : Puzzle(2022, 9) {

  override fun solvePart1(input: String) = solve(knots = 2, input = input)

  override fun solvePart2(input: String) = solve(knots = 10, input = input)

  private fun solve(knots: Int, input: String): Int {
    var head = Point(0, 0)
    var tail = List(knots - 1) { head }
    val visitedPoints = mutableSetOf<Point>()
    parseInput(input)
      .flatMap { instruction ->
        (0 until instruction.steps).map { instruction.direction }
      }
      .forEach { direction ->
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
        tail = tail.scan(head) { head: Point, tail: Point ->
          val xDistance = head.x - tail.x
          val yDistance = head.y - tail.y
          val shouldMoveHorizontally = abs(xDistance) > 1
          val shouldMoveVertically = abs(yDistance) > 1
          if (shouldMoveHorizontally && shouldMoveVertically) {
            tail.copy(
              x = if (xDistance > 0) tail.x + 1 else tail.x - 1,
              y = if (yDistance > 0) tail.y + 1 else tail.y - 1,
            )
          } else if (shouldMoveHorizontally) {
            if (xDistance > 0) {
              tail.copy(x = tail.x + 1, y = head.y)
            } else {
              tail.copy(x = tail.x - 1, y = head.y)
            }
          } else if (shouldMoveVertically) {
            if (yDistance > 0) {
              tail.copy(y = tail.y + 1, x = head.x)
            } else {
              tail.copy(y = tail.y - 1, x = head.x)
            }
          } else {
            tail
          }
        }.drop(1)
        visitedPoints.add(tail.last())
      }
    return visitedPoints.size
  }

  private fun parseInput(input: String): List<Instruction> = input.lines().filter { it.isNotEmpty() }
    .map {
      Instruction(direction = Direction.parse(it.first()), steps = it.drop(2).toInt())
    }

  private data class Instruction(val direction: Direction, val steps: Int)

  private enum class Direction(var char: Char) {
    Left('L'), Right('R'), Up('U'), Down('D');

    companion object {
      fun parse(input: Char) = values().first { it.char == input }
    }
  }
}
