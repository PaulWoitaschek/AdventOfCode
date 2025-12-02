package aoc.year2025

import aoc.library.Puzzle
import kotlin.Long
import kotlin.String

object Day2 : Puzzle<Long, Long>(day = 2) {

  override fun solvePart1(input: String): Long = solve(input, ::isValidId1)

  fun isValidId1(id: Long): Boolean {
    val idString = id.toString()
    return idString.take(idString.length / 2) != idString.drop(idString.length / 2)
  }

  override fun solvePart2(input: String): Long = solve(input, ::isValidId2)

  fun isValidId2(id: Long): Boolean {
    val idString = id.toString()
    return (1..idString.length / 2).none { chunkWidth ->
      idString.chunked(chunkWidth).toSet().size == 1
    }
  }

  private fun solve(
    input: String,
    isValid: (Long) -> Boolean,
  ): Long = input.replace("\n", "")
    .split(",")
    .flatMap {
      val (from, to) = it.split("-").map(String::toLong)
      from..to
    }
    .filterNot { isValid(it) }
    .sum()
}
