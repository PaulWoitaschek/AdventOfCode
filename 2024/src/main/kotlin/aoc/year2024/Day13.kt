package aoc.year2024

import aoc.library.Point
import aoc.library.Puzzle

object Day13 : Puzzle<Long, Long>(day = 13) {

  override fun solvePart1(input: String): Long = solve(input, prizeAddition = 0)

  override fun solvePart2(input: String): Long = solve(input, prizeAddition = 10000000000000)

  private fun solve(
    input: String,
    prizeAddition: Long,
  ): Long = parse(input).sumOf { it.solve(prizeAddition) }

  private fun parse(input: String): List<ClawMachine> {
    val buttonRegex = """Button .: X\+(\d+), Y\+(\d+)""".toRegex()
    fun String.parseAsButton(): Point {
      val (x, y) = buttonRegex.find(this)!!.destructured
      return Point(x.toInt(), y.toInt())
    }

    val prizeRegex = """Prize: X=(\d+), Y=(\d+)""".toRegex()
    fun String.parseAsPrize(): Point {
      val (x, y) = prizeRegex.find(this)!!.destructured
      return Point(x.toInt(), y.toInt())
    }
    return input.split("\n\n").map {
      val (a, b, prize) = it.lines()
      ClawMachine(aButton = a.parseAsButton(), bButton = b.parseAsButton(), prize = prize.parseAsPrize())
    }
  }

  private data class ClawMachine(val aButton: Point, val bButton: Point, val prize: Point) {

    fun solve(prizeAddition: Long): Long {
      val px = prize.x + prizeAddition
      val py = prize.y + prizeAddition
      val b = (py * aButton.x - aButton.y * px) / (-aButton.y * bButton.x + aButton.x * bButton.y)
      val a = (px - bButton.x * b) / aButton.x
      return if (a * aButton.x + b * bButton.x == px && a * aButton.y + b * bButton.y == py) {
        a * 3 + b
      } else {
        0
      }
    }
  }
}
