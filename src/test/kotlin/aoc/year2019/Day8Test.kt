package aoc.year2019

import aoc.utils.test
import org.junit.jupiter.api.Test

class Day8Test {

  @Test
  fun part1() {
    Day8.test(
      part1 = 2356,
    )
  }

  @Test
  fun part2() {
    Day8.test(
      part2 = """
        ⬜⬜⬜⬛⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬛⬛⬜⬛⬜⬜⬜⬛⬛
        ⬜⬛⬛⬜⬛⬛⬛⬛⬜⬛⬜⬛⬛⬛⬛⬜⬛⬜⬛⬛⬜⬛⬛⬜⬛
        ⬜⬛⬛⬜⬛⬛⬛⬜⬛⬛⬜⬜⬜⬛⬛⬜⬜⬛⬛⬛⬜⬜⬜⬛⬛
        ⬜⬜⬜⬛⬛⬛⬜⬛⬛⬛⬜⬛⬛⬛⬛⬜⬛⬜⬛⬛⬜⬛⬛⬜⬛
        ⬜⬛⬛⬛⬛⬜⬛⬛⬛⬛⬜⬛⬛⬛⬛⬜⬛⬜⬛⬛⬜⬛⬛⬜⬛
        ⬜⬛⬛⬛⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬛⬛⬜⬛⬜⬜⬜⬛⬛
      """.trimIndent(),
    )
  }
}
