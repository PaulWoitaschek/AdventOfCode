package aoc.library

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ShoelaceTest {

  @Test
  fun `test square perimeter`() {
    assertEquals(
      100,
      shoelace(
        listOf(
          Point(0, 0),
          Point(0, 10),
          Point(10, 10),
          Point(10, 0),
        ),
      ),
    )
  }

  @Test
  fun `test triangle area`() {
    assertEquals(
      45,
      shoelace(
        listOf(
          Point(0, 0),
          Point(4, 10),
          Point(9, 0),
        ),
      ),
    )
  }

  @Test
  fun `test pentagon area`() {
    assertEquals(
      20,
      shoelace(
        listOf(
          Point(0, 0),
          Point(2, 4),
          Point(4, 2),
          Point(4, -2),
          Point(2, -4),
        ),
      ),
    )
  }

  @Test
  fun `test complex shape area`() {
    assertEquals(
      30,
      shoelace(
        listOf(
          Point(3, 4),
          Point(5, 11),
          Point(12, 8),
          Point(9, 5),
          Point(5, 6),
        ),
      ),
    )
  }

  @Test
  fun `test closed square perimeter`() {
    assertEquals(
      100,
      shoelace(
        listOf(
          Point(0, 0),
          Point(0, 10),
          Point(10, 10),
          Point(10, 0),
          Point(0, 0),
        ),
      ),
    )
  }
}
