package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day4Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      18,
      Day4.solvePart1(
        """
              MMMSXXMASM
              MSAMXMSMSA
              AMXSXMAAMM
              MSAMASMSMX
              XMASAMXAMM
              XXAMMXXAMA
              SMSMSASXSS
              SAXAMASAAA
              MAMMMXMMMM
              MXMXAXMASX
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(2462, Day4.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      9,
      Day4.solvePart2(
        """
              MMMSXXMASM
              MSAMXMSMSA
              AMXSXMAAMM
              MSAMASMSMX
              XMASAMXAMM
              XXAMMXXAMA
              SMSMSASXSS
              SAXAMASAAA
              MAMMMXMMMM
              MXMXAXMASX
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(1877, Day4.solvePart2())
  }
}
