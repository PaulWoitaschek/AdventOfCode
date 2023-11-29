package year2015

import io.kotest.matchers.ints.shouldBeExactly
import org.junit.jupiter.api.Test
import utils.test

class Day9Test {

  @Test
  fun part1() {
    Day9.test(
      part1 = 251,
    )
  }

  @Test
  fun part1Test() {
    Day9.solvePart1(
      """
      London to Dublin = 464
      London to Belfast = 518
      Dublin to Belfast = 141
      """.trimIndent(),
    ) shouldBeExactly 605
  }

  @Test
  fun part2Test() {
    Day9.solvePart2(
      """
      London to Dublin = 464
      London to Belfast = 518
      Dublin to Belfast = 141
      """.trimIndent(),
    ) shouldBeExactly 982
  }

  @Test
  fun part2() {
    Day9.test(
      part2 = 898,
    )
  }
}
