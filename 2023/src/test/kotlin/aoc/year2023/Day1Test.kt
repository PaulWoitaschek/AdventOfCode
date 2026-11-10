package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

  @Test
  fun part1Test() {
    assertEquals(
      142,
      Day1.solvePart1(
        """
        1abc2
        pqr3stu8vwx
        a1b2c3d4e5f
        treb7uchet
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(56042, Day1.solvePart1())
  }

  @Test
  fun part2Test() {
    assertEquals(
      281,
      Day1.solvePart2(
        """
        two1nine
        eightwothree
        abcone2threexyz
        xtwone3four
        4nineeightseven2
        zoneight234
        7pqrstsixteen
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(55358, Day1.solvePart2())
  }
}
