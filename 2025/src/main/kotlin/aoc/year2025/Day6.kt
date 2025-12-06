package aoc.year2025

import aoc.library.Puzzle

object Day6 : Puzzle<Long, Long>(day = 6) {

  override fun solvePart1(input: String): Long {
    val lines = input.lines()
    val numbers = lines.dropLast(1).map {
      it.split(" ").toList()
        .mapNotNull(String::toLongOrNull)
    }
    val operators = lines.last().split(" ").filter { it != " " && it != "" }
    return operators.withIndex().sumOf { (index, operator) ->
      val values = numbers.map { it[index] }
      when (operator) {
        "*" -> values.reduce(Long::times)
        "+" -> values.reduce(Long::plus)
        else -> error("")
      }
    }
  }

  override fun solvePart2(input: String): Long {
    val lines = input.lines()
    val width = lines.maxOf { it.length }
    val height = lines.size

    val numbers = mutableListOf<Long>()
    var x = width - 1
    var result = 0L

    while (x >= 0) {
      val value = (0..<height - 1).map {
        lines.getOrNull(it)?.getOrNull(x) ?: ""
      }.joinToString("").trim().toIntOrNull()
      val operator = lines.last().getOrNull(x)

      if (value != null) {
        numbers += value.toLong()
      }
      if (operator != null && operator != ' ') {
        val op: (Long, Long) -> Long = when (operator) {
          '+' -> Long::plus
          '*' -> Long::times
          else -> error("")
        }
        val r = numbers.reduce(op)
        result += r
        // println("the result of $numbers with $operator is $r")
        numbers.clear()
      }
      //  println(value)
      //  println(operator)

      x--
    }

    return result
  }
}
