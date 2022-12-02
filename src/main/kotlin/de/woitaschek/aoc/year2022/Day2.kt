package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.Puzzle

object Day2 : Puzzle {

  override val day: Int = 2

  override fun solvePart1(input: String): Int = input.lines()
    .filter { it.isNotBlank() }
    .sumOf { round ->
      val opponent = RPS.parse(round[0])
      val answer = RPS.parse(round[2])
      val match = answer.match(opponent)
      match.score + answer.score
    }

  override fun solvePart2(input: String): Int = input.lines()
    .filter { it.isNotBlank() }
    .sumOf { round ->
      val opponent = RPS.parse(round[0])
      val desiredMatchResult = MatchResult.parse(round[2])
      val response = RPS.values().first { it.match(opponent) == desiredMatchResult }
      desiredMatchResult.score + response.score
    }
}

enum class RPS(val score: Int) {
  Rock(1), Paper(2), Scissor(3);

  fun match(opponent: RPS): MatchResult {
    if (this == opponent) {
      return MatchResult.Draw
    }
    val won = when (this) {
      Rock -> opponent == Scissor
      Paper -> opponent == Rock
      Scissor -> opponent == Paper
    }
    return if (won) {
      MatchResult.Won
    } else {
      MatchResult.Loss
    }
  }

  companion object {
    fun parse(input: Char): RPS {
      return when (input) {
        'A', 'X' -> Rock
        'B', 'Y' -> Paper
        'C', 'Z' -> Scissor
        else -> error("Invalid input $input")
      }
    }
  }
}

enum class MatchResult(val score: Int) {
  Won(6),
  Loss(0),
  Draw(3);

  companion object {
    fun parse(input: Char): MatchResult {
      return when (input) {
        'X' -> Loss
        'Y' -> Draw
        'Z' -> Won
        else -> error("Invalid input $input")
      }
    }
  }
}
