package aoc.year2024

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.grid
import aoc.library.move

object Day15 : Puzzle<Int, Int>(day = 15) {

  private const val FLOOR = '.'
  private const val WALL = '#'
  private const val SINGLE_BOX = 'O'
  private const val ROBOT = '@'
  private const val LEFT_BOX = '['
  private const val RIGHT_BOX = ']'

  override fun solvePart1(input: String): Int = solve(input) { it }

  override fun solvePart2(input: String): Int = solve(input) {
    it.replace("#", "##")
      .replace("O", "[]")
      .replace(".", "..")
      .replace("@", "@.")
  }

  private fun solve(
    input: String,
    transformMap: (String) -> String,
  ): Int {
    val (mapValue, movementsValue) = input.split("\n\n")
    var map = grid(
      transformMap(mapValue),
    )
    movementsValue.mapNotNull(Direction::fromArrowOrNull)
      .forEach { direction ->
        map = walk(map, direction)
      }
    return map
      .filterValues { it == LEFT_BOX || it == SINGLE_BOX }
      .keys
      .sumOf {
        100 * it.y + it.x
      }
  }

  fun walk(
    map: Map<Point, Char>,
    direction: Direction,
  ): Map<Point, Char> {
    val robot = map.toList().find { it.second == ROBOT }!!.first

    val movingPieces = mutableSetOf<Point>()

    fun canPush(from: Point): Boolean = when (val element = map.getValue(from)) {
      ROBOT, SINGLE_BOX -> {
        movingPieces += from
        canPush(from.move(direction))
      }
      FLOOR -> true
      WALL -> false
      LEFT_BOX, RIGHT_BOX -> {
        val pushSelf = canPush(from.move(direction))
        movingPieces += from
        if (direction == Direction.Up || direction == Direction.Down) {
          val boxDirection = if (element == LEFT_BOX) Direction.Right else Direction.Left
          val otherHalf = from.move(boxDirection)
          movingPieces += otherHalf
          pushSelf && canPush(otherHalf.move(direction))
        } else {
          pushSelf
        }
      }
      else -> error("Invalid char=$element")
    }

    return if (canPush(robot)) {
      map.toMutableMap().apply {
        putAll(movingPieces.associateWith { FLOOR })
        movingPieces.forEach {
          this[it.move(direction)] = map.getValue(it)
        }
      }
    } else {
      map
    }
  }
}
