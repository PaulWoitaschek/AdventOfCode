package aoc.year2024

import aoc.library.Puzzle

object Day24 : Puzzle<Long, Long>(day = 24) {

  override fun solvePart1(input: String): Long {
    val (wiresValue, gatesValue) = input.split("\n\n")
    val wires = wiresValue.lines().associate {
      val (name, value) = it.split(": ")
      name to (value == "1")
    }.toMutableMap()
    val gates = gatesValue.lines().map(Gate::parse)

    while (true) {
      val solvableGate = gates.firstOrNull { gate ->
        gate.left in wires && gate.right in wires && gate.output !in wires
      } ?: break
      wires[solvableGate.output] = solvableGate.operator(wires.getValue(solvableGate.left), wires.getValue(solvableGate.right))
    }

    return wires.filterKeys { it.startsWith("z") }
      .toSortedMap()
      .values
      .reversed()
      .joinToString("") {
        if (it) "1" else "0"
      }
      .toLong(2)
  }

  data class Gate(val left: String, val right: String, val operator: Operator, val output: String) {
    companion object {
      // ntg XOR fgs -> mjb
      fun parse(input: String): Gate {
        val elements = input.split(" ")
        return Gate(elements[0], elements[2], Operator.parse(elements[1]), elements[4])
      }
    }
  }

  enum class Operator {
    Xor,
    Or,
    And,
    ;

    operator fun invoke(
      left: Boolean,
      right: Boolean,
    ): Boolean = when (this) {
      Xor -> left xor right
      Or -> left or right
      And -> left and right
    }

    companion object {
      fun parse(input: String): Operator = entries.find { it.name.equals(input, ignoreCase = true) }
        ?: error("Invalid operator=$input")
    }
  }

  override fun solvePart2(input: String): Long {
    TODO()
  }
}
