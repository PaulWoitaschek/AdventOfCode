package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {
  @Test
  fun day1() {
    assertEquals(65912, Day1.solvePart1())
    assertEquals(195625, Day1.solvePart2())
  }
}
