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
        runInstruction()
      }
      return output.toString().toInt()
    }

    private fun read(index: Int): Int {
      val value = instructions[pointer + index + 1]
      val instructionValue = instructions[pointer]
      return when (val v = instructionValue / 10.toFloat().pow(index + 2).toInt() % 10) {
        0 -> instructions[value]
        1 -> value
        else -> error("Invalid mode=$v")
      }
    }

    private fun write(
      index: Int,
      value: Int,
    ) {
      instructions[instructions[pointer + index + 1]] = value
    }

    private fun runInstruction() {
      when (val opCode = instructions[pointer] % 100) {
        1 -> {
          write(2, read(0) + read(1))
          pointer += 4
        }
        2 -> {
          write(2, read(0) * read(1))
          pointer += 4
        }
        3 -> {
          write(0, input)
          pointer += 2
        }
        4 -> {
          output.append(read(0))
          pointer += 2
        }
        5 -> {
          if (read(0) != 0) {
            pointer = read(1)
          } else {
            pointer += 3
          }
        }
        6 -> {
          if (read(0) == 0) {
            pointer = read(1)
          } else {
            pointer += 3
          }
        }
        7 -> {
          val value = if (read(0) < read(1)) 1 else 0
          write(2, value)
          pointer += 4
        }
        8 -> {
          val value = if (read(0) == read(1)) 1 else 0
          write(2, value)
          pointer += 4
        }
        99 -> {
          finished = true
        }
        else -> error("Invalid opCode=$opCode")
      }
    }
  }
}
