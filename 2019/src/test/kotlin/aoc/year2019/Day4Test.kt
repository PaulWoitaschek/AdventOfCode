package aoc.year2019

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day4Test {

  @Test
  fun part1() {
    assertEquals(454, Day4.solvePart1("402328-864247"))
  }

  @Test
  fun part2() {
    assertEquals(288, Day4.solvePart2("402328-864247"))
  }

  @Test
  fun validPasswordPart1() {
    mapOf(
        111111 to true,
        223450 to false,
        123789 to false,
      )
      .forEach { (password, validPassword) ->
        assertEquals(validPassword, Day4.isValidPasswordPart1(password))
      }
  }

  @Test
  fun validPasswordPart2() {
    mapOf(
        112233 to true,
        123444 to false,
        111122 to true,
      )
      .forEach { (password, validPassword) ->
        assertEquals(validPassword, Day4.isValidPasswordPart2(password))
      }
  }
}
