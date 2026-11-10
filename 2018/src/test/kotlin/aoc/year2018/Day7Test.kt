package aoc.year2018

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day7Test {

  private val testInput =
    """
    Step C must be finished before step A can begin.
    Step C must be finished before step F can begin.
    Step A must be finished before step B can begin.
    Step A must be finished before step D can begin.
    Step B must be finished before step E can begin.
    Step D must be finished before step E can begin.
    Step F must be finished before step E can begin.
    """
      .trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals("CABDFE", Day7.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals("OUGLTKDJVBRMIXSACWYPEQNHZF", Day7.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(15, Day7.solvePart2(testInput, workerCount = 2, additionalSeconds = 0))
  }

  @Test
  fun part2() {
    assertEquals(929, Day7.solvePart2())
  }
}
