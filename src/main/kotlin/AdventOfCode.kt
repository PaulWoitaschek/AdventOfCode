fun day1(input: Sequence<String>): Int {
  return input.map { it.toInt() }
    .windowed(2)
    .count { (previous, current) ->
      current > previous
    }
}

fun day1PartTwo(input: Sequence<String>): Int {
  return input.map { it.toInt() }
    .windowed(size = 3)
    .map { it.sum() }
    .windowed(2)
    .count { (previous, current) ->
      current > previous
    }
}
