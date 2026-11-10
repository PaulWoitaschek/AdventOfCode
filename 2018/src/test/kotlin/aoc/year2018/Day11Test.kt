package aoc.year2018

import aoc.library.Point
import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day11Test {

  @Test
  fun powerLevel() {
    assertEquals(-5, Day11.powerLevel(Point(122, 79), 57))
    assertEquals(0, Day11.powerLevel(Point(217, 196), 39))
    assertEquals(4, Day11.powerLevel(Point(101, 153), 71))
  }

  @Test
  fun part1TestInput() {
    assertEquals("33,45", Day11.solvePart1("18"))
    assertEquals("21,61", Day11.solvePart1("42"))
  }

  @Test
  fun part1() {
    assertEquals("34,13", Day11.solvePart1())
  }

  @Test
  @Disabled
  fun part2TestInput() {
    assertEquals(42, Day11.solvePart2())
  }

  @Test
  @Disabled
  fun part2() {
    assertEquals(42, Day11.solvePart2())
  }
}
