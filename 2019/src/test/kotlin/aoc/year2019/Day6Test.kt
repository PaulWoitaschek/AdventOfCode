package aoc.year2019

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day6Test {

  @Test
  fun part1Test() {
    assertEquals(
      42,
      Day6.solvePart1(
        """
        COM)B
        B)C
        C)D
        D)E
        E)F
        B)G
        G)H
        D)I
        E)J
        J)K
        K)L
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(295834, Day6.solvePart1())
  }

  @Test
  fun part2Test() {
    assertEquals(
      4,
      Day6.solvePart2(
        """
        COM)B
        B)C
        C)D
        D)E
        E)F
        B)G
        G)H
        D)I
        E)J
        J)K
        K)L
        K)YOU
        I)SAN
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(361, Day6.solvePart2())
  }
}
