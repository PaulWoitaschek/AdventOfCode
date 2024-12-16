package aoc.year2024

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.grid
import aoc.library.move

object Day15 : Puzzle<Long, Long>(day = 15) {

  const val Floor = '.'
  const val Wall = '#'
  const val SingleBox = 'O'
  const val Robot = '@'
  const val LeftBox = '['
  const val RightBox = ']'

  override fun solvePart1(input: String): Long {
    val (mapValue, movementsValue) = input.split("\n\n")
    var map = grid(mapValue)
    movementsValue.mapNotNull(Direction::fromArrowOrNull)
      .forEach { direction ->
        map = walk(map, direction)
      }
    return map
      .filterValues { it == SingleBox }
      .keys
      .sumOf {
        100 * it.y + it.x
      }.toLong()
  }

  override fun solvePart2(input: String): Long {
    val (mapValue, movementsValue) = input.split("\n\n")
    var map = grid(
      mapValue
        .replace("#", "##")
        .replace("O", "[]")
        .replace(".", "..")
        .replace("@", "@."),
    )
    movementsValue.mapNotNull(Direction::fromArrowOrNull)
      .forEach { direction ->
        map = walk(map, direction)
      }
    return map
      .filterValues { it == LeftBox }
      .keys
      .sumOf {
        100 * it.y + it.x
      }.toLong()
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

    val canPush = canPush(robot)

    if (canPush) {
      val newMap = map.toMutableMap()
      movingPieces.forEach {
        newMap[it] = Floor
      }
      movingPieces.forEach {
        newMap[it.move(direction)] = map.getValue(it)
      }
      return newMap
    } else {
      return map
    }
  }
}
