package aoc.year2022

import aoc.utils.test
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day23Test {

  @Test
  fun part1() {
    Day23.test(part1 = 4025)
  }

  @Test
  fun part1TestInput() {
    Day23.test(part1Test = 110)
  }

  @Test
  @Disabled("Too slow")
  fun part2() {
    Day23.test(part2 = 935)
  }

  @Test
  fun part2TestInput() {
    Day23.test(part2Test = 20)
  }
}
