package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day18Test {
  @Test
  fun part1() {
    assertEquals(3216, Day18.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(4643, Day18.solvePart2())
  }
}
