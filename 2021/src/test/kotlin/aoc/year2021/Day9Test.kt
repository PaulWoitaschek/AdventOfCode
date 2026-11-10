package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day9Test {
  @Test
  fun part1() {
    assertEquals(570L, Day9.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(899392L, Day9.solvePart2())
  }
}
