@file:Suppress("ConvertCallChainIntoSequence")

package aoc.year2021

import aoc.library.Puzzle

object Day1 : Puzzle<Long, Long>(2021, 1) {

  override fun solvePart1(input: String): Long {
    return input.lines().map(String::toInt)
      .windowed(2)
      .count { (previous, current) ->
        current > previous
      }
      .toLong()
  }

  override fun solvePart2(input: String): Long {
    return input.lines().map(String::toInt)
      .windowed(size = 3)
      .map { it.sum() }
      .windowed(2)
      .count { (previous, current) ->
        current > previous
      }
      .toLong()
  }
}
