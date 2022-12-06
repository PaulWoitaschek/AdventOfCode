package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.Puzzle

object Day6 : Puzzle(2022, 6) {
  override fun solvePart1(input: String) = input.solve(4)
  override fun solvePart2(input: String) = input.solve(14)
}

private fun String.solve(windowSize: Int) = windowed(windowSize).indexOfFirst { window ->
  (window.toSet().size == windowSize)
} + windowSize
