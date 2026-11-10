package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day17Test {
  @Test
  fun part1() {
    assertEquals(3916, Day17.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(2986, Day17.solvePart2())
  }
}
