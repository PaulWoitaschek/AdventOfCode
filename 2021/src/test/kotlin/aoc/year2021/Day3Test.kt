package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {
  @Test
  fun part1() {
    assertEquals(3901196L, Day3.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(4412188L, Day3.solvePart2())
  }
}
