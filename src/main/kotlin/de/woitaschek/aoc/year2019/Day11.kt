package de.woitaschek.aoc.year2019

import de.woitaschek.aoc.utils.Direction
import de.woitaschek.aoc.utils.Point
import de.woitaschek.aoc.utils.Puzzle
import de.woitaschek.aoc.utils.move
import de.woitaschek.aoc.utils.printString
import de.woitaschek.aoc.utils.toCommaSeparatedLongList
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object Day11 : Puzzle<Int, String>(2019, 11) {

  override fun solvePart1(input: String): Int = process(input, 0).size

  override fun solvePart2(input: String): String {
    val coloredArea = process(input, 1)
    return coloredArea.filterValues { it == Color.White }.keys.printString()
  }

  private fun process(
    input: String,
    initialInput: Int,
  ): Map<Point, Color> = runBlocking {
    val inputs = Channel<Long>(UNLIMITED)
      .also { it.send(initialInput.toLong()) }

    val computer = IntCodeComputer(input.toCommaSeparatedLongList(), inputs)
    val coloredArea = mutableMapOf<Point, Color>()
    val colorJob = launch {
      var robotPosition = Point(0, 0)
      var facing = Direction.Up
      while (true) {
        val colorValue = computer.outputs.receive()
        val color = Color.parse(colorValue)
        val turnLeft = computer.outputs.receive() == 0L
        coloredArea[robotPosition] = color
        facing = if (turnLeft) facing.counterClockwise() else facing.clockwise()
        robotPosition = robotPosition.move(facing, upIsPositive = false)

        inputs.send(
          if (coloredArea[robotPosition] == Color.White) 1 else 0,
        )
      }
    }
    computer.run()
    colorJob.cancel()

    coloredArea
  }

  enum class Color {
    White,
    Black,
    ;

    companion object {
      fun parse(value: Long): Color {
        return when (value) {
          0L -> Black
          1L -> White
          else -> error("Invalid color=$value")
        }
      }
    }
  }
}
