package aoc.year2023

import aoc.library.Puzzle

object Day9 : Puzzle<Long, Long>(year = 2023, day = 9) {

  override fun solvePart1(input: String): Long = solve(input = input, addRight = true)
  override fun solvePart2(input: String): Long = solve(input = input, addRight = false)

  private fun solve(
    input: String,
    addRight: Boolean,
  ): Long {
    return input.lines()
      .map { it.split(" ").map(String::toLong) }
      .sumOf { predict(history = it, addRight = addRight) }
  }

  private fun predict(
    history: List<Long>,
    addRight: Boolean,
  ): Long {
    return if (history.all { it == 0L }) {
      return 0L
    } else {
      val differences = history.windowed(2) { it[1] - it[0] }
      if (addRight) {
        history.last() + predict(history = differences, addRight = true)
      } else {
        history.first() - predict(history = differences, addRight = false)
      }
    }
  }
}
