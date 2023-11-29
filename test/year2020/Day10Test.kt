package year2020

import org.junit.jupiter.api.Test
import utils.test

class Day10Test {

  @Test
  fun part1() {
    Day10.test(
      part1Test = 22 * 10,
      part1 = 1998,
    )
  }

  @Test
  fun part2() {
    Day10.test(
      part2Test = 19208,
      part2 = 347250213298688,
    )
  }
}
