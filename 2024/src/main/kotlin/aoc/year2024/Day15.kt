package aoc.year2024

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.move
import aoc.year2024.Day15.Tile

object Day15 : Puzzle<Long, Long>(day = 15) {

  override fun solvePart1(input: String): Long {
    val (mapValue, movementsValue) = input.split("\n\n")
    var map = buildMap {
      mapValue.lines().forEachIndexed { y, line ->
        line.forEachIndexed { x, char ->
          val tile = when (char) {
            '@' -> Tile.Robot
            '#' -> Tile.Wall
            'O' -> Tile.Box
            '.' -> null
            else -> error("Invalid char $char")
          }
          if (tile != null) {
            put(Point(x, y), tile)
          }
        }
      }
    }
    movementsValue.mapNotNull(Direction::fromArrowOrNull)
      .forEach { direction ->
        map = map.walk(direction)
      }
    return map
      .filterValues { it == Tile.Box }
      .keys
      .sumOf {
        100 * it.y + it.x
      }.toLong()
  }

  override fun solvePart2(input: String): Long {
    TODO()
  }

  enum class Tile {
    Wall,
    Box,
    Robot,
  }
}

fun Map<Point, Tile>.walk(direction: Direction): Map<Point, Tile> {
  val robot = toList().find { it.second == Tile.Robot }!!.first
  val newMap = toMutableMap()

  var currentPosition = robot
  newMap.remove(currentPosition)

  while (true) {
    val nextPosition = currentPosition.move(direction)

    val current = get(currentPosition)
    val next = get(nextPosition)

    if (next == Tile.Wall) return this

    newMap[nextPosition] = current!!

    if (next == null) {
      return newMap
    }

    currentPosition = nextPosition
  }
}
