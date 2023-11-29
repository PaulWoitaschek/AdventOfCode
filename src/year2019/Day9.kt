package year2019

import kotlinx.coroutines.runBlocking
import utils.Puzzle
import utils.toCommaSeparatedLongList

object Day9 : Puzzle<Long, Long>(2019, 9) {

  override fun solvePart1(input: String): Long {
    val values = input.toCommaSeparatedLongList()
    val computer = IntCodeComputer(instructions = values, inputs = listOf(1))
    runBlocking {
      computer.run()
    }
    return computer.concatFullOutput
  }

  override fun solvePart2(input: String): Long {
    val values = input.toCommaSeparatedLongList()
    val computer = IntCodeComputer(instructions = values, inputs = listOf(2))
    runBlocking {
      computer.run()
    }
    return computer.concatFullOutput
  }
}
