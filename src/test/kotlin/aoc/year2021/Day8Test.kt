package aoc.year2021

import aoc.utils.input
import aoc.utils.test
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.withClue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day8Test {
  @Test
  fun day8() {
    Day8.test(part1 = 26, part2 = 61229)
  }

  @Test
  fun day8Display() {
    val expected = listOf(
      8394,
      9781,
      1197,
      9361,
      4873,
      8418,
      4548,
      1625,
      8717,
      4315,
    )
    assertSoftly {
      Day8.input().lines().forEachIndexed { index, line ->
        withClue(line) {
          val outputValue = Display.parse(line).outputValue()
          outputValue shouldBe expected[index]
        }
      }
    }
  }
}
