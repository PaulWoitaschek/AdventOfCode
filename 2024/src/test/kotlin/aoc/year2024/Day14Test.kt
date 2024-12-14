package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.ints.shouldBeExactly
import org.junit.jupiter.api.Test

class Day14Test {

  @Test
  fun part1TestInput() {
    Day14.solvePart1(
      """
      p=0,4 v=3,-3
      p=6,3 v=-1,-3
      p=10,3 v=-1,2
      p=2,0 v=2,-1
      p=0,0 v=1,3
      p=3,0 v=-2,-2
      p=7,6 v=-1,-3
      p=3,0 v=-1,-2
      p=9,3 v=2,3
      p=7,3 v=-1,2
      p=2,4 v=2,-3
      p=9,5 v=-3,-3
      """.trimIndent(),
      11,
      7,
    ) shouldBeExactly 12
  }

  @Test
  fun part1() {
    Day14.solvePart1() shouldBeExactly 230172768
  }

  @Test
  fun part2() {
    Day14.solvePart2() shouldBeExactly 8087
  }
}
