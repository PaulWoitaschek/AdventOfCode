package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.Puzzle

object Day1 : Puzzle {

  override val day: Int = 1

  override fun solvePart1(input: String) = parse(input).max()

  override fun solvePart2(input: String) = parse(input).sortedDescending().take(3).sum()
}

private fun parse(input: String): List<Long> {
  val elves = mutableListOf<Long>()
  val lines = input.lines()
  var calories = 0L
  lines.forEachIndexed { index, line ->
    if (line.isBlank() || index == lines.size - 1) {
      elves.add(calories)
      calories = 0
    } else {
      calories += line.toLong()
    }
  }
  return elves
}
