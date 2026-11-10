package aoc.year2015

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day8Test {

  @Test
  fun part1() {
    assertEquals(1350, Day8.solvePart1())
  }

  @Test
  fun part1Test() {
    assertEquals(
      12,
      Day8.solvePart1(
        """
        ""
        "abc"
        "aaa\"aaa"
        "\x27"
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun memoryCount1() {
    assertEquals(
      0,
      Day8.memoryCount(
        """
        ""
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun memoryCount2() {
    assertEquals(
      3,
      Day8.memoryCount(
        """
        "abc"
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun memoryCount3() {
    assertEquals(
      7,
      Day8.memoryCount(
        """
        "aaa\"aaa"
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun memoryCount4() {
    assertEquals(
      1,
      Day8.memoryCount(
        """
        "\x27"
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun encodedSize1() {
    assertEquals(
      6,
      Day8.encodedSize(
        """
        ""
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun encodedSize2() {
    assertEquals(
      9,
      Day8.encodedSize(
        """
        "abc"
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun encodedSize3() {
    assertEquals(
      16,
      Day8.encodedSize(
        """
        "aaa\"aaa"
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun encodedSize4() {
    assertEquals(
      11,
      Day8.encodedSize(
        """
        "\x27"
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2Test() {
    assertEquals(
      19,
      Day8.solvePart2(
        """
        ""
        "abc"
        "aaa\"aaa"
        "\x27"
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(2085, Day8.solvePart2())
  }
}
