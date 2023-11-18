package de.woitaschek.aoc.year2019

import de.woitaschek.aoc.utils.Puzzle
import de.woitaschek.aoc.utils.toCommaSeparatedIntList
import kotlin.math.pow

object Day5 : Puzzle<Int, Int>(2019, 5) {

  override fun solvePart1(input: String): Int = solve(input.toCommaSeparatedIntList(), 1)

  override fun solvePart2(input: String): Int = solve(input.toCommaSeparatedIntList(), 5)

  fun solve(
    values: List<Int>,
    inputValue: Int,
  ): Int {
    val state = ComputerState(
      instructions = values.toMutableList(),
      input = inputValue,
    )
    runInstructions(state)
    return state.output.toInt()
  }

  private data class ComputerState(
    val instructions: MutableList<Int>,
    var output: String = "",
    val input: Int,
    var pointer: Int = 0,
  ) {

    operator fun get(index: Int): Int {
      val value = instructions[pointer + index + 1]
      val instructionValue = instructions[pointer]
      return when (val v = instructionValue / 10.toFloat().pow(index + 2).toInt() % 10) {
        0 -> instructions[value]
        1 -> value
        else -> error("Invalid mode=$v")
      }
    }
  }

  private fun runInstructions(state: ComputerState) {
    val instructions = state.instructions
    when (val opCode = instructions[state.pointer] % 100) {
      1 -> {
        // add
        instructions[instructions[state.pointer + 3]] = state[0] + state[1]
        state.pointer += 4
      }
      2 -> {
        // multiply
        instructions[instructions[state.pointer + 3]] = state[0] * state[1]
        state.pointer += 4
      }
      3 -> {
        // write input at position
        instructions[instructions[state.pointer + 1]] = state.input
        state.pointer += 2
      }
      4 -> {
        val value = state[0]
        state.output += value.toString()
        state.pointer += 2
      }
      5 -> {
        state.pointer = if (state[0] != 0) {
          state[1]
        } else {
          state.pointer + 3
        }
      }
      6 -> {
        state.pointer = if (state[0] == 0) {
          state[1]
        } else {
          state.pointer + 3
        }
      }
      7 -> {
        val value = if (state[0] < state[1]) 1 else 0
        instructions[instructions[state.pointer + 3]] = value
        state.pointer += 4
      }
      8 -> {
        val value = if (state[0] == state[1]) 1 else 0
        instructions[instructions[state.pointer + 3]] = value
        state.pointer += 4
      }
      99 -> return
      else -> error("Invalid opCode=$opCode")
    }
    runInstructions(state)
  }
}
