package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day12Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      140,
      Day12.solvePart1(
        """
        AAAA
        BBCD
        BBCC
        EEEC
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part1TestInput2() {
    assertEquals(
      1930,
      Day12.solvePart1(
        """
        RRRRIICCFF
        RRRRIICCCF
        VVRRRCCFFF
        VVRCCCJFFF
        VVVVCJJCFE
        VVIVCCJJEE
        VVIIICJJEE
        MIIIIIJJEE
        MIIISIJEEE
        MMMISSJEEE
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(1434856, Day12.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      80,
      Day12.solvePart2(
        """
        AAAA
        BBCD
        BBCC
        EEEC
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2TestInput2() {
    assertEquals(
      1206,
      Day12.solvePart2(
        """
        RRRRIICCFF
        RRRRIICCCF
        VVRRRCCFFF
        VVRCCCJFFF
        VVVVCJJCFE
        VVIVCCJJEE
        VVIIICJJEE
        MIIIIIJJEE
        MIIISIJEEE
        MMMISSJEEE
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(891106, Day12.solvePart2())
  }
}
