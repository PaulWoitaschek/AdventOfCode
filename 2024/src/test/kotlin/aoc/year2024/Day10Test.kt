package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day10Test {

  @Test
  fun part1TC1() {
    assertEquals(
      2,
      Day10.solvePart1(
        """
      ...0...
      ...1...
      ...2...
      6543456
      7.....7
      8.....8
      9.....9
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1TC2() {
    assertEquals(
      4,
      Day10.solvePart1(
        """
        ..90..9
        ...1.98
        ...2..7
        6543456
        765.987
        876....
        987....
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1TC3() {
    assertEquals(
      3,
      Day10.solvePart1(
        """
        10..9..
        2...8..
        3...7..
        4567654
        ...8..3
        ...9..2
        .....01
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1TC4() {
    assertEquals(
      36,
      Day10.solvePart1(
        """
        89010123
        78121874
        87430965
        96549874
        45678903
        32019012
        01329801
        10456732
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(459, Day10.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      81,
      Day10.solvePart2(
        """
        89010123
        78121874
        87430965
        96549874
        45678903
        32019012
        01329801
        10456732
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(1034, Day10.solvePart2())
  }
}
