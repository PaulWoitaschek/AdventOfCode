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

    fun waysToSolve(): Int {
      return (0..time).count { speed ->
        ((time - speed) * speed > recordDistance)
      }
    }

    companion object {
      private val digitRegex = """(\d+)""".toRegex()
      fun parseAsMultipleRounds(input: String): List<Round> {
        val values = input.lines().map { line ->
          digitRegex.findAll(line)
            .map { it.groupValues[1].toLong() }
            .toList()
        }
        return values[0].zip(values[1]).map { Round(it.first, it.second) }
      }

      fun parseAsSingleRound(input: String): Round {
        val values = input.lines().map { line ->
          digitRegex.findAll(line)
            .map { it.groupValues[1].toInt() }
            .joinToString("")
            .toLong()
        }
        return Round(time = values[0], recordDistance = values[1])
      }
    }
  }
}
