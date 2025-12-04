package aoc.year2025

import aoc.library.Grid
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.grid

object Day4 : Puzzle<Int, Int>(day = 4) {

  override fun solvePart1(input: String): Int {
    val grid = parse(input)
    return grid
      .count { (point, isPaper) ->
        isPaper && isRemovable(grid, point)
      }
  }

  override fun solvePart2(input: String): Int {
    val grid = parse(input).toMutableMap()
    var removed = 0
    while (true) {
      val removablePaperRolls = removablePaperRolls(grid)
      if (removablePaperRolls.isEmpty()) {
        return removed
      } else {
        removed += removablePaperRolls.size
        removablePaperRolls.forEach {
          grid[it] = false
        }
      }
    }
  }

  private fun removablePaperRolls(grid: Grid<Boolean>): Set<Point> = grid.filter { (point, isPaper) ->
    isPaper && isRemovable(grid, point)
  }.keys

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
  ): Boolean = point.adjacent().count {
    grid[it] == true
  } < 4
}
