package aoc.library

import aoc.library.Point3.Axis
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Point3Test {

  @Test
  fun `plus should correctly add two Point3 objects`() {
    val p1 = Point3(1, 2, 3)
    val p2 = Point3(4, 5, 6)
    val result = p1 + p2
    assertEquals(Point3(5, 7, 9), result)
  }

  @Test
  fun `minus should correctly subtract two Point3 objects`() {
    val p1 = Point3(10, 20, 30)
    val p2 = Point3(1, 2, 3)
    val result = p1 - p2
    assertEquals(Point3(9, 18, 27), result)
  }

  @Test
  fun `get should return the correct coordinate value`() {
    val p = Point3(7, 8, 9)
    assertEquals(7, p[Axis.X])
    assertEquals(8, p[Axis.Y])
    assertEquals(9, p[Axis.Z])
  }

  @Test
  fun `sign should return a Point3 with each axis signum`() {
    val p1 = Point3(-10, 20, -30)
    assertEquals(Point3(-1, 1, -1), p1.sign())

    val p2 = Point3(0, 0, 0)
    assertEquals(Point3(0, 0, 0), p2.sign())
  }

  @Test
  fun `Zero should be a Point3 with all coordinates as zero`() {
    assertEquals(Point3(0, 0, 0), Point3.Zero)
  }
}
