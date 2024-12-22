package aoc.year2024

import aoc.library.Puzzle

object Day22 : Puzzle<Long, Long>(day = 22) {

  override fun solvePart1(input: String): Long = input.lines().map { it.toLong() }.sumOf {
    var secret = it
    repeat(2000) {
      secret = secretNumber(secret)
    }
    secret
  }

  override fun solvePart2(input: String): Long {
    TODO()
  }

  private fun secretNumber(secretNumber: Long): Long {
    var secret = secretNumber
    fun mixAndPrune(value: Long) {
      secret = (secret xor value).mod(16777216L)
    }
    mixAndPrune(secret * 64)
    mixAndPrune((secret.toDouble() / 32.0).toLong())
    mixAndPrune(secret * 2048)
    return secret
  }
}
