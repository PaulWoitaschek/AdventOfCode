package aoc.year2024

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.grid
import aoc.library.move

object Day12 : Puzzle<Int, Int>(12) {

  override fun solvePart2(input: String): Int = solve(input, ::perimeterV2)

  override fun solvePart1(input: String): Int = solve(input, ::perimeterV1)

  private fun solve(
    input: String,
    perimeter: (Set<Point>) -> Int,
  ): Int {
    val garden = grid(input)
    return clusterByRegions(garden).sumOf {
      perimeter(it) * it.size
    }
  }

  private fun clusterByRegions(garden: Map<Point, Char>): List<Set<Point>> {
    val regions = mutableListOf<Set<Point>>()
    val visited = mutableSetOf<Point>()
    garden.keys.forEach { start ->
      if (start !in visited) {
        val groupChar = garden.getValue(start)
        val group = mutableSetOf<Point>()
        fun visit(point: Point) {
          if (!group.add(point)) return
          point.adjacentOrthogonal()
            .forEach { adjacent ->
              val char = garden[adjacent]
              if (char == groupChar) {
                visit(adjacent)
              }
            }
        }
        visit(start)
        regions += group
        visited.addAll(group)
      }
    }
    return regions
  }

  private fun perimeterV1(points: Set<Point>): Int = points.sumOf { point ->
    point.adjacentOrthogonal().count { it !in points }
  }

  private fun perimeterV2(points: Set<Point>): Int {
    fun Point.hasFence(direction: Direction): Boolean = this in points && move(direction) !in points
    return points.sumOf { point ->
      Direction.entries.count { direction ->
        point.hasFence(direction) && !point.move(direction.clockwise()).hasFence(direction)
      }
    }
  }
}
