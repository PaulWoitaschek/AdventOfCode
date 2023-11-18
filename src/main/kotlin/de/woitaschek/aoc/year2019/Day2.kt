package de.woitaschek.aoc.year2019

import de.woitaschek.aoc.utils.Puzzle
import de.woitaschek.aoc.utils.toCommaSeparatedIntList
import kotlinx.coroutines.runBlocking

object Day2 : Puzzle<Int, Int>(2019, 2) {

  override fun solvePart1(input: String): Int {
    return runInstructions(instructions = input.toCommaSeparatedIntList(), verb = 2, noun = 12)
  }

  override fun solvePart2(input: String): Int {
    val originalInput = input.toCommaSeparatedIntList()
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

  private fun runInstructions(
    instructions: List<Int>,
    verb: Int,
    noun: Int,
  ): Int {
    val computer = IntCodeComputer(
      instructions
        .toMutableList()
        .apply {
          set(1, noun)
          set(2, verb)
        },
      emptyList(),
    )
    runBlocking {
      computer.run()
    }
    return computer.firstInstruction
  }
}
