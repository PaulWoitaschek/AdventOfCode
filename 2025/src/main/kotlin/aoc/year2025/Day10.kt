package aoc.year2025

import aoc.library.Puzzle
import java.util.PriorityQueue

object Day10 : Puzzle<Int, Long>(day = 10) {

  override fun solvePart1(input: String): Int =
    input.lines().map(Machine::parse).sumOf { machine ->
      var min = Int.MAX_VALUE

      data class Task(val pressed: Int, val state: Int)

      val queue = PriorityQueue<Task>(compareBy { it.pressed })
      queue.add(Task(pressed = 0, state = 0))

      while (queue.isNotEmpty()) {
        val item = queue.remove()

        if (item.pressed >= min) continue
        if (item.state == machine.lightDiagram) {
          min = item.pressed
          continue
        }
        machine.wiring.forEachIndexed { index, button ->
          if (index >= item.pressed) {
            queue.add(Task(pressed = item.pressed + 1, state = item.state xor button))
          }
        }
      }
      min
    }

  override fun solvePart2(input: String): Long {
    TODO()
  }

  private data class Machine(
    val lightDiagram: Int,
    val wiring: List<Int>,
    val joltageRequirements: List<List<Int>>,
  ) {

    companion object {
      fun parse(input: String): Machine {
        val lightDiagram =
          input
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
        val wiring =
          """\((.*?)\)"""
            .toRegex()
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
        val joltageRequirements: List<List<Int>> =
          """\{(.*?)}$""".toRegex().find(input)!!.destructured.toList().map {
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
