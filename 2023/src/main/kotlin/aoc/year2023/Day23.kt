package aoc.year2023

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.grid
import aoc.library.move

object Day23 : Puzzle<Int, Int>(day = 23) {

  override fun solvePart1(input: String): Int {
    val grid = grid(input) { char ->
      when (char) {
        '#' -> Tile.Forest
        '.' -> Tile.Path
        else -> Tile.Slope(Direction.fromArrowOrNull(char)!!)
      }
    }

    val start = grid.filterValues { it is Tile.Path }.minBy { it.key.y }.key
    val end = grid.filterValues { it is Tile.Path }.maxBy { it.key.y }.key

    var max = 0
    fun walk(path: List<Point>) {
      val current = path.last()
      if (current == end) {
        max = maxOf(max, path.size - 1)
        return
      }
      val currentTile = grid[current]!!
      if (currentTile is Tile.Slope) {
        val inSlopeDirection = current.move(currentTile.direction)
        if (inSlopeDirection != path[path.lastIndex - 1]) {
          walk(path + inSlopeDirection)
        }
        return
      }
      current.adjacent()
        .forEach { adjacent ->
          if (adjacent !in path) {
            val tile = grid[adjacent]
            when (tile) {
              Tile.Path -> {
                walk(path + adjacent)
              }
              is Tile.Slope -> {
                walk(path + adjacent)
              }
              Tile.Forest, null -> {}
            }
          }
        }
    }

    walk(listOf(start))

    return max
  }

  override fun solvePart2(input: String): Int {
    TODO()
  }

  private sealed interface Tile {
    data object Path : Tile
    data object Forest : Tile
    data class Slope(var direction: Direction) : Tile
  }
}
