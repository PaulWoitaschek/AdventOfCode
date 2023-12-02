package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart1WithTestInput
import aoc.library.solvePart2
import aoc.library.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day10Test {

  @Test
  fun part1() {
    Day10.solvePart1() shouldBe 16060
  }

  @Test
  fun part1TestInput() {
    Day10.solvePart1WithTestInput() shouldBe 13140
  }

  @Test
  fun part2() {
    Day10.solvePart2()
      .lines().joinToString(separator = "\n") { it.trim() }
      .shouldBe(
        """
      ███   ██   ██  ████ █  █ █    █  █ ████
      █  █ █  █ █  █ █    █ █  █    █  █ █
      ███  █  █ █    ███  ██   █    ████ ███
      █  █ ████ █    █    █ █  █    █  █ █
      █  █ █  █ █  █ █    █ █  █    █  █ █
      ███  █  █  ██  ████ █  █ ████ █  █ █
        """.trimIndent(),
      )
  }

  @Test
  fun part2TestInput() {
    Day10.solvePart2WithTestInput()
      .lines().joinToString(separator = "\n") { it.trim() }
      .shouldBe(
        """
      ██  ██  ██  ██  ██  ██  ██  ██  ██  ██
      ███   ███   ███   ███   ███   ███   ███
      ████    ████    ████    ████    ████
      █████     █████     █████     █████
      ██████      ██████      ██████      ████
      ███████       ███████       ███████
        """.trimIndent(),
      )
  }
}
