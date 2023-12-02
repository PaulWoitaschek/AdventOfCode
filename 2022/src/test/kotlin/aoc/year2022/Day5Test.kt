package aoc.year2022

import aoc.utils.solvePart1
import aoc.utils.solvePart2
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day5Test {
  @Test
  fun day5() {
    Day5.solvePart1() shouldBe "SPFMVDTZT"
    Day5.solvePart2() shouldBe "ZFSJBPRFP"
  }
}
