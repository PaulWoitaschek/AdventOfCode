package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.ints.shouldBeAtLeast
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day1Test {

  private val testInput = """
      L68
      L30
      R48
      L5
      R60
      L55
      L1
      L99
      R14
      L82
  """.trimIndent()

  @Test
  fun part1TestInput() {
    Day1.solvePart1(testInput) shouldBeExactly 3
  }

  @Test
  fun part1() {
    Day1.solvePart1() shouldBeExactly 1074
  }

  @Test
  fun part2TestInput() {
    Day1.solvePart2(testInput) shouldBeExactly 6
  }

  @Test
  fun part2TestInput2() {
    Day1.solvePart2("R1000") shouldBeExactly 10
  }

  @Test
  fun part2TestInput3() {
    Day1.solvePart2("R49") shouldBeExactly 0
  }

  @Test
  fun part2TestInput4() {
    Day1.solvePart2("R50") shouldBeExactly 1
  }

  @Test
  fun part2TestInput5() {
    Day1.solvePart2("L49") shouldBeExactly 0
  }

  @Test
  fun part2TestInput6() {
    Day1.solvePart2("L50") shouldBeExactly 1
  }

  @Test
  fun part2() {
    Day1.solvePart2() shouldBeExactly 6254
  }
}
