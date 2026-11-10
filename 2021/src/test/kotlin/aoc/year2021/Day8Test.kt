package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day8Test {
  @Test
  fun part1() {
    assertEquals(392, Day8.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(1004688, Day8.solvePart2())
  }
}
