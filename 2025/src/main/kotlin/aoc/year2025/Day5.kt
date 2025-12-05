package aoc.year2025

import aoc.library.Puzzle

object Day5 : Puzzle<Int, Long>(day = 5) {

  override fun solvePart1(input: String): Int {
    val (fresh, availableProducts) = parse(input)
    return availableProducts.count { available ->
      fresh.any {
        available in it
      }
    }
  }

  private fun parse(input: String): Pair<List<LongRange>, List<Long>> {
    val (freshString, availableString) = input.split("\n\n")
    val fresh = freshString.lines()
      .map {
        val (from, to) = it.split("-").map(String::toLong)
        from..to
      }
    val availableProducts = availableString.lines().map(String::toLong)
    return fresh to availableProducts
  }

  override fun solvePart2(input: String): Long {
    var ranges = parse(input).first.toSet()
    while (true) {
      val reduced = reduce(ranges)
      if (ranges != reduced) {
        ranges = reduced
      } else {
        return ranges.sumOf {
          it.last - it.first + 1
        }
      }
    }
  }

  fun reduce(ranges: Set<LongRange>): Set<LongRange> {
    ranges.forEach { r1 ->
      ranges.forEach { r2 ->
        if (r1 != r2) {
          val combined = tryCombine(r1, r2)
          if (combined != null) {
            val result = ranges.toMutableSet()
            result.remove(r1)
            result.remove(r2)
            result.add(combined)
            return result
          }
        }
      }
    }
    return ranges
  }

  private fun tryCombine(
    r1: LongRange,
    r2: LongRange,
  ): LongRange? {
    val (firstRange, secondRange) = if (r1.first < r2.first) r1 to r2 else r2 to r1
    return if (firstRange.last >= secondRange.first) {
      firstRange.first..maxOf(firstRange.last, secondRange.last)
    } else {
      null
    }
  }
}
