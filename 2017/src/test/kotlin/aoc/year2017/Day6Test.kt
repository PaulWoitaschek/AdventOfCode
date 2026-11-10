package aoc.year2017

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day6Test {

  @Test
  fun part1TestInput() {
    assertEquals(5, Day6.solvePart1("0\t2\t7\t0"))
  }

  @Test
  fun part1() {
    assertEquals(3156, Day6.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(4, Day6.solvePart2("0\t2\t7\t0"))
  }

  @Test
  fun part2() {
    assertEquals(1610, Day6.solvePart2())
  }
}
