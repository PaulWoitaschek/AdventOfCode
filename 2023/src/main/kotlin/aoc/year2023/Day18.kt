package aoc.year2023

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.move
import kotlin.math.ceil

object Day18 : Puzzle<Int, Int>(day = 18) {

  override fun solvePart1(input: String): Int {
    val instructions = input.lines().map(Instruction::parse)

    val points = instructions.runningFold(Point.Zero) { point, instruction ->
      point.move(instruction.direction, instruction.steps)
    }

    val border = mutableListOf(Point.Zero)
    instructions.forEach { instruction ->
      repeat(instruction.steps) {
        border.add(border.last().move(instruction.direction))
      }
    }
    return ceil((polygonSize(points) * 2 + border.size) / 2f).toInt()
  }

  private fun polygonSize(points: List<Point>): Int {
    val a = points.map { it.x }.zip(points.drop(1).map { it.y }) { x, y -> x * y }
    val b = points.map { it.x }.drop(1).zip(points.map { it.y }) { x, y -> x * y }
    return a.zip(b) { l, r -> l - r }.sum() / 2
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
