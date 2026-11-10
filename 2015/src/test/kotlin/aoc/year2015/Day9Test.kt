package aoc.year2015

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day9Test {

  @Test
  fun part1() {
    assertEquals(251, Day9.solvePart1())
  }

  @Test
  fun part1Test() {
    assertEquals(
      605,
      Day9.solvePart1(
        """
        London to Dublin = 464
        London to Belfast = 518
        Dublin to Belfast = 141
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2Test() {
    assertEquals(
      982,
      Day9.solvePart2(
        """
        London to Dublin = 464
        London to Belfast = 518
        Dublin to Belfast = 141
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(898, Day9.solvePart2())
  }
}
