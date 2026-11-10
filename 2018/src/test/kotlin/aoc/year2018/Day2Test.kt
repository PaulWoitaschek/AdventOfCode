package aoc.year2018

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2Test {

  @Test
  fun part1Test() {
    assertEquals(
      12,
      Day2.solvePart1(
        """
        abcdef
        bababc
        abbcde
        abcccd
        aabcdd
        abcdee
        ababab
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(9139, Day2.solvePart1())
  }

  @Test
  fun part2Test() {
    assertEquals(
      "fgij",
      Day2.solvePart2(
        """
        abcde
        fghij
        klmno
        pqrst
        fguij
        axcye
        wvxyz
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals("uqcidadzwtnhsljvxyobmkfyr", Day2.solvePart2())
  }
}
