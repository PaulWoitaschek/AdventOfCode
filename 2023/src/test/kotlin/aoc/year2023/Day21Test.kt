package aoc.year2023

import aoc.library.solvePart1
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day21Test {

  @Test
  fun positionAfter6Steps() {
    assertEquals(
      16,
      Day21.positionsAfterSteps(
        input =
          """
          ...........
          .....###.#.
          .###.##..#.
          ..#.#...#..
          ....#.#....
          .##..S####.
          .##..#...#.
          .......##..
          .##.#.####.
          .##..##.##.
          ...........
          """
            .trimIndent(),
        steps = 6,
      ),
    )
  }

  @Test
  fun positionAfter10Steps() {
    assertEquals(
      50,
      Day21.positionsAfterSteps(
        input =
          """
          ...........
          .....###.#.
          .###.##..#.
          ..#.#...#..
          ....#.#....
          .##..S####.
          .##..#...#.
          .......##..
          .##.#.####.
          .##..##.##.
          ...........
          """
            .trimIndent(),
        steps = 10,
      ),
    )
  }

  @Test
  fun positionAfter50Steps() {
    assertEquals(
      1594,
      Day21.positionsAfterSteps(
        input =
          """
          ...........
          .....###.#.
          .###.##..#.
          ..#.#...#..
          ....#.#....
          .##..S####.
          .##..#...#.
          .......##..
          .##.#.####.
          .##..##.##.
          ...........
          """
            .trimIndent(),
        steps = 50,
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(3660, Day21.solvePart1())
  }
}
