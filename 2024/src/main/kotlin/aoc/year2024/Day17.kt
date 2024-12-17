package aoc.year2024

import aoc.library.Puzzle
import kotlin.math.pow

object Day17 : Puzzle<List<Int>, Int>(day = 17) {

  data class Computer(
    var a: Int,
    var b: Int,
    var c: Int,
    val program: List<Int>,
    val output: MutableList<Int> = mutableListOf(),
    var pointer: Int = 0,
  ) {

    private fun literalOperand(): Int = program[pointer++]

    private fun comboOperand(): Int = when (val value = program[pointer++]) {
      0, 1, 2, 3 -> value
      4 -> a
      5 -> b
      6 -> c
      else -> error("Invalid operand $value")
    }

    private fun opCode(): Int? = program.getOrNull(pointer++)

    private fun advStyleCalculation(): Double {
      val comboOperand = comboOperand()
      return a / 2.0.pow(comboOperand)
    }

    fun run() {
      while (true) {
        val opCode = opCode() ?: return
        when (opCode) {
          0 -> {
            val d = advStyleCalculation()
            a = d.toInt()
          }
          1 -> {
            b = b xor literalOperand()
          }
          2 -> {
            val comboOperand = comboOperand()
            b = comboOperand.mod(8)
          }
          3 -> {
            if (a != 0) {
              pointer = literalOperand()
            } else {
              pointer++
            }
          }
          4 -> {
            b = b xor c
            pointer++
          }
          5 -> {
            val comboOperand = comboOperand()
            output.add(comboOperand.mod(8))
          }
          6 -> {
            val d = advStyleCalculation()
            b = d.toInt()
          }
          7 -> {
            val d = advStyleCalculation()
            c = d.toInt()
          }
          else -> error("Invalid opCode $opCode")
        }
      }
    }

    companion object {
      fun parse(input: String): Computer = Computer(
        a = input.lines()[0].substringAfterLast(" ").toInt(),
        b = input.lines()[1].substringAfterLast(" ").toInt(),
        c = input.lines()[2].substringAfterLast(" ").toInt(),
        program = input.lines()[4].substringAfterLast(" ")
          .split(",").map(String::toInt),
      )
    }
  }

  override fun solvePart1(input: String): List<Int> {
    val computer = Computer.parse(input)
    computer.run()
    return computer.output
  }

  override fun solvePart2(input: String): Int {
    TODO()
  }
}
