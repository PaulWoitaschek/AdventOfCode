package aoc.day13

import aoc.Point
import aoc.Puzzle
import kotlin.math.abs

object Day13 : Puzzle {
  override val day: Int = 13

  override fun solvePart1(input: String): Long {
    val (points, instructions) = parse(input)
    val firstInstruction = instructions.first()
    return points.map { it.followInstruction(firstInstruction) }
      .toSet()
      .count()
      .toLong()
  }

  override fun solvePart2(input: String): String {
    val (points, instructions) = parse(input)
    return instructions.fold(points) { grid, instruction ->
      grid.map { it.followInstruction(instruction) }.toSet()
    }.toSet().printString()
  }
}

private fun Point.followInstruction(instruction: FoldingInstruction): Point {
  return if (instruction.foldVertically) {
    foldY(instruction.coordinate)
  } else {
    foldX(instruction.coordinate)
  }
}

private fun Point.foldX(x: Int): Point {
  return if (this.x <= x) this else Point(x - abs(this.x - x), y)
}

private fun Point.foldY(y: Int): Point {
  return if (this.y <= y) this else Point(x, y - abs(this.y - y))
}

private fun Set<Point>.printString(): String {
  val points = this
  return buildString {
    repeat(points.maxOf { it.y } + 1) { y ->
      appendLine(
        (0..(points.maxOf { it.x } + 1)).map { x -> Point(x, y) }
          .joinToString(separator = "") { if (it in points) "█" else " " }
          .trim()
      )
    }
  }
}


private fun parse(input: String): Pair<Set<Point>, List<FoldingInstruction>> {
  val lines = input.lines()
  val points = lines.takeWhile { it.isNotEmpty() }
    .map {
      val (x, y) = it.split(",")
      Point(x.toInt(), y.toInt())
    }
    .toSet()
  val foldRegex = "fold along (.*?)=(.*)".toRegex()
  val foldInstructions = lines.reversed().takeWhile { it.isNotEmpty() }
    .mapNotNull {
      val result = foldRegex.find(it)
      if (result != null) {
        val (axis, value) = result.groupValues.drop(1)
        FoldingInstruction(
          foldVertically = when (axis) {
            "x" -> false
            "y" -> true
            else -> error("Invalid axis=$axis")
          }, coordinate = value.toInt()
        )
      } else {
        null
      }
    }
    .reversed()

  return points to foldInstructions
}


data class FoldingInstruction(
  val foldVertically: Boolean,
  val coordinate: Int
)