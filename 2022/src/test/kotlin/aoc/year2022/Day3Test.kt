package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {
  @Test
  fun day3() {
    assertEquals(8039, Day3.solvePart1())
    assertEquals(2510, Day3.solvePart2())
  }
}
