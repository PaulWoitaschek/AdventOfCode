package aoc.library

enum class Direction(var char: Char) {
  Left('L'),
  Up('U'),
  Right('R'),
  Down('D'),
  ;

  fun clockwise(): Direction {
    return entries[(ordinal + 1) % entries.size]
  }

  fun counterClockwise(): Direction {
    return entries[(ordinal + entries.size - 1) % entries.size]
  }

  fun opposite(): Direction = when (this) {
    Left -> Right
    Right -> Left
    Up -> Down
    Down -> Up
  }

  companion object {
    private val byChar = entries.associateBy { it.char }
    fun parse(input: Char): Direction {
      return byChar[input] ?: throw IllegalArgumentException("Invalid char=$input")
    }
  }
}
