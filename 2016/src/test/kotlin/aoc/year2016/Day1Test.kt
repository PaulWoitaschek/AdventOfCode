package aoc.year2016

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

  @Test
  fun part1() {
    assertEquals(253, Day1.solvePart1())
  }

  @Test
  fun part1TestInput1() {
    assertEquals(5, Day1.solvePart1("R2, L3"))
  }

  @Test
  fun part1TestInput2() {
    assertEquals(12, Day1.solvePart1("R5, L5, R5, R3"))
  }

  @Test
  fun part2() {
    assertEquals(126, Day1.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(4, Day1.solvePart2("R8, R4, R4, R8"))
  }
}
