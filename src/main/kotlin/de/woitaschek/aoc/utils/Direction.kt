package de.woitaschek.aoc.utils

enum class Direction(var char: Char) {
  Left('L'), Up('U'), Right('R'), Down('D');

  fun clockwise(): Direction {
    return values().getOrNull(ordinal + 1) ?: values().first()
  }

  fun counterClockwise(): Direction {
    return values().getOrNull(ordinal - 1) ?: values().last()
  }

  companion object {
    fun parse(input: Char) = values().first { it.char == input }
  }
}
