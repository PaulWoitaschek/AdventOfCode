package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.test
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
  fun part2RegularInput() {
    Day19.test(part2 = 10672)
  }

  @Test
  fun part2TestInput() {
    Day19.test(part2Test = 62 * 56)
  }
}
