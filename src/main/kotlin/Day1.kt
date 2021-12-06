@file:Suppress("ConvertCallChainIntoSequence")

object Day1 : Puzzle {

  override val day = 1

  override fun solvePart1(input: String): Int {
    return input.lines().map { it.toInt() }
      .windowed(2)
      .count { (previous, current) ->
        current > previous
      }
  }

  override fun solvePart2(input: String): Int {
    return input.lines().map { it.toInt() }
      .windowed(size = 3)
      .map { it.sum() }
      .windowed(2)
      .count { (previous, current) ->
        current > previous
      }
  }
}
