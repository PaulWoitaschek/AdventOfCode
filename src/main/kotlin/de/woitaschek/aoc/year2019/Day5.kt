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
    return Computer(values.toMutableList(), inputValue).run()
  }

  private class Computer(
    private val instructions: MutableList<Int>,
    private val input: Int,
  ) {

    private var pointer = 0
    private val output = StringBuilder()
    private var finished = false

    fun run(): Int {
      while (!finished) {
        finished = !runInstructions()
      }
      return output.toString().toInt()
    }

    private fun runInstructions(): Boolean {
      val read: (Int) -> Int = { index ->
        val value = instructions[pointer + index + 1]
        val instructionValue = instructions[pointer]
        when (val v = instructionValue / 10.toFloat().pow(index + 2).toInt() % 10) {
          0 -> instructions[value]
          1 -> value
          else -> error("Invalid mode=$v")
        }
      }
      return when (val opCode = instructions[pointer] % 100) {
        1 -> {
          // add
          instructions[instructions[pointer + 3]] = read(0) + read(1)
          pointer += 4
          true
        }
        2 -> {
          // multiply
          instructions[instructions[pointer + 3]] = read(0) * read(1)
          pointer += 4
          true
        }
        3 -> {
          // write input at position
          instructions[instructions[pointer + 1]] = input
          pointer += 2
          true
        }
        4 -> {
          val value = read(0)
          output.append(value)
          pointer += 2
          true
        }
        5 -> {
          pointer = if (read(0) != 0) {
            read(1)
          } else {
            pointer + 3
          }
          true
        }
        6 -> {
          pointer = if (read(0) == 0) {
            read(1)
          } else {
            pointer + 3
          }
          true
        }
        7 -> {
          val value = if (read(0) < read(1)) 1 else 0
          instructions[instructions[pointer + 3]] = value
          pointer += 4
          true
        }
        8 -> {
          val value = if (read(0) == read(1)) 1 else 0
          instructions[instructions[pointer + 3]] = value
          pointer += 4
          true
        }
        99 -> false
        else -> error("Invalid opCode=$opCode")
      }
    }
  }
}
