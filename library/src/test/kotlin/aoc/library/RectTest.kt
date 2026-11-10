package aoc.library

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RectTest {

  @Test
  fun `initialization with right less than left should throw exception`() {
    assertThrows<IllegalArgumentException> {
      Rect(left = 5, top = 2, right = 4, bottom = 6)
    }
  }

  @Test
  fun `initialization with top greater than bottom should throw exception`() {
    assertThrows<IllegalArgumentException> {
      Rect(left = 1, top = 7, right = 3, bottom = 4)
    }
  }

  @Test
  fun `contains should return true for point inside the rectangle`() {
    val rect = Rect(left = 1, top = 1, right = 5, bottom = 5)
    val pointInside = Point(3, 3)
    assertTrue(pointInside in rect)
  }

  @Test
  fun `contains should return false for point outside the rectangle`() {
    val rect = Rect(left = 1, top = 1, right = 5, bottom = 5)
    val pointOutside = Point(0, 0)
    assertFalse(pointOutside in rect)
  }

  @Test
  fun `height should return correct value`() {
    val rect = Rect(left = 1, top = 1, right = 5, bottom = 5)
    assertEquals(4, rect.height())
  }

  @Test
  fun `height should be 0 for rectangle with top equal to bottom`() {
    val rect = Rect(left = 1, top = 5, right = 5, bottom = 5)
    assertEquals(0, rect.height())
  }
}
