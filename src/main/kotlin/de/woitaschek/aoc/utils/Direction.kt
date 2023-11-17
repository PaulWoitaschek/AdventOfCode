package de.woitaschek.aoc.utils

enum class Direction(var char: Char) {
  Left('L'),
  Up('U'),
  Right('R'),
  Down('D'),
  ;

  fun clockwise(): Direction {
    return entries.getOrNull(ordinal + 1) ?: entries.first()
  }

  fun counterClockwise(): Direction {
    return entries.getOrNull(ordinal - 1) ?: entries.last()
  }

  companion object {
    fun parse(input: Char) = entries.first { it.char == input }
  }
}
