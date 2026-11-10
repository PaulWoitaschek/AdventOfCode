package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day20Test {

  @Test
  fun testPart1Test() {
    assertEquals(
      3L,
      Day20.solvePart1(
        """
        1
        2
        -3
        3
        -2
        0
        4
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun testPart1() {
    assertEquals(19559L, Day20.solvePart1())
  }

  @Test
  fun testPart2Test() {
    assertEquals(
      1623178306L,
      Day20.solvePart2(
        """
        1
        2
        -3
        3
        -2
        0
        4
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun testPart2() {
    assertEquals(912226207972L, Day20.solvePart2())
  }
}
