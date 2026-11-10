package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day7Test {
  @Test
  fun part() {
    assertEquals(341534L, Day7.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(93397632L, Day7.solvePart2())
  }
}
