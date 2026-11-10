package aoc.year2019

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day13Test {

  @Test
  fun part1() {
    assertEquals(361, Day13.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(17590, Day13.solvePart2())
  }
}
