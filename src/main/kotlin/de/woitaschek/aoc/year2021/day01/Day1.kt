@file:Suppress("ConvertCallChainIntoSequence")

package de.woitaschek.aoc.year2021.day01

import de.woitaschek.aoc.Puzzle

object Day1 : Puzzle {

  override val day = 1

  override fun solvePart1(input: String): Long {
    return input.lines().map { it.toInt() }
      .windowed(2)
      .count { (previous, current) ->
        current > previous
      }
      .toLong()
  }

  override fun solvePart2(input: String): Long {
    return input.lines().map { it.toInt() }
      .windowed(size = 3)
      .map { it.sum() }
      .windowed(2)
      .count { (previous, current) ->
        current > previous
      }
      .toLong()
  }
}
