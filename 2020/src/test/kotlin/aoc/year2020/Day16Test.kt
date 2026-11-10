package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day16Test {

  @Test
  fun part1() {
    assertEquals(29851, Day16.solvePart1())
    assertEquals(
      71,
      Day16.solvePart1(
        """
        class: 1-3 or 5-7
        row: 6-11 or 33-44
        seat: 13-40 or 45-50

        your ticket:
        7,1,14

        nearby tickets:
        7,3,47
        40,4,50
        55,2,20
        38,6,12
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(3029180675981, Day16.solvePart2())
  }
}
