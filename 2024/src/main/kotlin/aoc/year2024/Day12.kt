package aoc.year2024

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.move

object Day12 : Puzzle<Int, Int>(12) {

  override fun solvePart2(input: String): Int = solve(input, ::perimeterV2)

  override fun solvePart1(input: String): Int = solve(input, ::perimeterV1)

  private fun solve(
    input: String,
    perimeter: (Set<Point>) -> Int,
  ): Int {
    val garden = parse(input)
    return clusterByRegions(garden).sumOf {
      val pointsInRegion = it.points
      perimeter(pointsInRegion) * pointsInRegion.size
    }
  }

  private fun clusterByRegions(garden: Map<Point, Char>): List<Region> {
    val regions = mutableListOf<Region>()
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
        regions += Region(groupChar, group)
        visited.addAll(group)
      }
    }
    return regions
  }

  private fun parse(input: String): Map<Point, Char> = input.lines().flatMapIndexed { y, line ->
    line.mapIndexed { x, char ->
      Point(x, y) to char
    }
  }.toMap()

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

  private data class Region(val char: Char, val points: Set<Point>)
}
