package year2021

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.withClue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import utils.input
import utils.test

class Day8Test {
  @Test
  fun day8() {
    Day8.test(part1 = 26, part2 = 61229)
  }

  // Assuming day8Display is related to Day8 and should be in the same test class
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
