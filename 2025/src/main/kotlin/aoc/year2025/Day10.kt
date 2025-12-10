package aoc.year2025

import aoc.library.Puzzle

object Day10 : Puzzle<Long, Long>(day = 10) {

  override fun solvePart1(input: String): Long {
    return input.lines()
      .map(Machine::parse)
      .map { machine ->
        val wiring = machine.wiring
        var min = Int.MAX_VALUE
        fun push(pressed: Set<List<Int>>) {
          if (pressed.size >= min) return
          val state = machine.lightDiagram.map { false }.toMutableList()
          pressed.forEach { button ->
            button.forEach {
              state[it] = !state[it]
            }
          }
          if (state == machine.lightDiagram) {
            min = pressed.size
            return
          }
          wiring.forEach { button ->
            val newState = pressed.toMutableSet()
            if (newState.add(button)) {
              push(newState)
            }
          }
        }
        wiring.forEach {
          push(setOf(it))
        }
        min
      }
      .sum().toLong()
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
