package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day4Test {
  @Test
  fun part1() {
    assertEquals(33348, Day4.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(8112, Day4.solvePart2())
  }
}
