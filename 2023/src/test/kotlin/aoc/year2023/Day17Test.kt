package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day17Test {

  private val testInput = """
      2413432311323
      3215453535623
      3255245654254
      3446585845452
      4546657867536
      1438598798454
      4457876987766
      3637877979653
      4654967986887
      4564679986453
      1224686865563
      2546548887735
      4322674655533
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(102, Day17.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(698, Day17.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(94, Day17.solvePart2(testInput))
  }

  @Test
  fun part2TestInput2() {
    assertEquals(
      71,
      Day17.solvePart2(
        """
        111111111111
        999999999991
        999999999991
        999999999991
        999999999991
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(825, Day17.solvePart2())
  }
}
