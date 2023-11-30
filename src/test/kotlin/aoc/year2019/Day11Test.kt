package aoc.year2019

import aoc.utils.test
import org.junit.jupiter.api.Test

class Day11Test {

  @Test
  fun part1() {
    Day11.test(
      part1 = 2211,
    )
  }

  @Test
  fun part2() {
    Day11.test(
      part2 = """
        ⬛⬛⬛⬛⬜⬛⬛⬛⬛⬜⬜⬛⬛⬜⬜⬛⬜⬜⬛⬜⬛⬜⬜⬛⬜⬛⬛⬛⬛⬜⬜⬛⬛⬜⬜⬜⬛⬛⬜
        ⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜⬛⬜⬛⬜⬛⬜⬜⬛⬜⬜⬛⬜⬛⬜⬜⬜⬜⬛⬜⬜⬛⬜⬛⬜⬜⬛
        ⬛⬛⬛⬜⬜⬛⬛⬛⬜⬜⬛⬜⬜⬜⬜⬛⬛⬜⬜⬜⬛⬜⬜⬛⬜⬛⬛⬛⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜⬜
        ⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬛⬜⬜⬛⬜⬜⬛⬜⬛⬜⬜⬜⬜⬛⬜⬛⬛⬜⬛⬜⬜⬜
        ⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜⬛⬜⬛⬜⬛⬜⬜⬛⬜⬜⬛⬜⬛⬜⬜⬜⬜⬛⬜⬜⬛⬜⬛⬜⬜⬛
        ⬛⬛⬛⬛⬜⬛⬜⬜⬜⬜⬜⬛⬛⬜⬜⬛⬜⬜⬛⬜⬜⬛⬛⬜⬜⬛⬛⬛⬛⬜⬜⬛⬛⬛⬜⬜⬛⬛⬜
      """.trimIndent(),
    )
  }
}
