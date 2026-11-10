package aoc.year2017

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day11Test {

  @Test
  fun part1TestInput() {
    assertEquals(3, Day11.solvePart1("ne,ne,ne"))
    assertEquals(0, Day11.solvePart1("ne,ne,sw,sw"))
    assertEquals(2, Day11.solvePart1("ne,ne,s,s"))
    assertEquals(3, Day11.solvePart1("se,sw,se,sw,sw"))
  }

  @Test
  fun part1() {
    assertEquals(720, Day11.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(1485, Day11.solvePart2())
  }
}
