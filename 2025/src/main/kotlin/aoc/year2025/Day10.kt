package aoc.year2025

import aoc.library.Puzzle

object Day10 : Puzzle<Int, Long>(day = 10) {

  override fun solvePart1(input: String): Int {
    val machines = input.lines().map(Machine::parse)
    return machines
      .mapIndexed { index, machine ->
        println("machine $index / ${machines.size}")
        val wiring = machine.wiring
        var min = Int.MAX_VALUE
        fun push(
          pressed: Int,
          state: List<Boolean>,
          wiring: List<List<Int>>,
        ) {
          if (pressed >= min) return
          if (state == machine.lightDiagram) {
            min = pressed
            return
          }
          wiring.forEach { button ->
            push(
              pressed = pressed + 1,
              state = state.toMutableList()
                .also { n ->
                  button.forEach {
                    n[it] = !n[it]
                  }
                },
              wiring = wiring.toMutableList()
                .apply {
                  remove(button)
                },
            )
          }
        }
        push(pressed = 0, state = machine.lightDiagram.map { false }, wiring = wiring)
        min
      }
      .sum()
  }

  override fun solvePart2(input: String): Long {
    TODO()
  }

  private data class Machine(val lightDiagram: List<Boolean>, val wiring: List<List<Int>>, val joltageRequirements: List<List<Int>>) {

    companion object {
      fun parse(input: String): Machine {
        val lightDiagram: List<Boolean> = input
          .drop(1)
          .substringBefore(']')
          .map {
            when (it) {
              '.' -> false
              '#' -> true
              else -> error("Invalid $it")
            }
          }
        val wiring: List<List<Int>> = """\((.*?)\)""".toRegex()
          .findAll(input)
          .flatMap { result ->
            result.destructured.toList().map { values ->
              values.split(",").map(String::toInt)
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
