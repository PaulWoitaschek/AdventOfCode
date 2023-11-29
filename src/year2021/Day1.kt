@file:Suppress("ConvertCallChainIntoSequence")

package year2021

import utils.Puzzle

object Day1 : Puzzle<Long, Long>(2021, 1) {

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
