package aoc.year2022

import aoc.utils.test
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day19Test {

  @Test
  fun part1TestInput() {
    Day19.test(part1Test = 33)
  }

  @Test
  fun part1RegularInput() {
    Day19.test(part1 = 1565)
  }

  @Test
  @Disabled("Too slow")
  fun part2RegularInput() {
    Day19.test(part2 = 10672)
  }

  @Test
  @Disabled("Too slow")
  fun part2TestInput() {
    Day19.test(part2Test = 62 * 56)
  }
}
