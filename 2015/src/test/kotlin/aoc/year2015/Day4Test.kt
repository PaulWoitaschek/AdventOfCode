package aoc.year2015

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day4Test {

  @Test
  fun part1() {
    assertEquals(254575, Day4.solvePart1("bgvyzdsv"))
  }

  @Test
  fun part1Test1() {
    assertEquals(609043, Day4.solvePart1("abcdef"))
  }

  @Test
  fun part1Test2() {
    assertEquals(1048970, Day4.solvePart1("pqrstuv"))
  }

  @Test
  fun part2() {
    assertEquals(1038736, Day4.solvePart2("bgvyzdsv"))
  }
}
