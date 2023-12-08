package aoc.year2023

import aoc.library.Puzzle
import aoc.library.lcm
import aoc.year2023.SandMap.Direction.Left
import aoc.year2023.SandMap.Direction.Right

object Day8 : Puzzle<Int, Long>(year = 2023, day = 8) {

  override fun solvePart1(input: String): Int {
    return SandMap.parse(input)
      .steps(from = "AAA", to = { it == "ZZZ" })
  }

  override fun solvePart2(input: String): Long {
    val sandMap = SandMap.parse(input)
    val steps = sandMap.nodes.keys
      .filter { it.endsWith('A') }
      .map { start ->
        sandMap.steps(
          from = start,
          to = { it.endsWith('Z') },
        )
      }
    return lcm(steps.map { it.toLong() })
  }
}

private data class SandMap(
  val instructions: List<Direction>,
  val nodes: Map<String, Map<Direction, String>>,
) {

  fun position(
    from: String,
    direction: Direction,
  ): String {
    return nodes.getValue(from).getValue(direction)
  }

  fun instructions(): Sequence<Direction> {
    return sequence {
      while (true) {
        yieldAll(instructions)
      }
    }
  }

  fun steps(
    from: String,
    to: (String) -> Boolean,
  ): Int {
    return instructions().runningFold(from, ::position)
      .takeWhile { !to(it) }.count()
  }

  enum class Direction { Left, Right }

  companion object {
    private val pathRegex = """^(.*?) = \((.*?), (.*?)\)$""".toRegex()
    fun parse(input: String): SandMap {
      val lines = input.lines()
      return SandMap(
        instructions = lines.first()
          .map {
            when (it) {
              'L' -> Left
              'R' -> Right
              else -> error("Invalid direction=$it")
            }
          },
        nodes = lines.drop(2).associate {
          val (from, left, right) = pathRegex.find(it)!!.destructured
          from to mapOf(Left to left, Right to right)
        },
      )
    }
  }
}
