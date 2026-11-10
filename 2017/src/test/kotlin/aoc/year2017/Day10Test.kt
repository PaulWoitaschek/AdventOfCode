package aoc.year2017

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day10Test {

  @Test
  fun part1TestInput() {
    assertEquals(12, Day10.solvePart1("3,4,1,5", 5))
  }

  @Test
  fun part1() {
    assertEquals(19591, Day10.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", Day10.solvePart2("1,2,3"))
  }

  @Test
  fun part2() {
    assertEquals("62e2204d2ca4f4924f6e7a80f1288786", Day10.solvePart2())
  }
}
