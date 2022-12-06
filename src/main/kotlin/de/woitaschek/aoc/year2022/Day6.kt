package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.utils.Puzzle

object Day6 : Puzzle(2022, 6) {
  override fun solvePart1(input: String) = input.solve(4)
  override fun solvePart2(input: String) = input.solve(14)
}

private fun String.solve(windowSize: Int) = windowedSequence(windowSize).indexOfFirst { window ->
  (window.toSet().size == windowSize)
} + windowSize
