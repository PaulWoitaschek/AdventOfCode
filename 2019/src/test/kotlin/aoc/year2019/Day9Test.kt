package aoc.year2019

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day9Test {

  @Test
  fun part1() {
    assertEquals(3241900951, Day9.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(83089, Day9.solvePart2())
  }

  @Test
  fun relativeBaseTestOne() {
    val computer = IntCodeComputer(instructions = listOf(104, 1125899906842624, 99), inputs = emptyList())
    runBlocking { computer.run() }
    assertEquals(1125899906842624, computer.fullOutput.last())
  }

  @Test
  fun relativeBaseTestTwo() {
    val computer = IntCodeComputer(instructions = listOf(1102, 34915192, 34915192, 7, 4, 7, 99, 0), inputs = emptyList())
    runBlocking { computer.run() }
    assertEquals(16, computer.fullOutput.last().toString().length)
  }

  @Test
  fun relativeBaseTestThree() {
    val instructions: List<Long> = listOf(109, 1, 204, -1, 1001, 100, 1, 100, 1008, 100, 16, 101, 1006, 101, 0, 99)
    val computer =
      IntCodeComputer(instructions = instructions, inputs = emptyList())
    runBlocking { computer.run() }
    assertEquals(instructions, computer.fullOutput)
  }
}
