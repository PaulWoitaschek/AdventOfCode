package aoc.year2019

import aoc.utils.test
import io.kotest.matchers.ints.shouldBeExactly
import org.junit.jupiter.api.Test

class Day6Test {

  @Test
  fun part1Test() {
    Day6.solvePart1(
      """
      COM)B
      B)C
      C)D
      D)E
      E)F
      B)G
      G)H
      D)I
      E)J
      J)K
      K)L
      """.trimIndent(),
    ) shouldBeExactly 42
  }

  @Test
  fun part1() {
    Day6.test(
      part1 = 295834,
    )
  }

  @Test
  fun part2Test() {
    Day6.solvePart2(
      """
      COM)B
      B)C
      C)D
      D)E
      E)F
      B)G
      G)H
      D)I
      E)J
      J)K
      K)L
      K)YOU
      I)SAN
      """.trimIndent(),
    ) shouldBeExactly 4
  }

  @Test
  fun part2() {
    Day6.test(part2 = 361)
  }
}
