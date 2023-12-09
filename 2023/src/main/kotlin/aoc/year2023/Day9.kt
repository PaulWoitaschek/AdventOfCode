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
    addRight: Boolean = true,
  ): Long {
    val values = mutableListOf(history.toMutableList())
    while (true) {
      val differences = values.last().windowed(2) { it[1] - it[0] }
      values.add(differences.toMutableList())
      if (differences.all { it == 0L }) {
        break
      }
    }
    for (index in values.lastIndex - 1 downTo 0) {
      val row = values[index]
      if (addRight) {
        row.add(row.last() + values[index + 1].last())
      } else {
        row.add(0, row.first() - values[index + 1].first())
      }
    }
    val firstLine = values.first()
    return if (addRight) firstLine.last() else firstLine.first()
  }
}
