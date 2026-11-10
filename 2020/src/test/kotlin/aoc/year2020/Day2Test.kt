package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      2,
      Day2.solvePart1(
        """
1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      1,
      Day2.solvePart2(
        """
1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(424, Day2.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(747, Day2.solvePart2())
  }
}
