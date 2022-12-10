package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.utils.Puzzle

object Day10 : Puzzle(2022, 10) {

  override fun solvePart1(input: String): Int {
    var signalStrength = 0
    runCycles(input) { x, cycle ->
      if (cycle.rem(40) == 20) {
        signalStrength += cycle * x
      }
    }
    return signalStrength
  }

  override fun solvePart2(input: String): String {
    val drawAt = mutableSetOf<Int>()
    runCycles(input) { x, cycle ->
      if ((cycle - 1) % 40 in x - 1..x + 1) {
        drawAt.add(cycle - 1)
      }
    }
    return (0 until 240).chunked(40).joinToString(separator = "\n") { indexes ->
      indexes.joinToString(separator = "") { index ->
        if (index in drawAt) "█" else " "
      }
    }
  }

  private fun runCycles(input: String, onCycle: (x: Int, cycle: Int) -> Unit) {
    var x = 1
    var cycle = 0
    fun runCycle() {
      cycle++
      onCycle(x, cycle)
    }
    input.lines().filter { it.isNotEmpty() }.forEach { instruction ->
      if (instruction == "noop") {
        runCycle()
      } else {
        runCycle()
        runCycle()
        x += instruction.removePrefix("addx ").toInt()
      }
    }
  }
}
