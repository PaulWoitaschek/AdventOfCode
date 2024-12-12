package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.ints.shouldBeExactly
import org.junit.jupiter.api.Test

class Day12Test {

  @Test
  fun part1TestInput() {
    Day12.solvePart1(
      """
    AAAA
    BBCD
    BBCC
    EEEC
      """.trimIndent(),
    ) shouldBeExactly 140
  }

  @Test
  fun part1TestInput2() {
    Day12.solvePart1(
      """
    RRRRIICCFF
    RRRRIICCCF
    VVRRRCCFFF
    VVRCCCJFFF
    VVVVCJJCFE
    VVIVCCJJEE
    VVIIICJJEE
    MIIIIIJJEE
    MIIISIJEEE
    MMMISSJEEE
      """.trimIndent(),
    ) shouldBeExactly 1930
  }

  @Test
  fun part1() {
    Day12.solvePart1() shouldBeExactly 1434856
  }

  @Test
  fun part2TestInput() {
    Day12.solvePart2(
      """
      AAAA
      BBCD
      BBCC
      EEEC
      """.trimIndent(),
    ) shouldBeExactly 80
  }

  @Test
  fun part2TestInput2() {
    Day12.solvePart2(
      """
      RRRRIICCFF
      RRRRIICCCF
      VVRRRCCFFF
      VVRCCCJFFF
      VVVVCJJCFE
      VVIVCCJJEE
      VVIIICJJEE
      MIIIIIJJEE
      MIIISIJEEE
      MMMISSJEEE
      """.trimIndent(),
    ) shouldBeExactly 1206
  }

  @Test
  fun part2() {
    Day12.solvePart2() shouldBeExactly 891106
  }
}
