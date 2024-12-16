package aoc.year2024

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.grid
import aoc.library.move

object Day15 : Puzzle<Int, Int>(day = 15) {

  const val Floor = '.'
  const val Wall = '#'
  const val SingleBox = 'O'
  const val Robot = '@'
  const val LeftBox = '['
  const val RightBox = ']'

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
      .filterValues { it == LeftBox || it == SingleBox }
      .keys
      .sumOf {
        100 * it.y + it.x
      }
  }

  fun walk(
    map: Map<Point, Char>,
    direction: Direction,
  ): Map<Point, Char> {
    val robot = map.toList().find { it.second == Robot }!!.first

    val movingPieces = mutableSetOf<Point>()

    fun canPush(from: Point): Boolean = when (val element = map.getValue(from)) {
      Robot, SingleBox -> {
        movingPieces += from
        canPush(from.move(direction))
      }
      Floor -> true
      Wall -> false
      LeftBox -> {
        val pushSelf = canPush(from.move(direction))
        movingPieces += from
        if (direction == Direction.Up || direction == Direction.Down) {
          movingPieces += from.move(Direction.Right)
          pushSelf && canPush(from.move(Direction.Right).move(direction))
        } else {
          pushSelf
        }
      }
      RightBox -> {
        val pushSelf = canPush(from.move(direction))
        movingPieces += from
        if (direction == Direction.Up || direction == Direction.Down) {
          movingPieces += from.move(Direction.Left)
          pushSelf && canPush(from.move(Direction.Left).move(direction))
        } else {
          pushSelf
        }
      }
      else -> error("Invalid char=$element")
    }

    return if (canPush(robot)) {
      map.toMutableMap().apply {
        putAll(movingPieces.associateWith { Floor })
        movingPieces.forEach {
          this[it.move(direction)] = map.getValue(it)
        }
      }
    } else {
      map
    }
  }
}
