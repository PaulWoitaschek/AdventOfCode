package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day9Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      127,
      Day9(5).solvePart1(
        """
35
20
15
25
47
40
62
55
65
95
102
117
150
182
127
219
299
277
309
576
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      62,
      Day9(5).solvePart2(
        """
35
20
15
25
47
40
62
55
65
95
102
117
150
182
127
219
299
277
309
576
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(257342611, Day9(25).solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(35602097, Day9(25).solvePart2())
  }
}
