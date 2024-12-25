package aoc.year2024

import aoc.library.Puzzle

object Day25 : Puzzle<Int, Unit>(day = 25) {

  override fun solvePart1(input: String): Int {
    val (keys, locks) = parse(input)
    return keys.sumOf { key ->
      locks.count { lock ->
        keyMatchesLock(key, lock)
      }
    }
  }

  private fun keyMatchesLock(
    key: List<Int>,
    lock: List<Int>,
  ): Boolean = key.zip(lock).all { (k, l) ->
    k + l <= 5
  }

  private fun parse(input: String): Pair<List<List<Int>>, List<List<Int>>> {
    val keys = mutableListOf<List<Int>>()
    val locks = mutableListOf<List<Int>>()
    input.split("\n\n").map {
      val lines = it.lines()
      val isKey = lines[0][0] == '#'
      val pins = List(5) { row ->
        (1..5).count { column ->
          lines[column][row] == '#'
        }
      }
      if (isKey) keys += pins else locks += pins
    }
    return keys to locks
  }

  override fun solvePart2(input: String) {
  }
}
