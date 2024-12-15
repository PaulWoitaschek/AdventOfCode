package aoc.year2024

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.grid
import aoc.library.move

object Day15 : Puzzle<Long, Long>(day = 15) {

  const val Space = '.'
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
      .filterValues { it == SingleBox }
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

    fun canPush(from: Point): Boolean {
      val next = from.move(direction)
      return when (map.getValue(next)) {
        Wall -> false
        Space -> true
        else -> canPush(next)
      }
    }

    val canPush = canPush(robot)
    if (!canPush) return map

    val newMap = map.toMutableMap()
    fun push(from: Point) {
      val value = map.getValue(from)
      if (value == Space) return

      val next = from.move(direction)
      newMap[next] = value
      if (from == robot) {
        newMap[from] = Space
      }
      push(next)
    }

    push(robot)

    return newMap
  }
}
