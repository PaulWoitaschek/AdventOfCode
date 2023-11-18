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
    val output = StringBuilder()
    runInstructions(
      instructions = values.toMutableList(),
      pointer = 0,
      input = inputValue,
      output = output,
    )
    return output.toString().toInt()
  }

  private fun runInstructions(
    instructions: MutableList<Int>,
    pointer: Int,
    input: Int,
    output: StringBuilder,
  ) {
    val newPointer: Int
    val read: (Int) -> Int = { index ->
      val value = instructions[pointer + index + 1]
      val instructionValue = instructions[pointer]
      when (val v = instructionValue / 10.toFloat().pow(index + 2).toInt() % 10) {
        0 -> instructions[value]
        1 -> value
        else -> error("Invalid mode=$v")
      }
    }
    when (val opCode = instructions[pointer] % 100) {
      1 -> {
        // add
        instructions[instructions[pointer + 3]] = read(0) + read(1)
        newPointer = pointer + 4
      }
      2 -> {
        // multiply
        instructions[instructions[pointer + 3]] = read(0) * read(1)
        newPointer = pointer + 4
      }
      3 -> {
        // write input at position
        instructions[instructions[pointer + 1]] = input
        newPointer = pointer + 2
      }
      4 -> {
        val value = read(0)
        output.append(value)
        newPointer = pointer + 2
      }
      5 -> {
        newPointer = if (read(0) != 0) {
          read(1)
        } else {
          pointer + 3
        }
      }
      6 -> {
        newPointer = if (read(0) == 0) {
          read(1)
        } else {
          pointer + 3
        }
      }
      7 -> {
        val value = if (read(0) < read(1)) 1 else 0
        instructions[instructions[pointer + 3]] = value
        newPointer = pointer + 4
      }
      8 -> {
        val value = if (read(0) == read(1)) 1 else 0
        instructions[instructions[pointer + 3]] = value
        newPointer = pointer + 4
      }
      99 -> return
      else -> error("Invalid opCode=$opCode")
    }
    runInstructions(input = input, output = output, pointer = newPointer, instructions = instructions)
  }
}
