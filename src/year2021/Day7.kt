package year2021

import utils.Puzzle
import kotlin.math.abs

object Day7 : Puzzle<Long, Long>(2021, 7) {

  override fun solvePart1(input: String): Long {
    return solve(input) { it }
  }

  override fun solvePart2(input: String): Long {
    return solve(input) { (it * (it + 1)) / 2 }
  }
}

private inline fun solve(
  input: String,
  fuelCostPerDistance: (Long) -> Long,
): Long {
  val positions = input.split(",").map(String::toLong)
  return (positions.minOf { it }.rangeTo(positions.maxOf { it }))
    .minOf { candidate ->
      positions.map { abs(candidate - it) }
        .sumOf(fuelCostPerDistance)
    }
}
