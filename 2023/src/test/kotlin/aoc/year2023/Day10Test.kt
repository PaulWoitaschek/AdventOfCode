package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day10Test {

  @Test
  fun part1() {
    Day10.solvePart1() shouldBeExactly 6815
  }

  @Test
  fun part1TestInput1() {
    Day10.solvePart1(
      """
      ..F7.
      .FJ|.
      SJ.L7
      |F--J
      LJ...
      """.trimIndent(),
    ) shouldBeExactly 8
  }

  @Test
  fun part1TestInput2() {
    Day10.solvePart1(
      """
      .....
      .S-7.
      .|.|.
      .L-J.
      .....
      """.trimIndent(),
    ) shouldBeExactly 4
  }

  @Test
  fun part1TestInput3() {
    Day10.solvePart1(
      """
      F-7..
      L-J..
      .S-7.
      .|.|.
      .L-J.
      .....
      """.trimIndent(),
    ) shouldBeExactly 4
  }

  @Test
  @Disabled("")
  fun part2() {
    Day10.solvePart2() shouldBeExactly 42
  }

  @Test
  @Disabled("")
  fun part2TestInput() {
    Day10.solvePart2() shouldBeExactly 42
  }
}
