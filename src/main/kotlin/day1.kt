@file:Suppress("ConvertCallChainIntoSequence")

fun day1(input: String): Int {
  return input.lines().map { it.toInt() }
    .windowed(2)
    .count { (previous, current) ->
      current > previous
    }
}

fun day1Part2(input: String): Int {
  return input.lines().map { it.toInt() }
    .windowed(size = 3)
    .map { it.sum() }
    .windowed(2)
    .count { (previous, current) ->
      current > previous
    }
}
