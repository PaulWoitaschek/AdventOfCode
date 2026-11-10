package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      161,
      Day3.solvePart1("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"),
    )
  }

  @Test
  fun part1() {
    assertEquals(175015740, Day3.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      48,
      Day3.solvePart2("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"),
    )
  }

  @Test
  fun part2() {
    assertEquals(112272912, Day3.solvePart2())
  }
}
