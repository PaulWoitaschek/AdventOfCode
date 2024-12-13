package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Test

class Day13Test {
  @Test
  fun part1TestInput() {
    Day13.solvePart1(
      """
      Button A: X+94, Y+34
      Button B: X+22, Y+67
      Prize: X=8400, Y=5400

      Button A: X+26, Y+66
      Button B: X+67, Y+21
      Prize: X=12748, Y=12176

      Button A: X+17, Y+86
      Button B: X+84, Y+37
      Prize: X=7870, Y=6450

      Button A: X+69, Y+23
      Button B: X+27, Y+71
      Prize: X=18641, Y=10279
      """.trimIndent(),
    ) shouldBeExactly 480
  }

  @Test
  fun part1() {
    Day13.solvePart1() shouldBeExactly 40069
  }

  @Test
  fun part2() {
    Day13.solvePart2() shouldBeExactly 71493195288102
  }
}
