package aoc.year2020

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day10Test {

  @Test
  fun part1() {
    assertEquals(1998, Day10.solvePart1())
    assertEquals(
      22 * 10,
      Day10.solvePart1(
        """
        28
        33
        18
        42
        31
        14
        46
        20
        48
        47
        24
        23
        49
        45
        19
        38
        39
        11
        1
        32
        25
        35
        8
        17
        7
        9
        4
        2
        34
        10
        3
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(347250213298688, Day10.solvePart2())
    assertEquals(
      19208,
      Day10.solvePart2(
        """
        28
        33
        18
        42
        31
        14
        46
        20
        48
        47
        24
        23
        49
        45
        19
        38
        39
        11
        1
        32
        25
        35
        8
        17
        7
        9
        4
        2
        34
        10
        3
        """
          .trimIndent(),
      ),
    )
  }
}
