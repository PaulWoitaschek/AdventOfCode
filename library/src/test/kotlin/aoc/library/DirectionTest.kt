package aoc.library

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class DirectionTest {

  @Test
  fun `clockwise rotation should return the next direction`() {
    assertEquals(Direction.Up, Direction.Left.clockwise())
    assertEquals(Direction.Right, Direction.Up.clockwise())
    assertEquals(Direction.Down, Direction.Right.clockwise())
    assertEquals(Direction.Left, Direction.Down.clockwise())
  }

  @Test
  fun `counterClockwise rotation should return the previous direction`() {
    assertEquals(Direction.Down, Direction.Left.counterClockwise())
    assertEquals(Direction.Left, Direction.Up.counterClockwise())
    assertEquals(Direction.Up, Direction.Right.counterClockwise())
    assertEquals(Direction.Right, Direction.Down.counterClockwise())
  }

  @Test
  fun `parse should correctly create Direction from char`() {
    assertEquals(Direction.Left, Direction.parse('L'))
    assertEquals(Direction.Up, Direction.parse('U'))
    assertEquals(Direction.Right, Direction.parse('R'))
    assertEquals(Direction.Down, Direction.parse('D'))
  }

  @Test
  fun `parse should throw an exception for invalid char`() {
    assertFailsWith<IllegalArgumentException> {
      Direction.parse('X')
    }
  }
}
