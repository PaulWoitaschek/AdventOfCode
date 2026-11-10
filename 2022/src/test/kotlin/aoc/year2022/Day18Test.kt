package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day18Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      64,
      Day18.solvePart1(
        """
2,2,2
1,2,2
3,2,2
2,1,2
2,3,2
2,2,1
2,2,3
2,2,4
2,2,6
1,2,5
3,2,5
2,1,5
2,3,5
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1RegularInput() {
    assertEquals(4370, Day18.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      58,
      Day18.solvePart2(
        """
2,2,2
1,2,2
3,2,2
2,1,2
2,3,2
2,2,1
2,2,3
2,2,4
2,2,6
1,2,5
3,2,5
2,1,5
2,3,5
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2RegularInput() {
    assertEquals(2458, Day18.solvePart2())
  }
}
