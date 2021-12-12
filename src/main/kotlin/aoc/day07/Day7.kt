package aoc.day07

import aoc.Puzzle
import kotlin.math.abs

object Day7 : Puzzle {

  override val day = 7

  override fun solvePart1(input: String): Long {
    return solve(input) { it }
  }

  override fun solvePart2(input: String): Long {
    return solve(input) { (it * (it + 1)) / 2 }
  }
}

private inline fun solve(input: String, fuelCostPerDistance: (Long) -> Long): Long {
  val positions = input.split(",").map(String::toLong)
  return (positions.minOf { it }..positions.maxOf { it })
    .minOf { candidate ->
      positions.map { abs(candidate - it) }
        .sumOf(fuelCostPerDistance)
    }
}
