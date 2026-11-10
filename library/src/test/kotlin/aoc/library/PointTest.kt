package aoc.library

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class PointTest {

  @Test
  fun testPrintString() {
    assertEquals(
      """
      ╔═══╗
      ║███║
      ║  █║
      ╚═══╝
      """
        .trimIndent(),
      setOf(
          Point(0, 0),
          Point(1, 0),
          Point(2, 0),
          Point(2, 1),
        )
        .printString(),
    )
  }

  @Test
  fun plus() {
    assertEquals(Point(3, 5), Point(1, 2) + Point(2, 3))
  }

  @Test
  fun plusWithNegativeValues() {
    assertEquals(Point(2, 5), Point(4, 8) + Point(-2, -3))
  }

  @Test
  fun manhattanDistanceZero() {
    assertEquals(0, Point(2, 4).manhattanDistanceTo(Point(2, 4)))
  }

  @Test
  fun manhattanDistanceNonZero() {
    assertEquals(8, Point(2, 4).manhattanDistanceTo(Point(-2, 8)))
    assertEquals(1, Point(0, 0).manhattanDistanceTo(Point(0, 1)))
    assertEquals(2, Point(0, 0).manhattanDistanceTo(Point(1, 1)))
  }
}
