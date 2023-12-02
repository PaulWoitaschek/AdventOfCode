package aoc.year2022

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day22Test {

  @Test
  fun test() {
    Day22.solvePart1() shouldBe 89224
    Day22.solvePart1WithTestInput() shouldBe 6032
  }
}
