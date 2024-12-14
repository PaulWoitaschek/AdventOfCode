package aoc.year2024

import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.print
import kotlin.String

object Day14 : Puzzle<Int, Int>(day = 14) {

  override fun solvePart1(input: String): Int = solvePart1(input, 101, 103)

  fun solvePart1(
    input: String,
    width: Int,
    height: Int,
  ): Int = generateSequence(parse(input)) { robots ->
    robots.map { robot -> robot.step(width, height) }
  }
    .elementAt(100)
    .groupBy {
      val (x, y) = it.position
      val centerX = width / 2
      val centerY = height / 2
      when {
        x < centerX && y < centerY -> 1
        x > centerX && y < centerY -> 2
        x < centerX && y > centerY -> 3
        x > centerX && y > centerY -> 4
        else -> null
      }
    }
    .mapValues { it.value.size }
    .filterKeys { it != null }.values
    .reduce(Int::times)

  override fun solvePart2(input: String): Int = generateSequence(parse(input)) { robots ->
    robots.map { robot -> robot.step(101, 103) }
  }.indexOfFirst { robots ->
    hasRobotCluster(robots)
      .also { hasCluster ->
        if (hasCluster) {
          val map = robots.groupingBy { it.position }.eachCount()
          map.print {
            map[it]?.toString() ?: "."
          }
        }
      }
  }

  private fun hasRobotCluster(robots: List<Robot>): Boolean {
    val positions = robots.map { it.position }.toSet()
    return positions.any {
      positions.containsAll(it.adjacent())
    }
  }

  private fun parse(input: String): List<Robot> = input.lines().map(Robot::parse)

  private data class Robot(val position: Point, val velocity: Point) {
    companion object {
      private val regex = """^p=(\d+),(\d+) v=(-?\d+),(-?\d+)$""".toRegex()
      fun parse(input: String): Robot {
        val (px, py, vx, vy) = regex.find(input)!!.destructured.toList().map(String::toInt)
        return Robot(position = Point(px, py), velocity = Point(vx, vy))
      }
    }

    fun step(
      width: Int,
      height: Int,
    ): Robot = copy(
      position = Point(
        x = (position.x + velocity.x + width) % width,
        y = (position.y + velocity.y + height) % height,
      ),
    )
  }
}
