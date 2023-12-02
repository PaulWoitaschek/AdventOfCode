package aoc.year2022

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import aoc.utils.solvePart2
import aoc.utils.solvePart2WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day7Test {

  @Test
  fun test() {
    Day7.solvePart1(
    ) shouldBe 1477771
    Day7.solvePart2() shouldBe 3579501
    Day7.solvePart1WithTestInput() shouldBe 95437
    Day7.solvePart2WithTestInput() shouldBe 24933642
  }
}
