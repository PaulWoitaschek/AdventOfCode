package year2022

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.withClue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import utils.test

class Day6Test {

  @Test
  fun day6Part1TestData() {
    mapOf(
      "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 7,
      "bvwbjplbgvbhsrlpgdmjqwftvncz" to 5,
      "nppdvjthqldpwncqszvftbrmjlhg" to 6,
      "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 10,
      "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 11,
    ).forEach { (input, expected) ->
      withClue("input=$input") {
        assertSoftly {
          Day6.solvePart1(input) shouldBe expected
        }
      }
    }
  }

  @Test
  fun day6() {
    Day6.test(part1 = 1892, part2 = 2313)
  }
}
