package aoc.year2024

import aoc.library.Puzzle

object Day19 : Puzzle<Int, Long>(day = 19) {

  override fun solvePart1(input: String): Int = findPossibleCombinations(input).count { it > 0 }

  override fun solvePart2(input: String): Long = findPossibleCombinations(input).sum()

  private fun findPossibleCombinations(input: String): List<Long> {
    val lines = input.lines()
    val available = lines[0].split(", ").toSet()
    val required = lines.drop(2)

    val cache = mutableMapOf<String, Long>()

    fun possibleCombinations(towel: String): Long = cache.getOrPut(towel) {
      if (towel.isEmpty()) {
        1
      } else {
        available.filter { it in towel }
          .sumOf {
            if (towel.startsWith(it)) {
              possibleCombinations(towel.removePrefix(it))
            } else {
              0
            }
          }
      }
    }

    return required.map { possibleCombinations(it) }
  }
}
