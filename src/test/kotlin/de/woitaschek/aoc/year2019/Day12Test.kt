package de.woitaschek.aoc.year2019

import de.woitaschek.aoc.test
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day12Test {

  @Test
  fun part1() {
    Day12.test(
      part1 = 7722,
    )
  }

  @Test
  fun part2() {
    Day12.test(
      part2 = 292653556339368,
    )
  }

  @Test
  fun part2Test() {
    Day12.solvePart2(
      """
      <x=-1, y=0, z=2>
      <x=2, y=-10, z=-7>
      <x=4, y=-8, z=8>
      <x=3, y=5, z=-1>
      """.trimIndent(),
    ) shouldBe 2772
  }
}
