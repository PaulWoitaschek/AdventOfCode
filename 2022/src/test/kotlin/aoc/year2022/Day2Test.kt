package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {
  @Test
  fun day2() {
    assertEquals(12535, Day2.solvePart1())
    assertEquals(15457, Day2.solvePart2())
  }
}
