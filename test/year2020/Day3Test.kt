package year2020

import org.junit.jupiter.api.Test
import utils.test

class Day3Test {

  @Test
  fun part1() {
    Day3.test(
      part1Test = 7,
      part1 = 193,
    )
  }

  @Test
  fun part2() {
    Day3.test(
      part2Test = 336,
      part2 = 1355323200,
    )
  }
}
