package aoc.year2023

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.move

object Day18 : Puzzle<Int, Int>(day = 18) {

  override fun solvePart1(input: String): Int {
    val instructions = input.lines().map(Instruction::parse)
    val points = instructions.runningFold(Point.Zero) { point, instruction ->
      point.move(instruction.direction, instruction.steps)
    }
    val borderSize = instructions.sumOf { it.steps }
    return polygonSize(points) + borderSize / 2 + 1
  }

  private fun polygonSize(points: List<Point>): Int {
    val positive = points.zip(points.drop(1)) { left, right -> left.x * right.y }
    val negative = points.drop(1).zip(points) { left, right -> left.x * right.y }
    return positive.zip(negative) { l, r -> l - r }.sum() / 2
  }

  override fun solvePart2(input: String): Int {
    TODO()
  }

  private data class Instruction(
    val direction: Direction,
    val steps: Int,
    val color: String,
  ) {
    companion object {

      private val regex = """(\w) (\d+) \((.*?)\)""".toRegex()
      fun parse(input: String): Instruction {
        val (direction, steps, color) = regex.find(input)!!.destructured
        return Instruction(Direction.parse(direction.single()), steps.toInt(), color)
      }
    }
  }
}
