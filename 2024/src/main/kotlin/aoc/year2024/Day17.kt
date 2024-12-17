package aoc.year2024

import aoc.library.Puzzle
import kotlin.math.pow

object Day17 : Puzzle<List<Int>, Int>(day = 17) {

  override fun solvePart1(input: String): List<Int> = Computer.parse(input).run()

  override fun solvePart2(input: String): Int {
    val computer = Computer.parse(input)
    var i = 0
    while (true) {
      i++
      val result = computer.copy(a = i).run()
      if (result == computer.program) {
        return i
      }
    }
  }

  data class Computer(var a: Int, var b: Int, var c: Int, val program: List<Int>, var pointer: Int = 0) {

    private fun literalOperand(): Int = program[pointer + 1]

    private fun comboOperand(): Int = when (val value = program[pointer + 1]) {
      0, 1, 2, 3 -> value
      4 -> a
      5 -> b
      6 -> c
      else -> error("Invalid operand $value")
    }

    private fun advStyleCalculation(): Int = a / 2.0.pow(comboOperand()).toInt()

    fun run(): List<Int> {
      val output = mutableListOf<Int>()
      while (true) {
        val opCode = program.getOrNull(pointer)
          ?: return output
        when (opCode) {
          0 -> a = advStyleCalculation()
          1 -> b = b xor literalOperand()
          2 -> b = comboOperand().mod(8)
          3 -> if (a != 0) {
            pointer = literalOperand()
            continue
          }
          4 -> b = b xor c
          5 -> output += comboOperand().mod(8)
          6 -> b = advStyleCalculation()
          7 -> c = advStyleCalculation()
          else -> error("Invalid opCode $opCode")
        }
        pointer += 2
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
}
