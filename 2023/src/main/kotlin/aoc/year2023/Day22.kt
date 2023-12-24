package aoc.year2023

import aoc.library.Point
import aoc.library.Point3
import aoc.library.Puzzle

object Day22 : Puzzle<Int, Int>(day = 22) {

  override fun solvePart1(input: String): Int {
    val bricks = input.lines().map(Brick::parse).sortedBy { it.bottomZ() }
    move(bricks)
    val bricksWithSupporters = bricks.associateWith { brick ->
      val supporters = bricks.filter { it != brick }
        .filter { it.xyPointsIntersect(brick) }
        .filter { it.topZ() == brick.bottomZ() - 1 }
      val highestZSupport = supporters.maxOfOrNull { it.topZ() }
      supporters.filter {
        highestZSupport != null && it.topZ() >= highestZSupport
      }
    }
    val vitalSupporters = bricks.filter { brick ->
      val sup = bricksWithSupporters.values
      listOf(brick) in sup
    }
    return bricks.size - vitalSupporters.size
  }

  override fun solvePart2(input: String): Int {
    val bricks = input.lines().map(Brick::parse).sortedBy { it.bottomZ() }

    var ii = 0
    return bricks.sumOf { deintegrationCandidate ->
      println("${ii++} / ${bricks.size}")
      bricks.forEach { it.zOffset = 0 }
      move(bricks)
      val withoutDeintegration = bricks - deintegrationCandidate
      val offsets = withoutDeintegration.map { it.bottomZ() }
      move(withoutDeintegration)
      val newOffets = withoutDeintegration.map { it.bottomZ() }
      offsets.zip(newOffets) { left, right -> left != right }
        .count { it }
    }
  }

  private fun move(bricks: List<Brick>) {
    bricks.forEach { candidate ->
      val highestSupportingBrick = bricks
        .filter { it != candidate && it.xyPointsIntersect(candidate) && it.topZ() < candidate.bottomZ() }
        .maxOfOrNull { it.topZ() }
      val newBottom = (highestSupportingBrick ?: 0) + 1
      candidate.zOffset += candidate.bottomZ() - newBottom
    }
  }

  private data class Brick(val from: Point3, val to: Point3) {

    var zOffset = 0

    companion object {
      fun parse(input: String): Brick {
        val (from, to) = input.split("~").map(Point3::parse)
        return Brick(from = from, to = to)
      }
    }

    fun topZ() = maxOf(from.z, to.z) - zOffset

    fun bottomZ() = minOf(from.z, to.z) - zOffset

    val xyPoints: List<Point> = run {
      if (from.x == to.x) {
        val minY = minOf(from.y, to.y)
        val maxY = maxOf(from.y, to.y)
        (minY..maxY).map { Point(from.x, it) }
      } else if (from.y == to.y) {
        val minX = minOf(from.x, to.x)
        val maxX = maxOf(from.x, to.x)
        (minX..maxX).map { Point(it, from.y) }
      } else {
        error("Not lines")
      }
    }

    private val xyPointsIntersectCache = mutableMapOf<Brick, Boolean>()

    fun xyPointsIntersect(with: Brick): Boolean = xyPointsIntersectCache.getOrPut(with) {
      val otherXyPoints = with.xyPoints
      xyPoints.any { it in otherXyPoints }
    }
  }
}
