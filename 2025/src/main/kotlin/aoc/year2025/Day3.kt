package aoc.year2025

import aoc.library.Puzzle
import kotlin.Long
import kotlin.String

object Day3 : Puzzle<Long, Long>(day = 3) {

  override fun solvePart1(input: String): Long = input.lines()
    .sumOf { jolt(it, 2) }

  override fun solvePart2(input: String): Long = input.lines().sumOf {
    jolt(it, 12)
  }

  private fun jolt(
    input: String,
    digits: Int,
  ): Long {
    var pool = input.map(Char::digitToInt)
    var result = ""
    var remaining = digits
    while (remaining > 0) {
      val next = pool.dropLast(remaining - 1).max()
      result += next
      pool = pool.drop(pool.indexOf(next) + 1)
      remaining--
    }
    return result.toLong()
  }
}
