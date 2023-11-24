package de.woitaschek.aoc.year2021

import de.woitaschek.aoc.test
import org.junit.jupiter.api.Test

class Day13Test {

  @Test
  fun part1() {
    Day13.test(part1 = 17)
  }

  @Test
  fun part2() {
    Day13.test(
      part2 = """
      ⬛⬛⬛⬛⬛
      ⬛⬜⬜⬜⬛
      ⬛⬜⬜⬜⬛
      ⬛⬜⬜⬜⬛
      ⬛⬛⬛⬛⬛
      """.trimIndent(),
    )
  }
}
