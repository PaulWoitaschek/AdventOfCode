package aoc.year2018

import aoc.utils.Puzzle
import aoc.utils.toLineSeparatedIntList

object Day1 : Puzzle<Int, Int>(year = 2018, day = 1) {

  override fun solvePart1(input: String): Int {
    return input.toLineSeparatedIntList().fold(0, Int::plus)
  }

  override fun solvePart2(input: String): Int {
    val values = input.toLineSeparatedIntList()
    val emitted = mutableSetOf<Int>()
    return sequence {
      while (true) {
        yieldAll(values)
      }
    }
      .runningFold(0, Int::plus)
      .first {
        !emitted.add(it)
      }
  }
}
