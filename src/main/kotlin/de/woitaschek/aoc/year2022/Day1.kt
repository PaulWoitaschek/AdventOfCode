package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.Puzzle

object Day1 : Puzzle(2022, 1) {
  override fun solvePart1(input: String) = parse(input).max()
  override fun solvePart2(input: String) = parse(input).sortedDescending().take(3).sum()
}

private fun parse(input: String): List<Int> {
  return input.split("\n\n")
    .map { elv ->
      elv.split("\n").sumOf { line ->
        line.toIntOrNull() ?: 0
      }
    }
}
