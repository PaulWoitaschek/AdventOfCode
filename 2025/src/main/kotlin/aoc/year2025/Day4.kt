package aoc.year2025

import aoc.library.Grid
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.grid

object Day4 : Puzzle<Int, Int>(day = 4) {

  override fun solvePart1(input: String): Int {
    val grid = parse(input)
    return grid.filterValues { it }
      .count {
        isRemovable(grid, it.key)
      }
  }

  override fun solvePart2(input: String): Int {
    val grid = parse(input).toMutableMap()

    var removed = 0
    while (true) {
      val toRemove = grid.firstNotNullOfOrNull {
        if (it.value && isRemovable(grid, it.key)) {
          it.key
        } else {
          null
        }
      }
      if (toRemove != null) {
        grid[toRemove] = false
        removed++
      } else {
        break
      }
    }

    return removed
  }

  private fun parse(input: String): Grid<Boolean> = grid(input).mapValues { (_, char) ->
    when (char) {
      '.' -> false
      '@' -> true
      else -> error("")
    }
  }

  private fun isRemovable(
    grid: Grid<Boolean>,
    point: Point,
  ): Boolean {
    val adjacent = point.adjacent()
    return adjacent.count {
      grid[it] == true
    } < 4
  }
}
