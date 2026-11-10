package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day6Test {

  @Test
  fun part1() {
    assertEquals(387413, Day6.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(1738377086345, Day6.solvePart2())
  }
}
