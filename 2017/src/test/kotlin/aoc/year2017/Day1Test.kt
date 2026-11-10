package aoc.year2017

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {

  @Test
  fun part1() {
    assertEquals(1049, Day1.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(3, Day1.solvePart1("1122"))
    assertEquals(4, Day1.solvePart1("1111"))
  }

  @Test
  fun part2() {
    assertEquals(1508, Day1.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(4, Day1.solvePart2("123425"))
    assertEquals(12, Day1.solvePart2("123123"))
  }
}
