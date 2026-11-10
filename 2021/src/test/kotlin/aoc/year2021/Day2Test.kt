package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {
  @Test
  fun part1() {
    assertEquals(2102357, Day2.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(2101031224, Day2.solvePart2())
  }
}
