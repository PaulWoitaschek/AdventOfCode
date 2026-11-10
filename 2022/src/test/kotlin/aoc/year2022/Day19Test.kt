package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day19Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      33,
      Day19.solvePart1(
        """
        Blueprint 1: Each ore robot costs 4 ore. Each clay robot costs 2 ore. Each obsidian robot costs 3 ore and 14 clay. Each geode robot costs 2 ore and 7 obsidian.
        Blueprint 2: Each ore robot costs 2 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 8 clay. Each geode robot costs 3 ore and 12 obsidian.
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part1RegularInput() {
    assertEquals(1565, Day19.solvePart1())
  }

  @Test
  @Disabled("Too slow")
  fun part2RegularInput() {
    assertEquals(10672, Day19.solvePart2())
  }

  @Test
  @Disabled("Too slow")
  fun part2TestInput() {
    val part2Test = 62 * 56
    assertEquals(
      part2Test,
      Day19.solvePart2(
        """
        Blueprint 1: Each ore robot costs 4 ore. Each clay robot costs 2 ore. Each obsidian robot costs 3 ore and 14 clay. Each geode robot costs 2 ore and 7 obsidian.
        Blueprint 2: Each ore robot costs 2 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 8 clay. Each geode robot costs 3 ore and 12 obsidian.
        """
          .trimIndent(),
      ),
    )
  }
}
