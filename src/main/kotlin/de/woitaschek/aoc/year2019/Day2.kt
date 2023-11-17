package de.woitaschek.aoc.year2019

import de.woitaschek.aoc.utils.Puzzle
import de.woitaschek.aoc.utils.commaSeparatedIntList

object Day2 : Puzzle<Int, Int>(2019, 2) {

  override fun solvePart1(input: String): Int {
    return runInstructions(instructions = input.commaSeparatedIntList(), verb = 2, noun = 12)
  }

  override fun solvePart2(input: String): Int {
    val originalInput = input.commaSeparatedIntList()
    var max = 0
    while (true) {
      max++
      (0..max).forEach { verb ->
        (0..max).forEach { noun ->
          val out = runInstructions(instructions = originalInput, verb = verb, noun = noun)
          if (out == 19690720) {
            return 100 * noun + verb
          }
        }
      }
    }
  }

  fun processInstructions(instructions: List<Int>): List<Int> {
    var position = 0
    val result = instructions.toMutableList()
    while (true) {
      val opCode = result[position]
      if (opCode == 99) return result
      val leftValue = result[result[position + 1]]
      val rightValue = result[result[position + 2]]
      result[result[position + 3]] = when (opCode) {
        1 -> leftValue + rightValue
        2 -> leftValue * rightValue
        else -> error("Invalid opCode=$opCode")
      }
      position += 4
    }
  }

  private fun runInstructions(
    instructions: List<Int>,
    verb: Int,
    noun: Int,
  ): Int {
    return processInstructions(
      instructions
        .toMutableList()
        .apply {
          set(1, noun)
          set(2, verb)
        },
    )
      .first()
  }
}
