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
        val solutions = mutableListOf<Long>()
        runEquations(operators, elements, solutions)
        solution in solutions
      }
      .sumOf { it.first() }
  }

  private fun runEquations(
    operators: List<Operator>,
    input: List<Long>,
    output: MutableList<Long>,
  ) {
    if (input.size == 1) {
      output.add(input.first())
      return
    }

    operators.forEach { operator ->
      runEquations(
        operators,
        input.toMutableList().apply {
          val first = removeAt(0)
          val second = removeAt(0)
          val value = when (operator) {
            Operator.Add -> first + second
            Operator.Multiply -> first * second
            Operator.Concat -> (first.toString() + second.toString()).toLong()
          }
          add(0, value)
        },
        output,
      )
    }
  }

  private enum class Operator { Add, Multiply, Concat }
}
