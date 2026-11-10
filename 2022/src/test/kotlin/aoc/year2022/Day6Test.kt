package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day6Test {

  @Test
  fun day6Part1TestData() {
    mapOf(
        "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 7,
        "bvwbjplbgvbhsrlpgdmjqwftvncz" to 5,
        "nppdvjthqldpwncqszvftbrmjlhg" to 6,
        "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 10,
        "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 11,
      )
      .forEach { (input, expected) ->
        assertEquals(expected, Day6.solvePart1(input))
      }
  }

  @Test
  fun day6() {
    assertEquals(1892, Day6.solvePart1())
    assertEquals(2313, Day6.solvePart2())
  }
}
