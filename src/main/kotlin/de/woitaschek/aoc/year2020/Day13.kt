package de.woitaschek.aoc.year2020

import de.woitaschek.aoc.utils.Puzzle

object Day13 : Puzzle(2020, 13) {

  override fun solvePart1(input: String): Any {
    val lines = input.lines()
    val earliestBus = lines.first().toInt()
    val busses = lines[1].split(",").mapNotNull { it.toIntOrNull() }
    return extracted(earliestBus, busses)
  }

  override fun solvePart2(input: String): Any {
    TODO("Not yet implemented")
  }

  private fun extracted(earliestBus: Int, busses: List<Int>): Int = generateSequence(earliestBus) { it + 1 }
    .firstNotNullOf { minute ->
      val bus = busses.find { minute.mod(it) == 0 }
      if (bus != null) {
        (minute - earliestBus) * bus
      } else {
        null
      }
    }
}