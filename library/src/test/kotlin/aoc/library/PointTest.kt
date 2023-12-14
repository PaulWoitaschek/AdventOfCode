package aoc.library

import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PointTest {

  @Test
  fun testPrintString() {
    setOf(
      Point(0, 0),
      Point(1, 0),
      Point(2, 0),
      Point(2, 1),
    ).printString() shouldBe """
        ╔═══╗
        ║███║
        ║  █║
        ╚═══╝
    """.trimIndent()
  }

  @Test
  fun plus() {
    Point(1, 2) + Point(2, 3) shouldBe Point(3, 5)
  }

  @Test
  fun plusWithNegativeValues() {
    Point(4, 8) + Point(-2, -3) shouldBe Point(2, 5)
  }

  @Test
  fun manhattanDistanceZero() {
    Point(2, 4).manhattanDistanceTo(Point(2, 4)) shouldBe 0
  }

  @Test
  fun manhattanDistanceNonZero() {
    Point(2, 4).manhattanDistanceTo(Point(-2, 8)) shouldBe 8
    Point(0, 0).manhattanDistanceTo(Point(0, 1)) shouldBe 1
    Point(0, 0).manhattanDistanceTo(Point(1, 1)) shouldBe 2
  }

  @Test
  fun testPointInsideRectangle() {
    Point(2, 2)
      .isInPath(listOf(Point(0, 0), Point(0, 5), Point(5, 5), Point(5, 0)))
      .shouldBeTrue()
  }

  @Test
  fun testPointOutsideRectangle() {
    Point(6, 6)
      .isInPath(listOf(Point(0, 0), Point(0, 5), Point(5, 5), Point(5, 0)))
      .shouldBeFalse()
  }

  @Test
  fun testPointOnRectangleEdge() {
    Point(3, 0)
      .isInPath(listOf(Point(0, 0), Point(0, 5), Point(5, 5), Point(5, 0)))
      .shouldBeTrue()
  }

  @Test
  fun testPointAtRectangleVertex() {
    Point(0, 0)
      .isInPath(listOf(Point(0, 0), Point(0, 5), Point(5, 5), Point(5, 0)))
      .shouldBeTrue()
  }

  @Test
  fun testPointInsideNonRectangularPolygon() {
    Point(2, 0)
      .isInPath(listOf(Point(0, 0), Point(2, 3), Point(4, 0), Point(2, -3)))
      .shouldBeTrue()
  }

  @Test
  fun testPointOutsideNonRectangularPolygon() {
    Point(5, 5)
      .isInPath(listOf(Point(0, 0), Point(2, 3), Point(4, 0), Point(2, -3)))
      .shouldBeFalse()
  }

  @Test
  fun testPointAtNonRectangularPolygonVertex() {
    Point(0, 0)
      .isInPath(listOf(Point(0, 0), Point(2, 3), Point(4, 0), Point(2, -3)))
      .shouldBeTrue()
  }
}
