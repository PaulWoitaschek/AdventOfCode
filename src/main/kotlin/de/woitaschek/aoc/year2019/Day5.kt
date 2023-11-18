package de.woitaschek.aoc.year2019

import de.woitaschek.aoc.utils.Puzzle
import de.woitaschek.aoc.utils.toCommaSeparatedIntList
import kotlinx.coroutines.runBlocking

object Day5 : Puzzle<Int, Int>(2019, 5) {

  override fun solvePart1(input: String): Int = solve(input.toCommaSeparatedIntList(), 1)

  override fun solvePart2(input: String): Int = solve(input.toCommaSeparatedIntList(), 5)

  fun solve(
    values: List<Int>,
    inputValue: Int,
  ): Int {
    val computer = IntCodeComputer(values.toMutableList(), mutableListOf(inputValue))
    runBlocking {
      computer.run()
    }
    return computer.fullOutput
  }
}
