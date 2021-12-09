object Day9 : Puzzle {

  override val day = 9

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
  private val heights: List<List<Int>>
) {

  private val allPoints: List<Point> = heights.flatMapIndexed { y, columns ->
    columns.mapIndexed { x, value ->
      Point(x = x, y = y, value = value)
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

  private fun lowPointCoordinates(): List<Point> {
    return allPoints.filter { point ->
      point.surroundingPoints().all { it.value > point.value }
    }
  }

  private fun basinCoordinates(from: Point): Set<Point> {
    return mutableSetOf<Point>().also { set ->
      addBasinCoordinates(from, set)
    }
  }

  private fun addBasinCoordinates(from: Point, result: MutableSet<Point>) {
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
          }
      )
    }
  }

  private fun Point.surroundingPoints(): List<Point> {
    return listOf(x to y + 1, x to y - 1, x + 1 to y, x - 1 to y)
      .mapNotNull { (x, y) ->
        allPoints.find { it.x == x && it.y == y }
      }
  }

  private data class Point(val x: Int, val y: Int, val value: Int)
}

