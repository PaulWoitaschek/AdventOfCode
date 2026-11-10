package aoc.year2016

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

  @Test
  fun part1TestInput() {
    assertEquals(0, Day3.solvePart1("5 10 25"))
    assertEquals(1, Day3.solvePart1("3 3 3"))
  }

  @Test
  fun part1() {
    assertEquals(1050, Day3.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      6,
      Day3.solvePart2(
        """
        101 301 501
        102 302 502
        103 303 503
        201 401 601
        202 402 602
        203 403 603
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(1921, Day3.solvePart2())
  }
}
