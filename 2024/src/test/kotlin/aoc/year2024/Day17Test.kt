package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day17Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      listOf(4, 6, 3, 5, 6, 3, 5, 2, 1, 0),
      Day17.solvePart1(
        """
        Register A: 729
        Register B: 0
        Register C: 0

        Program: 0,1,5,4,3,0
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun tc1() {
    Day17.Computer(a = 0, b = 0, c = 9, program = listOf(2, 6)).apply {
      run()
      assertEquals(1, b)
    }
  }

  @Test
  fun tc2() {
    assertEquals(
      listOf(0, 1, 2),
      Day17.Computer(a = 10, b = 0, c = 0, program = listOf(5, 0, 5, 1, 5, 4)).run(),
    )
  }

  @Test
  fun tc3() {
    Day17.Computer(a = 2024, b = 0, c = 0, program = listOf(0, 1, 5, 4, 3, 0)).apply {
      assertEquals(listOf(4, 2, 5, 6, 7, 7, 7, 7, 3, 1, 0), run())
      assertEquals(0, a)
    }
  }

  @Test
  fun tc4() {
    Day17.Computer(a = 0, b = 29, c = 0, program = listOf(1, 7)).apply {
      run()
      assertEquals(26, b)
    }
  }

  @Test
  fun tc5() {
    Day17.Computer(a = 0, b = 2024, c = 43690, program = listOf(4, 0)).apply {
      run()
      assertEquals(44354, b)
    }
  }

  @Test
  fun part1() {
    assertEquals(
      listOf(3, 5, 0, 1, 5, 1, 5, 1, 0),
      Day17.solvePart1().also { println(it.joinToString(",")) },
    )
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      117440,
      Day17.solvePart2(
        """
        Register A: 2024
        Register B: 0
        Register C: 0

        Program: 0,3,5,4,3,0
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  @Disabled
  fun part2() {
    assertEquals(42, Day17.solvePart2())
  }
}
