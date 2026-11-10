package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

  private val testInput = """
      L68
      L30
      R48
      L5
      R60
      L55
      L1
      L99
      R14
      L82
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(3, Day1.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(1074, Day1.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(6, Day1.solvePart2(testInput))
  }

  @Test
  fun part2TestInput2() {
    assertEquals(10, Day1.solvePart2("R1000"))
  }

  @Test
  fun part2TestInput3() {
    assertEquals(0, Day1.solvePart2("R49"))
  }

  @Test
  fun part2TestInput4() {
    assertEquals(1, Day1.solvePart2("R50"))
  }

  @Test
  fun part2TestInput5() {
    assertEquals(0, Day1.solvePart2("L49"))
  }

  @Test
  fun part2TestInput6() {
    assertEquals(1, Day1.solvePart2("L50"))
  }

  @Test
  fun part2() {
    assertEquals(6254, Day1.solvePart2())
  }
}
