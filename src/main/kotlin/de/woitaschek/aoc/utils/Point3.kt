package de.woitaschek.aoc.utils

import kotlin.math.sign

data class Point3(
  val x: Int,
  val y: Int,
  val z: Int,
) {

  operator fun plus(other: Point3): Point3 {
    return Point3(
      x = x + other.x,
      y = y + other.y,
      z = z + other.z,
    )
  }

  operator fun minus(other: Point3): Point3 {
    return Point3(
      x = x - other.x,
      y = y - other.y,
      z = z - other.z,
    )
  }

  operator fun get(axis: Axis): Int = when (axis) {
    Axis.X -> x
    Axis.Y -> y
    Axis.Z -> z
  }

  fun sign(): Point3 = Point3(x.sign, y.sign, z.sign)

  companion object {
    val Zero = Point3(0, 0, 0)
  }

  enum class Axis { X, Y, Z }
}
