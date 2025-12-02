package aoc.year2025

import aoc.library.Puzzle
import kotlin.Long
import kotlin.String

object Day2 : Puzzle<Long, Long>(day = 2) {

  override fun solvePart1(input: String): Long {
    val idRanges = input.replace("\n", "")
      .split(",")
      .map {
        val (from, to) = it.split("-")
        from.toLong() to to.toLong()
      }

    return idRanges.flatMap {
      (it.first..it.second).filter {
        !isValidId(it)
      }
    }.sum()
  }

  fun isValidId(id: Long): Boolean {
    val str = id.toString()
    return str.take(str.length / 2) != str.drop(str.length / 2)
  }

  override fun solvePart2(input: String): Long {
    val idRanges = input.replace("\n", "")
      .split(",")
      .map {
        val (from, to) = it.split("-")
        from.toLong() to to.toLong()
      }

    return idRanges.flatMap {
      (it.first..it.second).filter {
        !isValidId2(it)
      }
    }.sum()
  }

  fun isValidId2(id: Long): Boolean {
    val length = id.toString().length
    return (1..length / 2).none { chunkWidth ->
      val chunks = id.toString().chunked(chunkWidth)
      val invalid = chunks.size > 1 && chunks.toSet().size == 1
      invalid
    }
  }
}
