package aoc.year2019

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day3Test {

  @Test
  fun solvePart1() {
    assertEquals(217, Day3.solvePart1())
  }

  @Test
  fun solvePart2() {
    assertEquals(3454, Day3.solvePart2())
  }

  @Test
  fun day3Part1() {
    assertEquals(
      159,
      Day3.solvePart1(
        """
        R75,D30,R83,U83,L12,D49,R71,U7,L72
        U62,R66,U55,R34,D71,R55,D58,R83
        """.trimIndent(),
      ),
    )

    assertEquals(
      135,
      Day3.solvePart1(
        """
      R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51
      U98,R91,D20,R16,D67,R40,U7,R15,U6,R7
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun day3Part2() {
    assertEquals(
      610,
      Day3.solvePart2(
        """
        R75,D30,R83,U83,L12,D49,R71,U7,L72
        U62,R66,U55,R34,D71,R55,D58,R83
        """.trimIndent(),
      ),
    )

    assertEquals(
      410,
      Day3.solvePart2(
        """
      R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51
      U98,R91,D20,R16,D67,R40,U7,R15,U6,R7
        """.trimIndent(),
      ),
    )
  }
}
