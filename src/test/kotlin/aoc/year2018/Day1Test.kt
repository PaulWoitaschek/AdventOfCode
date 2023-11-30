package aoc.year2018

import aoc.utils.test
import io.kotest.matchers.ints.shouldBeExactly
import org.junit.jupiter.api.Test

class Day1Test {

  @Test
  fun part1() {
    Day1.test(part1 = 569)
  }

  @Test
  fun part2() {
    Day1.test(part2 = 77666)
  }

  @Test
  fun part2Test() {
    Day1.solvePart2(
      """
      +7
      +7
      -2
      -7
      -4
      """.trimIndent(),
    ) shouldBeExactly 14
  }
}
