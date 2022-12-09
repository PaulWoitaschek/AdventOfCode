package de.woitaschek.aoc.utils

enum class Direction(var char: Char) {
  Left('L'), Right('R'), Up('U'), Down('D');

  companion object {
    fun parse(input: Char) = values().first { it.char == input }
  }
}
