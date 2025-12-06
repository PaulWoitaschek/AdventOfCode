package aoc.year2025

import aoc.library.Puzzle

object Day6 : Puzzle<Long, Long>(day = 6) {

  override fun solvePart1(input: String): Long {
    val lines = input.lines()
    val numbers = lines.dropLast(1).map {
      it.split(" ").toList()
        .mapNotNull(String::toLongOrNull)
    }
    val operators = lines.last().mapNotNull(::parseOperator)
    return operators.withIndex().sumOf { (index, operator) ->
      val values = numbers.map { it[index] }
      values.reduce(operator)
    }
  }

  override fun solvePart2(input: String): Long {
    val lines = input.lines()
    val width = lines.maxOf { it.length }
    val height = lines.size

    val numbers = mutableListOf<Long>()
    var x = width - 1
    var sum = 0L

    while (x >= 0) {
      val value = (0..<height - 1).map {
        lines.getOrNull(it)?.getOrNull(x) ?: ""
      }.joinToString("").trim().toIntOrNull()
      val operatorChar = lines.last().getOrNull(x).takeUnless { it == ' ' }

      if (value != null) {
        numbers += value.toLong()
      }
      if (operatorChar != null) {
        sum += numbers.reduce(parseOperator(operatorChar)!!)
        numbers.clear()
      }
      x--
    }

    return sum
  }

  private fun parseOperator(operator: Char): ((Long, Long) -> Long)? = when (operator) {
    '+' -> Long::plus
    '*' -> Long::times
    else -> null
  }
}
