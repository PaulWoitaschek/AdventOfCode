package year2019

import org.junit.jupiter.api.Test
import utils.test

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
