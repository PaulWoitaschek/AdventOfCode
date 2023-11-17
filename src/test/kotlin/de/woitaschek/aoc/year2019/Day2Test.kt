package de.woitaschek.aoc.year2019

import de.woitaschek.aoc.test
import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day2Test {

  @Test
  fun test() {
    Day2.test(
      part1 = 9581917,
      part2 = 2505,
    )
  }

  @Test
  fun processInstructions() {
    assertSoftly {
      mapOf(
        listOf(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50) to listOf(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50),
        listOf(1, 0, 0, 0, 99) to listOf(2, 0, 0, 0, 99),
        listOf(2, 3, 0, 3, 99) to listOf(2, 3, 0, 6, 99),
        listOf(2, 4, 4, 5, 99, 0) to listOf(2, 4, 4, 5, 99, 9801),
        listOf(1, 1, 1, 4, 99, 5, 6, 0, 99) to listOf(30, 1, 1, 4, 2, 5, 6, 0, 99),
      ).forEach { (input, output) ->
        Day2.processInstructions(input) shouldBe output
      }
    }
  }
}
