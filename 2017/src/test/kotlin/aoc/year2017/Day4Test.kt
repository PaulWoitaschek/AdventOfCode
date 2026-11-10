package aoc.year2017

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day4Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      2,
      Day4.solvePart1(
        """
        aa bb cc dd ee
        aa bb cc dd aa
        aa bb cc dd aaa
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(477, Day4.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      3,
      Day4.solvePart2(
        """
        abcde fghij.
        abcde xyz ecdab
        a ab abc abd abf abj
        iiii oiii ooii oooi oooo
        oiii ioii iioi iiio
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(167, Day4.solvePart2())
  }
}
