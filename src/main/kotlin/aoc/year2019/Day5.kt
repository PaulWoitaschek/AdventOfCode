package aoc.year2019

import aoc.utils.Puzzle
import aoc.utils.toCommaSeparatedLongList
import kotlinx.coroutines.runBlocking

object Day5 : Puzzle<Long, Long>(2019, 5) {

  override fun solvePart1(input: String): Long = solve(input.toCommaSeparatedLongList(), 1)

  override fun solvePart2(input: String): Long = solve(input.toCommaSeparatedLongList(), 5)

  fun solve(
    values: List<Long>,
    inputValue: Long,
  ): Long {
    val computer = IntCodeComputer(values, listOf(inputValue))
    runBlocking {
      computer.run()
    }
    return computer.fullOutput.last()
  }
}