package aoc.year2023

import aoc.library.Puzzle

object Day9 : Puzzle<Long, Long>(year = 2023, day = 9) {

  override fun solvePart1(input: String): Long = solve(input = input, addRight = true)
  override fun solvePart2(input: String): Long = solve(input = input, addRight = false)

  private fun solve(
    input: String,
    addRight: Boolean,
  ): Long = input.lines().sumOf { line ->
    val history = line.split(" ").map(String::toLong)
    predict(if (addRight) history else history.reversed())
  }

  private fun predict(history: List<Long>): Long = if (history.all { it == 0L }) {
    0L
  } else {
    history.last() + predict(history = history.windowed(2) { it[1] - it[0] })
  }
}
