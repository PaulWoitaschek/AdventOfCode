package year2022

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import utils.aocInput
import utils.aocTestInput

class Day10Test {

  @Test
  fun part1() {
    Day10.solvePart1(aocInput(2022, 10)) shouldBe 16060
  }

  @Test
  fun part1TestInput() {
    Day10.solvePart1(aocTestInput(2022, 10)) shouldBe 13140
  }

  @Test
  fun part2() {
    Day10.solvePart2(aocInput(2022, 10))
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
    Day10.solvePart2(aocTestInput(2022, 10))
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
