package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day7Test {

  @Test
  fun part1TestInput() {
    Day7.solvePart1WithTestInput() shouldBe 95437
  }

  @Test
  fun part2TestInput() {
    Day7.solvePart2WithTestInput() shouldBe 24933642
  }

  @Test
  fun part1() {
    Day7.solvePart1() shouldBe 1477771
  }

  @Test
  fun part2() {
    Day7.solvePart2() shouldBe 3579501
  }
}
