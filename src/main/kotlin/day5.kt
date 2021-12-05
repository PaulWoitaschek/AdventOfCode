import kotlin.math.abs

fun day5(input: String): Int {
  return process(input, includeDiagonals = false)
}

fun day5Part2(input: String): Int {
  return process(input, includeDiagonals = true)
}

private fun process(input: String, includeDiagonals: Boolean): Int {
  val lines = input.lines().map(Line::parse)

  val pointScores = mutableMapOf<Point, Int>()
  lines.forEach { line ->
    line.pointsOnLine(includeDiagonals = includeDiagonals)
      .forEach { point ->
        pointScores[point] = pointScores.getOrPut(point) { 0 } + 1
      }
  }
  return pointScores.count { it.value >= 2 }
}

private data class Line(
  val from: Point,
  val to: Point,
) {

  fun pointsOnLine(includeDiagonals: Boolean): List<Point> {
    return when {
      from.x == to.x -> {
        (minOf(from.y, to.y)..maxOf(from.y, to.y)).map { rangeY ->
          Point(x = from.x, y = rangeY)
        }
      }
      from.y == to.y -> {
        (minOf(from.x, to.x)..maxOf(from.x, to.x)).map { rangeX ->
          Point(x = rangeX, y = from.y)
        }
      }
      includeDiagonals && (abs(from.x - to.x) == abs(from.y - to.y)) -> {
        val results = mutableListOf<Point>()
        results += from
        var currentPoint = from
        val up = from.y < to.y
        val right = from.x < to.x
        do {
          currentPoint = Point(
            x = currentPoint.x + if (right) 1 else -1,
            y = currentPoint.y + if (up) 1 else -1
          )
          results += currentPoint
        } while (currentPoint != to)
        results
      }
      else -> {
        emptyList()
      }
    }
  }

  companion object {
    fun parse(input: String): Line {
      val (from, to) = input.split(" -> ")
      return Line(
        from = Point.parse(from),
        to = Point.parse(to)
      )
    }
  }
}

private data class Point(val x: Int, val y: Int) {

  companion object {
    fun parse(from: String): Point {
      val (x, y) = from.split(",")
      return Point(x = x.toInt(), y = y.toInt())
    }
  }
}
