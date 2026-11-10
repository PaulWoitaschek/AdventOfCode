package aoc.library

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RangeIntersectTest {

  @Test
  fun nonOverlappingRangesShouldNotIntersect() {
    assertEquals(false, (0..5).intersects(6..10))
    assertEquals(false, (10..15).intersects(0..9))
  }

  @Test
  fun overlappingRangesShouldIntersect() {
    assertEquals(true, (0..5).intersects(5..10))
    assertEquals(true, (3..8).intersects(6..10))
  }

  @Test
  fun nestedRangesShouldIntersect() {
    assertEquals(true, (0..10).intersects(2..8))
    assertEquals(true, (2..8).intersects(0..10))
  }

  @Test
  fun sameRangesShouldIntersect() {
    assertEquals(true, (0..5).intersects(0..5))
  }

  @Test
  fun adjacentRangesShouldNotIntersect() {
    assertEquals(false, (0..5).intersects(6..6))
  }
}
