package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day9Test {

  @Test
  fun part1TestInput() {
    assertEquals(1928, Day9.solvePart1("2333133121414131402"))
  }

  @Test
  fun part1() {
    assertEquals(6154342787400, Day9.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(2858, Day9.solvePart2("2333133121414131402"))
  }

  @Test
  fun part2() {
    assertEquals(6183632723350, Day9.solvePart2())
  }
}
