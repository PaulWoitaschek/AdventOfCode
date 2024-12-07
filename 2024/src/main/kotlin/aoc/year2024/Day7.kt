package aoc.year2024

import aoc.library.Puzzle

object Day7 : Puzzle<Long, Long>(day = 7) {

  override fun solvePart1(input: String): Long = solve(input, listOf(Operator.Add, Operator.Multiply))

  override fun solvePart2(input: String): Long = solve(input, listOf(Operator.Add, Operator.Multiply, Operator.Concat))

  private fun solve(
    input: String,
    operators: List<Operator>,
  ): Long {
    val numberRegex = """(\d+)""".toRegex()
    return input.lines()
      .map { line ->
        numberRegex.findAll(line).map { it.value.toLong() }.toList()
      }
      .filter {
        val solution = it.first()
        val elements = it.drop(1)
        isSolvable(solution, operators, elements)
      }
      .sumOf { it.first() }
  }

  private fun isSolvable(
    solution: Long,
    operators: List<Operator>,
    elements: List<Long>,
  ): Boolean {
    if (elements.size == 1) {
      return elements.first() == solution
    }

    // performance optimization
    if (elements.first() > solution) {
      return false
    }

    return operators.any { operator ->
      isSolvable(
        solution = solution,
        operators = operators,
        elements = elements.toMutableList().apply {
          val first = removeAt(0)
          val second = removeAt(0)
          val value = when (operator) {
            Operator.Add -> first + second
            Operator.Multiply -> first * second
            Operator.Concat -> (first.toString() + second.toString()).toLong()
          }
          add(0, value)
        },
      )
    }
  }

  private enum class Operator { Add, Multiply, Concat }
}
