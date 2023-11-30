package aoc.year2020

import aoc.utils.test
import org.junit.jupiter.api.Test

class Day9Test {

  @Test
  fun test() {
    Day9(5).test(part1Test = 127, part2Test = 62)
    Day9(25).test(part1 = 257342611, part2 = 35602097)
  }
}
