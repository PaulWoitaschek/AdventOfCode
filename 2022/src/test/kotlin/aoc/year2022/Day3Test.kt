package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day3Test {
  @Test
  fun day3() {
    assertEquals(8039, Day3.solvePart1())
    assertEquals(2510, Day3.solvePart2())
  }
}
