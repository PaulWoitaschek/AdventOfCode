package year2019

import utils.Point3
import utils.Puzzle
import utils.toLineList
import kotlin.math.absoluteValue

object Day12 : Puzzle<Int, Long>(2019, 12) {

  override fun solvePart1(input: String): Int {
    val moons = moonPositions(input).map(::Moon)
    repeat(1000) {
      runStep(moons)
    }
    return moons.sumOf { moon ->
      listOf(moon.position.x, moon.position.y, moon.position.z).sumOf { it.absoluteValue } *
        listOf(moon.velocity.x, moon.velocity.y, moon.velocity.z).sumOf { it.absoluteValue }
    }
  }

  override fun solvePart2(input: String): Long {
    val moons = moonPositions(input).map(::Moon)
    var step = 0L
    val stabilized = mutableMapOf<Point3.Axis, Long>()
    while (true) {
      step++
      runStep(moons)

      Point3.Axis.entries.forEach { axis ->
        if (axis !in stabilized) {
          if (moons.all { it.isStable(axis) }) {
            stabilized[axis] = step
          }
        }
      }

      if (stabilized.keys.containsAll(Point3.Axis.entries)) {
        var lcm = stabilized.values.first()
        stabilized.values.forEach {
          lcm = lcm(lcm, it)
        }
        return lcm
      }
    }
  }

  private fun runStep(moons: List<Moon>) {
    moons.forEach { left ->
      moons.forEach { right ->
        if (left != right) {
          left.velocity += (right.position - left.position).sign()
        }
      }
    }
    moons.forEach {
      it.position += it.velocity
    }
  }

  private fun moonPositions(input: String): List<Point3> {
    return input.toLineList()
      .map { value ->
        val (x, y, z) = "<x=(.*?), y=(.*?), z=(.*?)>"
          .toRegex()
          .find(value)!!
          .destructured.toList()
          .map(String::toInt)
        Point3(x, y, z)
      }
  }
}

private data class Moon(
  val originalPosition: Point3,
  var position: Point3,
  var velocity: Point3,
) {

  constructor(originalPosition: Point3) : this(originalPosition, originalPosition, Point3.Zero)

  fun isStable(axis: Point3.Axis): Boolean {
    return velocity[axis] == 0 && position[axis] == originalPosition[axis]
  }
}

private fun gcd(
  a: Long,
  b: Long,
): Long {
  return if (b == 0L) a else gcd(b, a % b)
}

private fun lcm(
  a: Long,
  b: Long,
): Long {
  return (a * b).absoluteValue / gcd(a, b)
}
