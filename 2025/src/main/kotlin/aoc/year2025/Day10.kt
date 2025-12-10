package aoc.year2025

import aoc.library.Puzzle

object Day10 : Puzzle<Int, Long>(day = 10) {

  override fun solvePart1(input: String): Int {
    val machines = input.lines().map(Machine::parse)
    return machines
      .mapIndexed { index, machine ->
        println("machine $index / ${machines.size}")
        var min = Int.MAX_VALUE
        fun push(
          pressed: Int,
          state: Int,
          wiring: List<Int>,
        ) {
          if (pressed >= min) return
          if (state == machine.lightDiagram) {
            min = pressed
            return
          }
          wiring.forEach { button ->
            push(
              pressed = pressed + 1,
              state = state xor button,
              wiring = wiring - button,
            )
          }
        }
        push(pressed = 0, state = 0, wiring = machine.wiring)
        min
      }
      .sum()
  }

  override fun solvePart2(input: String): Long {
    TODO()
  }

  private data class Machine(val lightDiagram: Int, val wiring: List<Int>, val joltageRequirements: List<List<Int>>) {

    companion object {
      fun parse(input: String): Machine {
        val lightDiagram = input
          .drop(1)
          .substringBefore(']')
          .map {
            when (it) {
              '.' -> false
              '#' -> true
              else -> error("Invalid $it")
            }
          }
          .foldIndexed(0) { index, acc, on ->
            if (on) acc or (1 shl index) else acc
          }
        val wiring = """\((.*?)\)""".toRegex()
          .findAll(input)
          .flatMap { result ->
            result.destructured.toList().map { values ->
              values.split(",").map(String::toInt)
            }
          }
          .map { indices ->
            indices.fold(0) { acc, buttonIndex ->
              acc or (1 shl buttonIndex)
            }
          }
          .toList()
        val joltageRequirements: List<List<Int>> = """\{(.*?)}$""".toRegex()
          .find(input)!!.destructured
          .toList()
          .map {
            it.split(",").map(String::toInt)
          }
        return Machine(
          lightDiagram = lightDiagram,
          wiring = wiring,
          joltageRequirements = joltageRequirements,
        )
      }
    }
  }
}
