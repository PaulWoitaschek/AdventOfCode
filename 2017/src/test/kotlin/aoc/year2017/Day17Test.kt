package aoc.year2017

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day17Test {

  @Test
  fun part1TestInput() {
    assertEquals(638, Day17.solvePart1("3"))
  }

  @Test
  fun part1() {
    assertEquals(417, Day17.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(34334221, Day17.solvePart2())
  }
}
