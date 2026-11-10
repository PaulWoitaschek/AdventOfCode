package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {
  @Test
  fun day1() {
    assertEquals(65912, Day1.solvePart1())
    assertEquals(195625, Day1.solvePart2())
  }
}
