package aoc.year2023

import aoc.library.Puzzle

object Day6 : Puzzle<Int, Int>(year = 2023, day = 6) {

  override fun solvePart1(input: String): Int = Round.parseAsMultipleRounds(input)
    .map(Round::waysToSolve)
    .reduce(Int::times)

  override fun solvePart2(input: String): Int = Round.parseAsSingleRound(input).waysToSolve()

  private data class Round(
    val time: Long,
    val recordDistance: Long,
  ) {

    fun waysToSolve(): Int = (0..time).count { speed ->
      (time - speed) * speed > recordDistance
    }

    companion object {
      fun parseAsMultipleRounds(input: String): List<Round> {
        val values = input.lines().map { line ->
          line.split(' ').mapNotNull(String::toLongOrNull)
        }
        return values[0].zip(values[1]).map { Round(it.first, it.second) }
      }

      fun parseAsSingleRound(input: String): Round {
        val values = input.lines().map { line ->
          line.filter(Char::isDigit).toLong()
        }
        return Round(time = values[0], recordDistance = values[1])
      }
    }
  }
}
