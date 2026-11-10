package aoc.year2019

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {

  @Test
  fun part1() {
    assertEquals(9581917, Day2.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(2505, Day2.solvePart2())
  }
}
