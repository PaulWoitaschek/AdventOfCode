package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day5Test {
  @Test
  fun part1() {
    assertEquals(5690L, Day5.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(17741L, Day5.solvePart2())
  }
}
