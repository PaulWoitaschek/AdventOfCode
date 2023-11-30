package aoc.year2022

import aoc.utils.test
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day24Test {

  @Test
  fun part1TestData() {
    Day24.test(part1Test = 18)
  }

  @Test
  @Disabled("Too slow")
  fun part1RealData() {
    Day24.test(part1 = 264)
  }

  @Test
  fun part2TestData() {
    Day24.test(part2Test = 54)
  }

  @Test
  @Disabled("Too slow")
  fun part2RealData() {
    Day24.test(part2 = 789)
  }
}
