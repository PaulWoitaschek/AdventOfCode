package aoc.year2021

import aoc.library.Point
import aoc.library.Puzzle

object Day9 : Puzzle<Long, Long>(2021, 9) {

  override fun solvePart1(input: String): Long {
    return HeightMap.parse(input)
      .riskLevelSum()
      .toLong()
  }

  override fun solvePart2(input: String): Long {
    return HeightMap.parse(input)
      .multipliedSumOfThreeHighestBasins()
      .toLong()
  }
}

private data class HeightMap(
  private val heights: List<List<Int>>,
) {

  private val allPoints: List<PointWithValue> = heights.flatMapIndexed { y, columns ->
    columns.mapIndexed { x, value ->
      PointWithValue(point = Point(x, y), value = value)
    }
  }

  fun riskLevelSum(): Int {
    return lowPointCoordinates().sumOf { it.value + 1 }
  }

  fun multipliedSumOfThreeHighestBasins(): Int {
    return basins()
      .sortedDescending()
      .take(3)
      .reduce { acc, i -> acc * i }
  }

  private fun basins(): List<Int> {
    return lowPointCoordinates().map { basinCoordinates(it).count() }
  }

  private fun lowPointCoordinates(): List<PointWithValue> {
    return allPoints.filter { point ->
      point.surroundingPoints().all { it.value > point.value }
    }
  }

  private fun basinCoordinates(from: PointWithValue): Set<PointWithValue> {
    return mutableSetOf<PointWithValue>().also { set ->
      addBasinCoordinates(from, set)
    }
  }

  private fun addBasinCoordinates(
    from: PointWithValue,
    result: MutableSet<PointWithValue>,
  ) {
    result += from
    from.surroundingPoints().forEach { surrounding ->
      if (surrounding.value < 9 && surrounding.value > from.value) {
        addBasinCoordinates(surrounding, result)
      }
    }
  }

  companion object {
    fun parse(input: String): HeightMap {
      return HeightMap(
        input.lines()
          .map { line ->
            line.toList().map {
              it.digitToInt()
            }
          },
      )
    }
  }

  private fun PointWithValue.surroundingPoints(): List<PointWithValue> {
    return point.adjacent(includeDiagonal = false)
      .mapNotNull { adjacentPoint -> allPoints.find { it.point == adjacentPoint } }
  }

  private data class PointWithValue(val point: Point, val value: Int)
}
