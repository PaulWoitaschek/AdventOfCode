package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day20Test {

  @Test
  fun part1TestInput1() {
    assertEquals(
      32000000,
      Day20.solvePart1(
        """
        broadcaster -> a, b, c
        %a -> b
        %b -> c
        %c -> inv
        &inv -> a
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part1TestInput2() {
    assertEquals(
      11687500,
      Day20.solvePart1(
        """
        broadcaster -> a
        %a -> inv, con
        &inv -> b
        %b -> con
        &con -> output
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(867118762, Day20.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(217317393039529, Day20.solvePart2())
  }
}
