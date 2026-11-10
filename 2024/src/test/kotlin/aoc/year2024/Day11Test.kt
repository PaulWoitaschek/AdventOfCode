package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day11Test {

  @Test
  fun part1TestInput() {
    assertEquals(55312, Day11.solvePart1("125 17"))
  }

  @Test
  fun part1() {
    assertEquals(194557, Day11.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(231532558973909, Day11.solvePart2())
  }
}
