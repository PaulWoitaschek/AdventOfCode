package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day8Test {

  @Test
  fun part1() {
    assertEquals(20221, Day8.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(
      6,
      Day8.solvePart1(
        """
        LLR

        AAA = (BBB, BBB)
        BBB = (AAA, ZZZ)
        ZZZ = (ZZZ, ZZZ)
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(14616363770447, Day8.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      6,
      Day8.solvePart2(
        """
        LR

        11A = (11B, XXX)
        11B = (XXX, 11Z)
        11Z = (11B, XXX)
        22A = (22B, XXX)
        22B = (22C, 22C)
        22C = (22Z, 22Z)
        22Z = (22B, 22B)
        XXX = (XXX, XXX)
        """.trimIndent(),
      ),
    )
  }
}
