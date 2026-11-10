package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day4Test {
  @Test
  fun day4() {
    assertEquals(657, Day4.solvePart1())
    assertEquals(938, Day4.solvePart2())
  }
}
