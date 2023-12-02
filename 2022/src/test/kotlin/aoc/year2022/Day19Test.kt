package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day19Test {

  @Test
  fun part1TestInput() {
    Day19.solvePart1WithTestInput() shouldBe 33
  }

  @Test
  fun part1RegularInput() {
    Day19.solvePart1() shouldBe 1565
  }

  @Test
  @Disabled("Too slow")
  fun part2RegularInput() {
    Day19.solvePart2() shouldBe 10672
  }

  @Test
  @Disabled("Too slow")
  fun part2TestInput() {
    val part2Test = 62 * 56
    Day19.solvePart2WithTestInput() shouldBe part2Test
  }
}
