package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      514579,
      Day1.solvePart1(
        """
1721
979
366
299
675
1456
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      241861950,
      Day1.solvePart2(
        """
1721
979
366
299
675
1456
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(73371, Day1.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(127642310, Day1.solvePart2())
  }
}
